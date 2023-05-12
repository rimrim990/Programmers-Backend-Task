package project.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {
    @Test
    void write() throws IOException {
        FileUtil.write("data/output", "user.json", "test");
    }
}