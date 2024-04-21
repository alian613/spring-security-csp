package com.alian.security.csp;

public class ContentSecurityPolicyBuilder {
    DefaultSrcDirective defaultSrcDirective;
    ScriptSrcDirective scriptSrcDirective;
    StyleSrcDirective styleSrcDirective;
    FontSrcDirective fontSrcDirective;
    ImageSrcDirective imageSrcDirective;

    String writer;

    public DefaultSrcDirective defaultSrc() {
        this.defaultSrcDirective = new DefaultSrcDirective(this);
        return this.defaultSrcDirective;
    }

    public ScriptSrcDirective scriptSrc() {
        this.scriptSrcDirective = new ScriptSrcDirective(this);
        return this.scriptSrcDirective;
    }

    public StyleSrcDirective styleSrc() {
        this.styleSrcDirective = new StyleSrcDirective(this);
        return this.styleSrcDirective;
    }

    public StyleSrcDirective getStyleSrcDirective() {
        return this.styleSrcDirective;
    }

    public void setStyleSrcDirective(StyleSrcDirective styleSrcDirective) {
        this.styleSrcDirective = styleSrcDirective;
    }

    public FontSrcDirective fontSrc() {
        this.fontSrcDirective = new FontSrcDirective(this);
        return this.fontSrcDirective;
    }

    public ImageSrcDirective imgSrc() {
        this.imageSrcDirective = new ImageSrcDirective(this);
        return this.imageSrcDirective;
    }

    public ContentSecurityPolicyBuilder writer(String value) {
        this.writer = value;
        return this;
    }

    public ContentSecurityPolicy build() {
        ContentSecurityPolicy contentSecurityPolicy = new ContentSecurityPolicy();
        contentSecurityPolicy.setDefaultSrcDirective(this.defaultSrcDirective);
        contentSecurityPolicy.setScriptSrcDirective(this.scriptSrcDirective);
        contentSecurityPolicy.setStyleSrcDirective(this.styleSrcDirective);
        contentSecurityPolicy.setFontSrcDirective(this.fontSrcDirective);
        contentSecurityPolicy.setImageSrcDirective(this.imageSrcDirective);
        contentSecurityPolicy.setWriter(this.writer);

        return contentSecurityPolicy;
    }
}
