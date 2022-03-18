package pl.jnews.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.jnews.core.crypto.Crypto;
import pl.jnews.core.crypto.CryptoServiceImplement;
import pl.jnews.core.news.NewsServiceImplement;
import pl.jnews.core.weather.CityServiceImplement;
import pl.jnews.core.user.UserDto;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping("/")
class Controller {

    private final NewsServiceImplement newsService;
    private final CryptoServiceImplement cryptoService;
    private final CityServiceImplement cityService;

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("userDto",new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(Model model,
                                   @ModelAttribute("userDto") @Valid UserDto userDto,
                                   BindingResult result){

        return "registration";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping
    public String home(Model model){
            model.addAttribute("news",newsService.getNewsWhenInputEmpty());
            return "index";
    }


    @PostMapping
    public String homeWithCategory(Model model,
                                   @Param("category") String category){

        if(check(category)){
            model.addAttribute("news", newsService.getNewsWithCategory(category));
        } else {
            model.addAttribute("error","Bad request, please try to describe differently.");
        }
        return "index";
    }


    ////kontrolery kryptowalut
    @GetMapping("/cryptocurrency")
    public String cryptocurrencyGetForm(Model model){

        if(cryptoService.countAllCrypto()<1){
            cryptoService.addCryptoToDatabase();
        }
        model.addAttribute("cryptos",cryptoService.findByNameASC());

        return "cryptocurrency";
    }

    @PostMapping("/cryptocurrency")
    public String cryptocurrencyPostForm(Model model,
                                         @Param("filter") String filter,
                                         @Param("name")String name){
        List<Crypto> cryptos = new ArrayList<>();

        //jeżeli nie wpisano nazwy kryptowaluty sortujemy po wybranym wskaźniku
        if(name.isEmpty()){
            if (filter.contains("priceHighToLow")) {
                cryptos=cryptoService.findByPriceDESC();
            } else if (filter.contains("priceLowToHigh")) {
                cryptos=cryptoService.findByPriceASC();
            } else {
                cryptos=cryptoService.findByNameASC();
            }
        } else {

            cryptos=cryptoService.findByNameStartsWith(name);
        }
        model.addAttribute("cryptos",cryptos);

        return "cryptocurrency";
    }



    @GetMapping("/contact")
    public String getContacts(){
        return "contact";
    }


    Boolean check(String word){
        String search ="";
        boolean flag = true;
        if(!word.isEmpty() || !word.isBlank()){
            search=word.replaceAll("[^a-zA-Z 0-9 - \\s]", "");
            if(search.isBlank() || search.isEmpty() || search.length()<2){
                flag=false;
            }
        }
        return flag;
        }


}
