package project.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.user.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilTest {

    User dto;
    String json;

    @BeforeEach
    void before() {
        dto = new User(1L, "test", 2L);
        json = "{" +
                "\"userId\":1," +
                "\"username\":\"test\"," +
                "\"postCount\":2" +
                "}";
    }

    @Test
    void 단일_객체_직렬화() throws JsonProcessingException {
        assertEquals(json, JsonUtil.writeAsString(dto));
    }

    @Test
    void 컬렉션_객체_직렬화() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        list.add(dto);
        String listJson = "[" + json + "]";
        assertEquals(listJson, JsonUtil.writeAsString(list));
    }

    @Test
    void 객체_역직렬화() throws JsonProcessingException {
        User res = JsonUtil.readObj(json, User.class) ;
        assertEquals(dto.getUserId(), res.getUserId());
        assertEquals(dto.getUsername(), res.getUsername());
        assertEquals(dto.getPostCount(), res.getPostCount());
    }

    @Test
    void 컬렉션_역직렬화() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        list.add(dto);
        String listJson = "[" + json + "]";
        List<User> res = JsonUtil.readList(listJson, User.class);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getUserId(), res.get(i).getUserId());
            assertEquals(list.get(i).getUsername(), res.get(i).getUsername());
            assertEquals(list.get(i).getPostCount(), res.get(i).getPostCount());
        }
    }
}