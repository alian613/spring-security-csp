package com.alian.security.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentSecurityPolicyDirective {

    ContentSecurityPolicyBuilder contentSecurityPolicyBuilder;
    String clazz;
    String self;
    String unsafeEval;
    String unsafeInline;
    String data;
    List<String> src = new ArrayList<>();
    List<String> hash = new ArrayList<>();
    List<String> nonce = new ArrayList<>();

    public ContentSecurityPolicyDirective(ContentSecurityPolicyBuilder contentSecurityPolicyBuilder, String clazz) {
        this.contentSecurityPolicyBuilder = contentSecurityPolicyBuilder;
        this.clazz = clazz;
    }

    public ContentSecurityPolicyDirective self() {
        this.self = "'self'";
        return this;
    }

    public ContentSecurityPolicyDirective removeSelf() {
        this.self = null;
        return this;
    }

    public ContentSecurityPolicyDirective unsafeEval() {
        this.unsafeEval = "'unsafe-eval'";
        return this;
    }

    public ContentSecurityPolicyDirective removeUnsafeEval() {
        this.unsafeEval = null;
        return this;
    }

    public ContentSecurityPolicyDirective unsafeInline() {
        this.unsafeInline = "'unsafe-inline'";
        return this;
    }

    public ContentSecurityPolicyDirective removeUnsafeInline() {
        this.unsafeInline = null;
        return this;
    }

    public ContentSecurityPolicyDirective data() {
        this.data = "data:";
        return this;
    }

    public ContentSecurityPolicyDirective removeData() {
        this.data = null;
        return this;
    }

    public ContentSecurityPolicyDirective src(String... urlArray) {
        this.src.addAll(Arrays.asList(urlArray));
        return this;
    }

    public ContentSecurityPolicyDirective removeAllSrc(List<String> targetList) {
        this.src.removeAll(targetList);
        return this;
    }

    public ContentSecurityPolicyDirective removeSrc(String target) {
        this.src.removeIf((element) -> element.equals(target));
        return this;
    }

    public ContentSecurityPolicyDirective clearSrc() {
        this.src = new ArrayList<>();
        return this;
    }

    public ContentSecurityPolicyDirective hash(String... hashArray) {
        this.hash.addAll(Arrays.asList(hashArray));
        return this;
    }

    public ContentSecurityPolicyDirective removeAllHash(List<String> targetList) {
        this.hash.removeAll(targetList);
        return this;
    }

    public ContentSecurityPolicyDirective removeHash(String target) {
        this.hash.removeIf((element) -> element.equals(target));
        return this;
    }

    public ContentSecurityPolicyDirective clearHash() {
        this.hash = new ArrayList<>();
        return this;
    }

    public ContentSecurityPolicyDirective nonce(String... nonceArray) {
        this.nonce.addAll(Arrays.asList(nonceArray));
        return this;
    }

    public ContentSecurityPolicyDirective removeAllNonce(List<String> targetList) {
        this.nonce.removeAll(targetList);
        return this;
    }

    public ContentSecurityPolicyDirective removeNonce(String target) {
        this.nonce.removeIf((element) -> element.equals(target));
        return this;
    }

    public ContentSecurityPolicyDirective clearNonce() {
        this.nonce = new ArrayList<>();
        return this;
    }

    public ContentSecurityPolicyBuilder and() {
        return this.contentSecurityPolicyBuilder;
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder(this.clazz);
        if (this.self != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.self);
        }

        if (this.unsafeEval != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.unsafeEval);
        }

        if (this.unsafeInline != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.unsafeInline);
        }

        if (this.data != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.data);
        }

        if (!this.src.isEmpty()) {
            stringBuilder.append(" ");
            for (String url : this.src) {
                stringBuilder.append(url).append(" ");
            }
        }

        if (!this.nonce.isEmpty()) {
            stringBuilder.append(" ");
            for (String nonce : this.nonce) {
                stringBuilder.append("'nonce-").append(nonce).append("' ");
            }
        }

        if (!this.hash.isEmpty()) {
            stringBuilder.append(" ");
            for (String hash : this.hash) {
                stringBuilder.append("hash-").append(hash).append("' ");
            }
        }

        return stringBuilder.append("; ").toString();
    }
}
