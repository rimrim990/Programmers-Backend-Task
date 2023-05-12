package project.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.user.Role;
import project.user.User;
import project.user.UserDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilTest {

    UserDto dto;
    User user;

    String json;
    String userJson;

    @BeforeEach
    void before() {
        dto = new UserDto(1L, "test", 2L);
        json = "{" +
                "\"userId\":1," +
                "\"username\":\"test\"," +
                "\"postCount\":2" +
                "}";
        user = new User(1L, "test", 2L, Role.ADMIN);
        userJson = "{" +
                    "\"username\":\"test\"," +
                    "\"role\":\"admin\"," +
                    "\"userId\":1," +
                    "\"postCount\":2}";
    }

    @Test
    void 단일_객체_직렬화() throws JsonProcessingException {
        assertEquals(json, JsonUtil.writeAsString(dto));
    }

    @Test
    void 컬렉션_객체_직렬화() throws JsonProcessingException {
        List<UserDto> list = new ArrayList<>();
        list.add(dto);
        String listJson = "[" + json + "]";
        assertEquals(listJson, JsonUtil.writeAsString(list));
    }

    @Test
    void 객체_역직렬화() throws JsonProcessingException {
        UserDto res = JsonUtil.readObj(json, UserDto.class) ;
        assertEquals(dto.getUserId(), res.getUserId());
        assertEquals(dto.getUsername(), res.getUsername());
        assertEquals(dto.getPostCount(), res.getPostCount());
    }

    @Test
    void 컬렉션_역직렬화() throws JsonProcessingException {
        List<UserDto> list = new ArrayList<>();
        list.add(dto);
        String listJson = "[" + json + "]";
        List<UserDto> res = JsonUtil.readList(listJson, UserDto.class);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getUserId(), res.get(i).getUserId());
            assertEquals(list.get(i).getUsername(), res.get(i).getUsername());
            assertEquals(list.get(i).getPostCount(), res.get(i).getPostCount());
        }
    }

    @Test
    void 이넘_직렬화() throws JsonProcessingException {
        assertEquals(JsonUtil.writeAsString(user), userJson);
    }

    @Test
    void 이넘_역직렬화() throws JsonProcessingException {
        User res = JsonUtil.readObj(userJson, User.class);
        assertEquals(user.getUserId(), res.getUserId());
        assertEquals(user.getRole(), res.getRole());
    }
}