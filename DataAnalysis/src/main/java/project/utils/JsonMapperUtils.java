package project.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.utils.exception.ConversionException;

public class JsonMapperUtils{
    private static final ObjectMapper mapper = new ObjectMapper();

    // convert json to List of T
    public static <T> List<T> convertToList(String json, Class<T> targetClass) throws ConversionException {
        try {
            JavaType type = mapper.getTypeFactory()
                    .constructCollectionType(List.class, targetClass);
            return mapper.readValue(json, type);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConversionException();
        }
    }

    // convert T to json
    public static <T> String converToJson(T target) throws ConversionException {
        try {
            return mapper.writeValueAsString(target);
        } catch (Exception e) {
            throw new ConversionException();
        }
    }

    // convert List<T> to json
    public static <T> String converToJson(List<T> target) throws ConversionException {
        try {
            return mapper.writeValueAsString(target);
        } catch (Exception e) {
            throw new ConversionException();
        }
    }
}
