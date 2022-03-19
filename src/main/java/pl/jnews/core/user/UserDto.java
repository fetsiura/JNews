package pl.jnews.core.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jnews.core.user.SpecialAdnotations.EmailAlreadyExists;
import pl.jnews.core.user.SpecialAdnotations.EmailUserValid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Size(min = 3, message = "Login should be included min 3 characters")
    private String login;

    @EmailUserValid(message = "Email should be valid")
    @EmailAlreadyExists(message = "Email already exists")
    private String email;

    @Size(min = 8,message = "Password should be included min 8 characters")
    private String password;

    private String confirmPassword;
}
