package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderDto;
import my.dto.app_order.AppOrderEditDto;
import my.dto.app_order.OrderStatus;
import my.dto.page_response.PageResponse;
import my.service.AppOrderService;
import my.service.CarService;
import my.service.PaymentCardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class AppOderController {
    private final AppOrderService appOrderService;
    private final CarService carService;
    private final PaymentCardService paymentCardService;

    @GetMapping
    public String getAllOrders(Model model, Pageable pageable) {
        Page<AppOrderDto> page = appOrderService.findAllOrders(pageable);
        model.addAttribute("data", PageResponse.of(page));
        return "orders";
    }

    @PostMapping("/order")
    public String createOrder(@AuthenticationPrincipal User user, long carId, long days, Model model) {
        model.addAttribute("userCards", paymentCardService.findPaymentCardsByUsername(user.getUsername()));
        model.addAttribute("userOrder", appOrderService.createOrder(carId, user.getUsername(), days));
        model.addAttribute("car", carService.getCarById(carId));
        return "new_order";
    }

    @GetMapping("/order/{orderId}")
    public String getOrderForUpdate(@PathVariable long orderId, Model model) {
        model.addAttribute("order", appOrderService.findOrder(orderId));
        model.addAttribute("statusList",
                Arrays.stream(OrderStatus.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));
        return "order";
    }

    @PostMapping("/order/{orderId}/update")
    public String updateOrder(@PathVariable long orderId, AppOrderEditDto appOrderEditDto) {
        appOrderService.updateOrder(orderId, appOrderEditDto);
        return "redirect:/orders/order/{orderId}";
    }
}
