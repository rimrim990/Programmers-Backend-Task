package project.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    // json 를 obj 로 변환
    public static <T> T mapToObj(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

    public static <T> List<T> mapToArr(String json, Class<T> clazz) throws JsonProcessingException {
        JavaType javaType = mapper.getTypeFactory()
                .constructCollectionType(List.class, clazz);
        return mapper.readValue(json, javaType);
    }

    // obj 를 json 문자열로 변환
    public static <T> String mapToJson(T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    // obj 리스트를 json 문자열로 변환
    public static <T> String mapToJson(List<T> objList) throws JsonProcessingException {
        return mapper.writeValueAsString(objList);
    }
}
