package project.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private Long userId;

    private String username;

    private Long postCount;

    private Role role;

    @JsonCreator
    public User(@JsonProperty("user_id") Long userId,
                @JsonProperty("username") String username,
                @JsonProperty("post_count") Long postCount,
                @JsonProperty("role") Role role) {
        this.userId = userId;
        this.username = username;
        this.postCount = postCount;
        this.role = role;
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

    public Role getRole() {
        return role;
    }
}
