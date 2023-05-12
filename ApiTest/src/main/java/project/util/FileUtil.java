package project.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    private static final Path ROOT_PATH = Paths.get("");

    // file 에 문자열 작성
    public static void write(String dirPath, String fileName, String content) throws IOException {
        // 디렉터리 경로
        Path absoluteDirPath = getAbsolutePath(dirPath);
        // 파일 생성
        createFile(absoluteDirPath, fileName);
        // 파일 경로
        Path absoluteFilePath = Path.of(absoluteDirPath.toString(), fileName);
        // 파일에 작성
        Files.writeString(absoluteFilePath, content, StandardCharsets.UTF_8);
    }

    // file 절대 경로 변환
    private static Path getAbsolutePath(String filePath) {
        return Path.of(ROOT_PATH.toString(), filePath);
    }

    // 디렉토리 생성
    private static void createDir(Path dirPath) throws IOException {
        System.out.println(ROOT_PATH.toAbsolutePath());
        if (Files.isDirectory(dirPath)) return;
        Files.createDirectory(dirPath);
    }

    // 파일 생성
    private static void createFile(Path dirPath, String fileName) throws IOException {
        createDir(dirPath);
        Path filePath = Path.of(dirPath.toString(), fileName);
        if (Files.exists(filePath)) return;
        Files.createFile(filePath);
    }
}
