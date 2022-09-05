package org.dmu.gameservice.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet-Filter für Cross-Origin Resource Sharing (CORS) Header
 */
@Component
@Order(1)
@SuppressWarnings("unused")
public class HeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader(
                "Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader(
                "Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
