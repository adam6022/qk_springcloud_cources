package com.qk.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 * token过滤器
 * @author yd
 * @create 2019-03-12 15:21
 */

@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // 声明过滤器的类型为Pre
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 将这个过滤器的优先级放在 PRE_DECORATION_FILTER_ORDER 之前，数字越小优先级越高
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        // 开启这个过滤器
        return true;
    }

    /**
     * 这个方法用于自定义过滤器的处理代码
     *
     * @return Object
     * @throws ZuulException ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 从上下文中拿到请求对象
        HttpServletRequest request = requestContext.getRequest();

        // 拿出参数里的token
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            // 验证失败
            requestContext.setSendZuulResponse(false);
            // 返回401权限不通过
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }

}
