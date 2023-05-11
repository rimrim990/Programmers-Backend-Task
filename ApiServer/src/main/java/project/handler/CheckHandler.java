package project.handler;

import project.dto.CheckResponseDto;

public class CheckHandler extends HttpJsonHandler<CheckResponseDto> {

    private static final String OK_MESSAGE = "server check";

    @Override
    CheckResponseDto createMessage() {
        return new CheckResponseDto(OK_MESSAGE);
    }

}