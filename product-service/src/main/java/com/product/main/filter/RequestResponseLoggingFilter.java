package com.product.main.filter;

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

    private static final Logger logger =
            LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String requestId = UUID.randomUUID()
                .toString()
                .substring(0, 8);

        MDC.put("requestId", requestId);

        long start = System.currentTimeMillis();

        logger.info("Incoming Request | Method={} URI={} ClientIP={}",
                request.getMethod(),
                request.getRequestURI(),
                request.getRemoteAddr());

        try {

            filterChain.doFilter(request, response);

        } finally {

            long end = System.currentTimeMillis();

            logger.info("Outgoing Response | Status={} TimeTaken={} ms",
                    response.getStatus(),
                    (end - start));

            MDC.clear();
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        String uri = request.getRequestURI();

        return uri.equals("/favicon.ico");
    }
}