package com.alian.security.csp.nonce;

import com.alian.security.csp.DefaultCspNonceToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.security.SecureRandom;
import java.util.Base64;

public class CspNonceRepository {
    private static final String DEFAULT_CSRF_PARAMETER_NAME = "_csp_nonce";

    private static final String DEFAULT_CSRF_HEADER_NAME = "X-CSP-NONCE";

    private static final String DEFAULT_CSRF_TOKEN_ATTR_NAME = CspNonceRepository.class.getName()
            .concat(".NONCE_TOKEN");

    private final String sessionAttributeName = DEFAULT_CSRF_TOKEN_ATTR_NAME;

    public void saveToken(CspNonceToken token, HttpServletRequest request) {
        if (token == null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.removeAttribute(this.sessionAttributeName);
            }
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute(this.sessionAttributeName, token);
        }
    }

    public CspNonceToken loadToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (CspNonceToken) session.getAttribute(this.sessionAttributeName);
    }

    public CspNonceToken generateToken() {
        return new DefaultCspNonceToken(DEFAULT_CSRF_HEADER_NAME, DEFAULT_CSRF_PARAMETER_NAME, createNewToken());
    }

    private String createNewToken() {
        SecureRandom random = new SecureRandom();
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        return Base64.getEncoder().encodeToString(nonceBytes);
    }
}
