package com.factory;

import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    private final String md;
    public FastHtmlDocument (String md) {
        this.md = md;
    }
    public String toHtml() {
        return "HTML:" + this.md;
    }

    public void save (Path path) {
        System.out.println("Saved md" + this.md + "to this path" + path);
    }
}
