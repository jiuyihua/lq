package com.trade.lq.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 下午 2:28
 *  在Webconfig装配Myfilter
 *
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("进入自定义过滤器");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
