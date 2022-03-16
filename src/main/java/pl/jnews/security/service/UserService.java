package pl.jnews.security.service;


import pl.jnews.security.User;
import pl.jnews.security.UserDto;

public interface UserService {

    User findByEmail(String email);
    void saveUser(UserDto userDto);
}
