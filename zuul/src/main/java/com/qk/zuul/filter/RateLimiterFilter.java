package com.qk.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.qk.zuul.exception.RateLimiterException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-12 15:36
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

    /**
     * 每秒钟放入100个令×××
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);


    @Override
    public String filterType() {
        // 限流肯定是得在Pre类型的过滤器里做
        return PRE_TYPE;

    }

    @Override
    public int filterOrder() {
        // 设置过滤器的优先级为最高
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 尝试从令×××桶中获取令×××
        if (!RATE_LIMITER.tryAcquire()) {
            // 获取失败抛出异常，或做其他处理
            throw new RateLimiterException();
        }

        return null;
    }
}
