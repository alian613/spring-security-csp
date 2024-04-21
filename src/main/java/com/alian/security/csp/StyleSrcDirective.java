package com.alian.security.csp;

public class StyleSrcDirective extends ContentSecurityPolicyDirective {

    public StyleSrcDirective(ContentSecurityPolicyBuilder contentSecurityPolicyBuilder) {
        super(contentSecurityPolicyBuilder, "style-src");
    }
}
