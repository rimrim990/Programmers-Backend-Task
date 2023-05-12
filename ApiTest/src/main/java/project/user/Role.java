package project.user;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    USER("user"),
    ADMIN("admin");

    @JsonValue
    private final String code;

    Role(String code) {
        this.code = code;
    }
}
