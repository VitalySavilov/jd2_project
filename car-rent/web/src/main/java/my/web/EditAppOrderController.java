package my.web;

import lombok.RequiredArgsConstructor;
import my.service.AppOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class EditAppOrderController {
    public final AppOrderService appOrderService;

    @GetMapping("/order/{orderId}")
    public String showOrder(@PathVariable long orderId, Model model) {
        model.addAttribute("order", appOrderService.findOrder(orderId));
        return "order";
    }
}
