package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jnews.core.news.NewsServiceImplement;

@Slf4j
@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping("/")
class Controller {

    private final NewsServiceImplement newsService;



    @GetMapping
    public String home(Model model){
        model.addAttribute("news",newsService.getNewsFromDataClient());
        newsService.getNewsFromDataClient().stream()
                .forEach(Object::toString);
        return "index";
    }

}
