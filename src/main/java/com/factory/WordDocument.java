package com.factory;

import java.io.IOException;
import java.nio.file.Path;

public interface WordDocument {
    String toWord();
    void save(Path path) throws IOException;
}
