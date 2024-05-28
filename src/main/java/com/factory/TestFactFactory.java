package com.factory;

import java.io.IOException;
import java.nio.file.Paths;

public class TestFactFactory {
    public static void main(String[] args) throws IOException {
        AbstractFactory factory = new FastFactory();

        HtmlDocument html = factory.createHtml("#标题");

        System.out.println(html.toHtml());
        html.save(Paths.get("/User"));
    }
}
