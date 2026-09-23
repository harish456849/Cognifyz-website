package com.cognifyz.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;
    Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        logger.info("jwtService and userDetailsService were injected");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        logger.info(authHeader+" authHeader is recieved");

        if (authHeader == null ||
                !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            logger.info("auth Header is null or no barrier");
            return;
        }

        String token = authHeader.substring(7);
        logger.info(token+" is recieved");

        if (!jwtService.isTokenValid(token)) {

            filterChain.doFilter(request, response);
            logger.info("auth Header token is not valid");
            return;
        }

        String email = jwtService.extractEmail(token);
        logger.info(email+" is extracted from token");

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(email);
        

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
        logger.info(authentication+" is authentication");

        authentication.setDetails(
                new WebAuthenticationDetailsSource()
                        .buildDetails(request)
        );
        logger.info(authentication+" is after setDetails");

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);
        logger.info(SecurityContextHolder.getContext()+" is security context holder context");

        filterChain.doFilter(request, response);
    }
}