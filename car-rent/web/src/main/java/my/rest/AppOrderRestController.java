package my.rest;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderDto;
import my.dto.page_response.PageResponse;
import my.service.AppOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class AppOrderRestController {
    private final AppOrderService appOrderService;

    @GetMapping
    public ResponseEntity<PageResponse<AppOrderDto>> getAllOrders(Pageable pageable) {
        Page<AppOrderDto> page = appOrderService.findAllOrders(pageable);
        return new ResponseEntity<>(
                PageResponse.of(page),
                HttpStatus.OK);
    }
}
