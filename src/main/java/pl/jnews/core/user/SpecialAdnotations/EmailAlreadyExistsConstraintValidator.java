package pl.jnews.core.user.SpecialAdnotations;

import lombok.RequiredArgsConstructor;
import pl.jnews.core.user.UserServiceImplement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailAlreadyExistsConstraintValidator implements ConstraintValidator<EmailAlreadyExists, String> {

    private final UserServiceImplement userService;

    @Override
    public boolean isValid(String emailField, ConstraintValidatorContext cxt) {
        if(emailField == null) {
            return false;
        }

        if(userService.findByEmail(emailField) != null){
            return false;
        }
        return true;
    }
}
