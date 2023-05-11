package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.*;

import project.utils.FileReader;

public class FileReaderTest {

    String FILE_PATH = "data/input/user.json";

    @Test void readFileAsString() throws IOException {
        String res = FileReader.readFileAsString(FILE_PATH);
        assertEquals(String.class, res.getClass());
        assertTrue(res.length() > 0);
    }
}
