package com.alian.security.csp;

public class ContentSecurityPolicy {
    DefaultSrcDirective defaultSrcDirective;
    ScriptSrcDirective scriptSrcDirective;
    StyleSrcDirective styleSrcDirective;
    FontSrcDirective fontSrcDirective;
    ImageSrcDirective imageSrcDirective;
    String writer;

    public DefaultSrcDirective getDefaultSrcDirective() {
        return defaultSrcDirective;
    }

    public void setDefaultSrcDirective(DefaultSrcDirective defaultSrcDirective) {
        this.defaultSrcDirective = defaultSrcDirective;
    }

    public ScriptSrcDirective getScriptSrcDirective() {
        return scriptSrcDirective;
    }

    public void setScriptSrcDirective(ScriptSrcDirective scriptSrcDirective) {
        this.scriptSrcDirective = scriptSrcDirective;
    }

    public StyleSrcDirective getStyleSrcDirective() {
        return styleSrcDirective;
    }

    public void setStyleSrcDirective(StyleSrcDirective styleSrcDirective) {
        this.styleSrcDirective = styleSrcDirective;
    }

    public FontSrcDirective getFontSrcDirective() {
        return fontSrcDirective;
    }

    public void setFontSrcDirective(FontSrcDirective fontSrcDirective) {
        this.fontSrcDirective = fontSrcDirective;
    }

    public ImageSrcDirective getImageSrcDirective() {
        return imageSrcDirective;
    }

    public void setImageSrcDirective(ImageSrcDirective imageSrcDirective) {
        this.imageSrcDirective = imageSrcDirective;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.defaultSrcDirective != null) {
            builder.append(" ");
            builder.append(this.defaultSrcDirective.getString());
        }

        if (this.scriptSrcDirective != null) {
            builder.append(" ");
            builder.append(this.scriptSrcDirective.getString());
        }

        if (this.styleSrcDirective != null) {
            builder.append(" ");
            builder.append(this.styleSrcDirective.getString());
        }

        if (this.fontSrcDirective != null) {
            builder.append(" ");
            builder.append(this.fontSrcDirective.getString());
        }

        if (this.imageSrcDirective != null) {
            builder.append(" ");
            builder.append(this.imageSrcDirective.getString());
        }

        if (this.writer != null) {
            builder.append(" ");
            builder.append(this.writer);
        }

        return builder.toString();
    }
}

