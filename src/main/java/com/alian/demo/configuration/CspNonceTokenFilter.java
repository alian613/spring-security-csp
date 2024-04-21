package com.alian.demo.configuration;

import com.alian.security.csp.nonce.CspNonceRepository;
import com.alian.security.csp.nonce.CspNonceToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CspNonceTokenFilter extends OncePerRequestFilter {

    CspNonceRepository cspNonceRepository;
    CspNonceToken cspNonceToken;
    public CspNonceTokenFilter(CspNonceRepository cspNonceRepository, CspNonceToken cspNonceToken) {
        this.cspNonceRepository = cspNonceRepository;
        this.cspNonceToken = cspNonceToken;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        this.cspNonceRepository.saveToken(this.cspNonceToken, request);
        filterChain.doFilter(request, response);
    }
}
