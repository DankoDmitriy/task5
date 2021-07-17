package com.danko.multithreading.reader;

import com.danko.multithreading.exception.BusException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader {
    private static Logger logger = LogManager.getLogger();

    public static List<String> readLines(String pathToFile) throws BusException {
        if (pathToFile == null || pathToFile.isBlank()) {
            throw new BusException("Input file paths is NULL...");
        }
        try {
            List<String> buses = Files.readAllLines(Paths.get(pathToFile));
            logger.log(Level.INFO, "Text has been read... from " + pathToFile);
            return buses;
        } catch (IOException e) {
            logger.log(Level.ERROR, "File has not been read..." + e);
            throw new BusException("File has not been read...", e);
        }
    }
}
