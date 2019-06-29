package com.kodilla.exception.io;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names").getFile());
        Path path = Paths.get(file.getPath());

        try {
            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);

        } catch (IOException e) {
            throw new FileReaderException();

        } finally {
            System.out.println("I am gonna be here...");
        }
    }
}
