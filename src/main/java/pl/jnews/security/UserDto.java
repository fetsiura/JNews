package pl.jnews.security;

import lombok.Data;

@Data
public class UserDto {

    private String login;
    private String email;
    private String password;
}
