package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderReadDto;
import my.dto.page_response.PageResponse;
import my.service.AppOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AppOrderListController {
    private final AppOrderService appOrderService;

    @GetMapping("/orders")
    public String showOrderList(Model model, Pageable pageable) {
        Page<AppOrderReadDto> page = appOrderService.findAllOrders(pageable);
        model.addAttribute("data", PageResponse.of(page));
        return "orders";
    }
}
