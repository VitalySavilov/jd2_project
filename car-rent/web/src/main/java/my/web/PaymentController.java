package my.web;

import lombok.RequiredArgsConstructor;
import my.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payment/{paymentId}")
    public String showPayment(@PathVariable long paymentId, Model model) {
        model.addAttribute("payment", paymentService.getPaymentById(paymentId));
        return "payment";
    }
}
