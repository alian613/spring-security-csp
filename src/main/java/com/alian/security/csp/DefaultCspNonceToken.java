package com.alian.security.csp;

import com.alian.security.csp.nonce.CspNonceToken;
import org.springframework.util.Assert;

public record DefaultCspNonceToken(String headerName, String parameterName, String token) implements CspNonceToken {

    /**
     * Creates a new instance
     *
     * @param headerName    the HTTP header name to use
     * @param parameterName the HTTP parameter name to use
     * @param token         the value of the token (i.e. expected value of the HTTP parameter of
     *                      parametername).
     */
    public DefaultCspNonceToken {
        Assert.hasLength(headerName, "headerName cannot be null or empty");
        Assert.hasLength(parameterName, "parameterName cannot be null or empty");
        Assert.hasLength(token, "token cannot be null or empty");
    }
}
