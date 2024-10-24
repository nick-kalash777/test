package io;

import models.Bus;
import models.Loadable;
import models.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileDataReader extends DataReader {

    public List<String> loadFile (String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("File not found.");
            return null;
        }
    }
}
