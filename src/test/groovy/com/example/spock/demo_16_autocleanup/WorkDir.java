package com.example.spock.demo_16_autocleanup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkDir {

    private final Path path;

    public WorkDir(final String dir) throws IOException {
        path = Paths.get(dir);
        Files.createDirectories(path);
    }

    public Path getPath() {
        return path;
    }

    public void delete() throws IOException {
        Files.deleteIfExists(path);
    }

}

