package project.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import project.dto.SumResponseDto;
import project.dto.UserDto;
import project.utils.FileReader;

import java.util.List;
import java.io.IOException;

public class SumHandler extends HttpJsonHandler<SumResponseDto> {

    private static final String FILE_PATH = "data/input/user.json";

    @Override
    SumResponseDto createMessage() {
        try {
            String userDataJson = readUserData();
            // calculate total postCount
            List<UserDto> userDtos = convertToUserDtoList(userDataJson);
            int sum = userDtos.stream()
                    .mapToInt(userDto -> userDto.getPostCount())
                    .sum();
            return new SumResponseDto(sum);
        } catch (Exception e) {
            e.printStackTrace();
            return new SumResponseDto(-1);
        }
    }

    private String readUserData() throws IOException {
        return FileReader.readFileAsString(FILE_PATH);
    }

    private List<UserDto> convertToUserDtoList(String jsonArray) throws JsonMappingException, JsonProcessingException {
        return super.converter.convertToList(jsonArray, UserDto.class);
    }
}