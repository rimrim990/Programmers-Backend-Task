package project.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    private static final String ROOT_DIR_PATH = Paths.get("").toAbsolutePath()
            .getParent().toString();

    public static String readFileAsString(String filePath) throws IOException {
        Path fullFilePath = getFullFilePath(filePath);
        return Files.readString(fullFilePath);
    }

    private static Path getFullFilePath(String filePath) {
        return Paths.get(ROOT_DIR_PATH, filePath);
    }

    public static boolean writeToFile(String filePath, String fileName, String content) throws IOException {
        Path targetPath = createFile(filePath, fileName);
        // failed to create target file
        if (targetPath == null) return false;

        // write content to target file
        Files.write(targetPath, content.getBytes());
        return true;
    }

    private static Path createFile(String filePath, String fileName) throws IOException {
        // create 'filePath' directory
        Path fullDirPath = getFullFilePath(filePath);
        if (!Files.isDirectory(fullDirPath)) Files.createDirectory(fullDirPath);

        // 'fileName' already exists
        Path fullFilePath = Paths.get(fullDirPath.toString(), fileName);
        if (Files.exists(fullFilePath)) return fullFilePath;

        // create new file
        File file = new File(fullFilePath.toString());
        if (file.createNewFile()) return fullFilePath;
        else return null;
    }
}