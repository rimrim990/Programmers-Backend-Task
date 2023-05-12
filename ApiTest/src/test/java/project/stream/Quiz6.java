package project.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Quiz6 {

    Student[] stuArr;

    @BeforeEach
    void before() {
        stuArr = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };
    }

    @Test
    void 문제1번() {
         Map<Boolean, List<Student>> res = Arrays.stream(stuArr)
                .filter(s -> s.score < 150)
                .collect(Collectors.groupingBy(s -> s.isMale));
    }

    class Student {
        private String name;
        private boolean isMale; // 성별
        private int hak; // 학년
        private int ban; // 반
        private int score;

        public Student(String name, boolean isMale, int hak, int ban, int score) {
            this.name = name;
            this.isMale = isMale;
            this.hak = hak;
            this.ban = ban;
            this.score = score;
        }

        public String toString() {
            return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
        }
    }
}
