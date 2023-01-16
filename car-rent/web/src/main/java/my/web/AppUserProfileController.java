package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserReadDto;
import my.dto.app_user.EditUserProfileDto;
import my.service.AppUserService;
import my.service.PaymentCardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AppUserProfileController {
    private final AppUserService appUserService;
    private final PaymentCardService paymentCardService;

    @GetMapping("/user-page")
    public String showUserPage(@AuthenticationPrincipal User user, Model model) {
        AppUserReadDto appUserReadDto = appUserService.getUserByUsername(user.getUsername());
        model.addAttribute("user", appUserService.getUserByUsername(user.getUsername()));
        model.addAttribute("cards", paymentCardService.findPaymentCardsByUsername(user.getUsername()));
        return "user_profile";
    }

    @PostMapping("/user-page")
    public String editUser(@AuthenticationPrincipal User user, EditUserProfileDto editUserProfileDto) {
        appUserService.updateUserProfile(editUserProfileDto, user.getUsername());
        return "redirect:/user-page";
    }
}
