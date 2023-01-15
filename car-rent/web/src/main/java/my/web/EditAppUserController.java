package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.EditUserDto;
import my.service.AppUserService;
import my.service.PaymentCardService;
import my.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EditAppUserController {
    private final AppUserService appUserService;
    private final PaymentCardService paymentCardService;
    private final RoleService roleService;

    @GetMapping("/user/{userId}")
    public String showUserPage(@PathVariable String userId, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("paymentCards", paymentCardService.findPaymentCardsByUserId(userId));
        model.addAttribute("user", appUserService.getAppUserById(userId));
        return "user";
    }

    @PostMapping("/user/{userId}")
    public String editUser(@PathVariable String userId, EditUserDto editUserDto) {
        appUserService.updateUser(editUserDto, userId);
        return "redirect:/user/" + userId;
    }
}
