package com.alian.security.csp;

public class ScriptSrcDirective extends ContentSecurityPolicyDirective {

    public ScriptSrcDirective(ContentSecurityPolicyBuilder contentSecurityPolicyBuilder) {
        super(contentSecurityPolicyBuilder, "script-src");
    }
}
