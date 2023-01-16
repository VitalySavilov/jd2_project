package my.web;

import lombok.RequiredArgsConstructor;
import my.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CarService carService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("count", carService.getCarCount());
        return "home";
    }
}
