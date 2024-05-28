package com.factory;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.nio.file.Path;

public interface AbstractFactory {
    HtmlDocument createHtml(String md);

    WordDocument createWord(String md);
}

