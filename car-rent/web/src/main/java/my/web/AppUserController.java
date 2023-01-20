package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserCreateDto;
import my.dto.app_user.AppUserReadDto;
import my.dto.app_user.EditUserDto;
import my.dto.app_user.EditUserProfileDto;
import my.dto.page_response.PageResponse;
import my.service.AppUserService;
import my.service.PaymentCardService;
import my.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class AppUserController {
    private final AppUserService appUserService;
    private final PaymentCardService paymentCardService;
    private final RoleService roleService;

    @GetMapping
    public String getAllUsers(Pageable pageable, Model model) {
        Page<AppUserReadDto> page = appUserService.getAll(pageable);
        model.addAttribute("data",  PageResponse.of(page));
        return "users";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("paymentCards", paymentCardService.findPaymentCardsByUserId(userId));
        model.addAttribute("user", appUserService.getAppUserById(userId));
        return "user";
    }

    @PostMapping("/{userId}/update")
    public String updateUser(@PathVariable String userId, EditUserDto editUserDto) {
        appUserService.updateUser(editUserDto, userId);
        return "redirect:/users/{userId}";
    }

    @GetMapping("/user")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping("/user")
    public String createUser(AppUserCreateDto appUserCreateDto) {
        appUserService.create(appUserCreateDto);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String getUserProfile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", appUserService.getUserByUsername(user.getUsername()));
        model.addAttribute("cards", paymentCardService.findPaymentCardsByUsername(user.getUsername()));
        return "user_profile";
    }

    @PostMapping("/profile/update")
    public String updateUserProfile(@AuthenticationPrincipal User user, EditUserProfileDto editUserProfileDto) {
        appUserService.updateUserProfile(editUserProfileDto, user.getUsername());
        return "redirect:/users/profile";
    }

    @PostMapping("/{userId}/delete")
    public String deleteUser(@PathVariable String userId) {
        appUserService.deleteUser(userId);
        return "redirect:/users";
    }
}
