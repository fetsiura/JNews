package pl.jnews.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
class Controller {


    @GetMapping
    public String home(){
        return "index";
    }

}
