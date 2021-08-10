package com.tistory.cookeat.cookeating.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter("/api/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Encoding
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //Request url log
        log.info("[Request URI] :: {}", ((HttpServletRequest)request).getRequestURI());

        chain.doFilter(request, response);
    }
}
