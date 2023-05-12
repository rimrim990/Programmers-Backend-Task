package project.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private Long userId;

    private String username;

    private Long postCount;

    @JsonCreator
    public UserDto(@JsonProperty("user_id") Long userId,
                   @JsonProperty("username") String username,
                   @JsonProperty("post_count") Long postCount) {
        this.userId = userId;
        this.username = username;
        this.postCount = postCount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Long getPostCount() {
        return postCount;
    }
}