package pl.jnews.core.user;

import lombok.Data;

@Data
public class UserDto {

    private String login;
    private String email;
    private String password;
}
