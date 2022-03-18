package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jnews.core.user.UserDto;
import pl.jnews.core.user.UserServiceImplement;

import javax.validation.Valid;

@Controller
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class LoginRegistrationController {

    private final UserServiceImplement userService;

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("userDto",new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(@ModelAttribute("userDto") @Valid UserDto userDto,
                                   BindingResult result){
       log.error(userDto.toString());
        if(result.hasErrors()){

            return "registration";
        }

        userService.saveUser(userDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
