package com.allen.springframework.filter;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyOncePerRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String allen = request.getParameter("allen");
        System.out.println(allen);
        if(StringUtils.isEmpty(allen) || !"xxx".equalsIgnoreCase(allen)) {
            throw new ServletException("过滤了。。。");
        }
        filterChain.doFilter(request,response);
    }
}
