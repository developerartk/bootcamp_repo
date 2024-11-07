package com.project.study.authenticator;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;

import java.util.EnumSet;

@WebListener
public class WebAppInitializer implements jakarta.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContext servletContext) {
        FilterRegistration.Dynamic jwtFilter = servletContext.addFilter("JwtFilter", new JwtFilter());
        jwtFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    @Override
    public void contextDestroyed(ServletContext servletContext) { }

}
