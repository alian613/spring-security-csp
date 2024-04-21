package com.alian.security.csp;

public class DefaultSrcDirective extends ContentSecurityPolicyDirective {

    public DefaultSrcDirective(ContentSecurityPolicyBuilder contentSecurityPolicyBuilder) {
        super(contentSecurityPolicyBuilder, "default-src");
    }
}
