package com.hrusch.timetrials.model.util;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;

public class FileReader {

    @SneakyThrows
    public String readFileToString(String filepath) {
        var url = getClass().getResource("/" + filepath);
        if (url == null) {
            throw new FileNotFoundException(filepath);
        }
        return Files.readString(Path.of(url.getPath()));
    }
}
