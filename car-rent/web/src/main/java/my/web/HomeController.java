package my.web;

import lombok.RequiredArgsConstructor;
import my.service.AppOrderService;
import my.service.AppUserService;
import my.service.CarService;
import my.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CarService carService;
    private final AppUserService appUserService;
    private final AppOrderService appOrderService;
    private final PaymentService paymentService;

    @GetMapping(value = "/")
    public String showHomePage(Model model) {
        model.addAttribute("carCount", carService.getCarCount());
        model.addAttribute("userCount", appUserService.getAppUserCount());
        model.addAttribute("orderCount", appOrderService.getAppOrderCount());
        model.addAttribute("paymentCount", paymentService.getPaymentCount());
        return "home";
    }
}
