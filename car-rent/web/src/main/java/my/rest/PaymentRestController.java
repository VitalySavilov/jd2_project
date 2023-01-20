package my.rest;

import lombok.RequiredArgsConstructor;
import my.dto.page_response.PageResponse;
import my.dto.payment.PaymentReadDto;
import my.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentRestController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<PageResponse<PaymentReadDto>> getAllPayments(Pageable pageable, Model model) {
        Page<PaymentReadDto> page = paymentService.getAll(pageable);
        return new ResponseEntity<>(
                PageResponse.of(page),
                HttpStatus.OK);
    }
}
