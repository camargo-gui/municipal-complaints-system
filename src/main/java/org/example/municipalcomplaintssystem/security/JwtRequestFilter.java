package org.example.municipalcomplaintssystem.security;

import ch.qos.logback.core.LayoutBase;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String token = request.getHeader("Authorization").split(" ")[1];
        System.out.println(token);
        try {
            if(token == null){
                throw new ServletException("Necessário autenticação");
            }
            Claims claims = JwtProvider.getAllClaimsFromToken(token);
            boolean isValid = JwtProvider.verifyToken(claims);
            if(!isValid){
                throw new ServletException("Acesso negado");
            }
            String role = claims.get("nivel", String.class);
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    claims.getSubject(), null, Collections.singletonList(authority));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        } catch (Exception error) {
            response.setStatus(401);
            response.getWriter().write(error.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}

