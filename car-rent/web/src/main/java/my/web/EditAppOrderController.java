package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderEditDto;
import my.dto.app_order.OrderStatus;
import my.service.AppOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class EditAppOrderController {
    public final AppOrderService appOrderService;

    @GetMapping("/order/{orderId}")
    public String showOrder(@PathVariable long orderId, Model model) {
        model.addAttribute("order", appOrderService.findOrder(orderId));
        model.addAttribute("statusList",
                Arrays.stream(OrderStatus.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));
        return "order";
    }

    @PostMapping("/order/{orderId}")
    public String editOrder(@PathVariable long orderId, AppOrderEditDto appOrderEditDto) {
        appOrderService.editOrder(orderId, appOrderEditDto);
        return "redirect:/order/" + orderId;
    }
}
