package com.alian.security.csp;

public class ImageSrcDirective extends ContentSecurityPolicyDirective {

    public ImageSrcDirective(ContentSecurityPolicyBuilder contentSecurityPolicyBuilder) {
        super(contentSecurityPolicyBuilder, "img-src");
    }
}
