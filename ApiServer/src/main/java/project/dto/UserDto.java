package project.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private int userId;
    private String username;
    private int postCount;

    public UserDto() {
    }

    @JsonCreator
    public UserDto(@JsonProperty("user_id") int userId,
                   @JsonProperty("username") String username,
                   @JsonProperty("post_count") int postCount) {
        this.userId = userId;
        this.username = username;
        this.postCount = postCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getPostCount() {
        return postCount;
    }
}