package project.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class Quiz5 {

    String[] strArr = {"aaa","bb","c","dddd"};

    @Test
    void 문제1번() {
        int res = Arrays.stream(strArr)
                .mapToInt(s -> s.length())
                .sum();
        assertEquals(res, 10);
    }

    @Test
    void 문제2번() {
        int res = Arrays.stream(strArr)
                .mapToInt(s -> s.length())
                .max()
                .orElse(0);
        assertEquals(res, 4);
    }

    @Test
    void 문제3번() {
        int[] sorted = IntStream.range(1, 46)
                .sorted()
                .toArray();
        for (int i = 1; i < 46; i++) {
            assertEquals(sorted[i-1], i);
        }
    }

    @Test
    void 문제4번() {
        List<Integer[]> res = IntStream.range(1, 7)
                .boxed()
                .flatMap(i -> IntStream.range(1, 7).boxed().map(j -> new Integer[]{i, j}))
                .filter(i -> i[0] + i[1] == 6)
                .collect(Collectors.toList());
    }
}
