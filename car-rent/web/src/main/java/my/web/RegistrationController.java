package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.AppUserCreateDto;
import my.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final AppUserService appUserService;

    @PostMapping("/registration")
    public String addCar(AppUserCreateDto appUserCreateDto) {
        appUserService.create(appUserCreateDto);
        return "redirect:/";
    }

    @GetMapping("/registration")
    public ModelAndView showAddCarPage() {
        return new ModelAndView("registration");
    }
}
