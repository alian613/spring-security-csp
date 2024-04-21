package com.alian.security.csp;

public class FontSrcDirective extends ContentSecurityPolicyDirective {

    public FontSrcDirective(ContentSecurityPolicyBuilder contentSecurityPolicyBuilder) {
        super(contentSecurityPolicyBuilder, "font-src");
    }
}
