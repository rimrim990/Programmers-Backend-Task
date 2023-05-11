package project.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    private static final Path ROOT_DIR_PATH = Paths.get("").toAbsolutePath().getParent();
    private static final String BASE_PATH = ROOT_DIR_PATH.toString();

    public static String readFileAsString(String filePath) throws IOException {
        return Files.readString(Paths.get(BASE_PATH, filePath));
    }
}
