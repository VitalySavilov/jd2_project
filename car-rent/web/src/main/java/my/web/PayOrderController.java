package my.web;

import lombok.RequiredArgsConstructor;
import my.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PayOrderController {
    private final PaymentService paymentService;

    @PostMapping("/order/{orderId}/payment")
    public String createPay(@PathVariable long orderId, Model model) {
        model.addAttribute("payment" , paymentService.createPayment(orderId));
        return "payment_check";
    }
}
