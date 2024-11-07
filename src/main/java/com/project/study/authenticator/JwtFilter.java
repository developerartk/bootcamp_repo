package com.project.study.authenticator;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String headerAuth = httpRequest.getHeader("Authorization");

        if (headerAuth != null && headerAuth.startsWith("Bearer")) {
            String jwt = headerAuth.substring(7);
            if (JwtUtils.validateJwtToken(jwt)) {
                String role = JwtUtils.getRoleFromJwtToken(jwt);
                httpRequest.setAttribute("role", role);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    public void init(FilterConfig filterConfig) { }

    @Override
    public void destroy() { }
}
