package pl.jnews.core.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 10)
    private String login;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 8,message = "Password should be included minimum 8 characters")
    private String password;

    @NotEmpty(message = "Password confirm should not be empty")
    @Size(min = 8,message = "Password confirm should be included minimum 8 characters")
    private String confirmPassword;
}
