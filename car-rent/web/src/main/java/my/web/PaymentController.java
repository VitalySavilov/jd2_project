package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.page_response.PageResponse;
import my.dto.payment.PaymentReadDto;
import my.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public String getAllPayments(Pageable pageable, Model model) {
        Page<PaymentReadDto> page = paymentService.getAll(pageable);
        model.addAttribute("data", PageResponse.of(page));
        return "payments";
    }

    @PostMapping("/payment")
    public String createPayment(long orderId, Model model) {
        model.addAttribute("payment" , paymentService.createPayment(orderId));
        return "payment_check";
    }

    @GetMapping("/{paymentId}")
    public String getPayment(@PathVariable long paymentId, Model model) {
        model.addAttribute("payment", paymentService.getPaymentById(paymentId));
        return "payment";
    }
}
