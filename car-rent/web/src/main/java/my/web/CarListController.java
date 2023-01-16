package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarReadDto;
import my.dto.filter.CarFilter;
import my.dto.page_response.PageResponse;
import my.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CarListController {
    private final CarService carService;

    @GetMapping("/cars")
    public String showCarList(Model model, Pageable pageable, CarFilter filter) {
        Page<CarReadDto> page = carService.getAll(pageable, filter);
        model.addAttribute("data", PageResponse.of(page));
        model.addAttribute("filter", filter);
        return "cars";
    }
}
