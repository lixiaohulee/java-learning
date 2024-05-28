package com.factory;

import java.nio.file.Path;

public class FastWordDocument implements WordDocument {
    private final String md;
    public FastWordDocument (String md) {
        this.md = md;
    }
    public String toWord() {
        return "WORD:" + this.md;
    }

    public void save (Path path) {
        System.out.println("Saved md" + this.md + "to this path" + path);
    }
}
