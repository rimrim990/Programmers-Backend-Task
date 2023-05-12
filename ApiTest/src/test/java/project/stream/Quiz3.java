package project.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Quiz3 {

    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

    @Test
    void 문제1번() {
        List<Integer[]> res = numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[] {n, m}))
                .collect(Collectors.toList());
    }

    @Test
    void 문제2번() {
        Integer max = numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[] {n, m}))
                .mapToInt(i -> i[0] * i[1])
                .max()
                .orElse(0);
        assertEquals(max, 12);
    }
}
