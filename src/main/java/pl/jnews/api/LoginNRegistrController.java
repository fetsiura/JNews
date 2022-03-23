package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.jnews.core.user.User;
import pl.jnews.core.user.UserDto;
import pl.jnews.core.user.UserServiceImplement;

import javax.validation.Valid;

@Controller
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class LoginNRegistrController {

    private final UserServiceImplement userService;

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("userDto",new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(Model model,@ModelAttribute("userDto") @Valid UserDto userDto,
                                   BindingResult result){

       if(result.hasErrors()){
            return "registration";
       }
       if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
           model.addAttribute("errorConf", "Password not confirm");
           return "registration"; }

       userService.saveUser(userDto);
       return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@CurrentSecurityContext(expression="authentication?.name")
                                    String username){

        if(!username.equals("anonymousUser")){
            return "redirect:/dashboard";
        }
        return "login";
    }


    @GetMapping("/create")
    public String create(){
        UserDto userDto = new UserDto();
        userDto.setLogin("jaro");
        userDto.setEmail("fetsiura@gmail.com");
        userDto.setPassword("Liga2020");
        userDto.setConfirmPassword("Liga2020");
        userService.saveUser(userDto);
        return "redirect:/login";

    }

}
