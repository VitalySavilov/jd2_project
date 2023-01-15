package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.payment.PaymentReadDto;
import my.dto.page_response.PageResponse;
import my.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PaymentListController {
    private final PaymentService paymentService;

    @GetMapping("/payments")
    public String showUsersPage(Pageable pageable, Model model) {
        Page<PaymentReadDto> page = paymentService.getAll(pageable);
        model.addAttribute("data", PageResponse.of(page));
        return "payments";
    }
}
