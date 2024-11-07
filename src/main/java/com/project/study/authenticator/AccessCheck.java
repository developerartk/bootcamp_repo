package com.project.study.authenticator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccessCheck {

    public void adminAccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = (String) request.getAttribute("role");

        if ("ADMIN".equals(role)) {
            response.getWriter().write("Admin");
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Access denied.");
        }
    }

    public void userAccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = (String) request.getAttribute("role");

        if ("USER".equals(role)) {
            response.getWriter().write("User");
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Access denied.");
        }
    }

    public void openEndpoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("This endpoint is open to all authenticated users.");
    }
}



