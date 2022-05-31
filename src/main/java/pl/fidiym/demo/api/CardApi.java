package pl.fidiym.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CardApi {
    @GetMapping("/cards/{id}")
    public String getCard(@PathVariable long id) {
        return "card";
    }

    @GetMapping("/cards/edit/{id}")
    public String editCard(@PathVariable long id) {
        return "card-edit";
    }
}

