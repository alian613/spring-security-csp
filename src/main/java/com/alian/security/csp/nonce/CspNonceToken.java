package com.alian.security.csp.nonce;

import java.io.Serializable;

public interface CspNonceToken extends Serializable {

    /**
     * Gets the HTTP header that the CSP nonce is populated on the response and can be placed
     * on requests instead of the parameter. Cannot be null.
     * @return the HTTP header that the CSP nonce is populated on the response and can be
     * placed on requests instead of the parameter
     */
    String headerName();

    /**
     * Gets the HTTP parameter name that should contain the token. Cannot be null.
     * @return the HTTP parameter name that should contain the token.
     */
    String parameterName();

    /**
     * Gets the nonce value. Cannot be null.
     * @return the nonce value
     */
    String token();
}

