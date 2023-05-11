package project.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("ACTIVE")
    ACTIVE("active"),

    @JsonProperty("DORMANT")
    DORMANT("dormant");

    private String code;

    private Status(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

}