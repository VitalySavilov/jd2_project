package my.web;

import lombok.RequiredArgsConstructor;
import my.service.AppOrderService;
import my.service.CarService;
import my.service.PaymentCardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class NewOrderController {
    private final CarService carService;
    private final AppOrderService appOrderService;
    private final PaymentCardService paymentCardService;

    @GetMapping("/new-order/{carId}")
    public String showOrderPage(@PathVariable long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        return "new_order";
    }

    @PostMapping("/new-order/{carId}")
    public String createOrder(@PathVariable long carId, @AuthenticationPrincipal User user, long days, Model model) {
        model.addAttribute("userCards", paymentCardService.findPaymentCardsByUsername(user.getUsername()));
        model.addAttribute("userOrder",  appOrderService.createOrder(carId, user.getUsername(), days));
        return "order_payment";
    }
}
