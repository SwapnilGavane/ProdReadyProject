package com.telecom.customerservice.filter;


import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    private static final Logger log =
            LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return "/favicon.ico".equals(request.getRequestURI());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String requestId = UUID.randomUUID().toString().substring(0, 8);

        MDC.put("requestId", requestId);

        long startTime = System.currentTimeMillis();

        try {
        	String clientIp = request.getRemoteAddr();

        	if ("0:0:0:0:0:0:0:1".equals(clientIp) || "::1".equals(clientIp)) {
        	    clientIp = "127.0.0.1";
        	}

            log.info("Incoming Request | Method={} URI={} ClientIP={}",
                    request.getMethod(),
                    request.getRequestURI(),
                    clientIp);

            filterChain.doFilter(request, response);

        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            log.info("Outgoing Response | Status={} TimeTaken={} ms",
                    response.getStatus(),
                    executionTime);
            MDC.clear();
        }
    }
}