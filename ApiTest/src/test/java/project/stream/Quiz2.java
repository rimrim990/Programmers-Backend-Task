package project.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Quiz2 {
    List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    @Test
    void 문제1번() {
        Map<String, Integer> res = WORDS.stream()
                .map(w -> w.substring(0, 1))
                .collect(Collectors.toMap(
                        prefix -> prefix, // keyMapper
                        prefix ->  1, // valueMapper
                        (oldValue, newValue) -> (newValue += oldValue) // mergeFunction
                ));
        assertTrue(res.get("T").compareTo(1) == 0);
    }

    @Test
    void 문제2번() {
        String res = WORDS.stream()
                .filter(w -> w.length() >= 2)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));
        assertEquals(res, "T H A N K");
    }
}
