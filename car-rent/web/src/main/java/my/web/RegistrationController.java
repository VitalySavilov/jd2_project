package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserCreateDto;
import my.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final AppUserService appUserService;

    @PostMapping("/registration")
    public String addAppUser(AppUserCreateDto appUserCreateDto) {
        appUserService.create(appUserCreateDto);
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration";
    }
}
