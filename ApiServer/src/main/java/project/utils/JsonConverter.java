package project.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
    private ObjectMapper objectMapper = new ObjectMapper();

    // convert json to T
    public <T> T convert(String json, Class<T> target) throws JsonMappingException, JsonProcessingException {
        JavaType type = objectMapper.getTypeFactory()
                .constructReferenceType(target, null);
        return objectMapper.readValue(json, type);
    }

    // convert json to List of T
    public <T> List<T> convertToList(String json, Class<T> target) throws JsonMappingException, JsonProcessingException {
        JavaType type = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, target);
        return objectMapper.readValue(json, type);
    }

    // convert T to json String
    public <T> String readAsString(T target) throws JsonProcessingException {
        return objectMapper.writeValueAsString(target);
    }

    // conver T to json bytes
    public <T> byte[] readAsBytes(T target) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(target);
    }
}
