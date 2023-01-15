package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarCreateDto;
import my.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AddCarController {
    private final CarService carService;

    @PostMapping("/new-car")
    public String addCar(CarCreateDto carCreateDto) {
        carService.create(carCreateDto);
        return "redirect:/";
    }

    @GetMapping("/new-car")
    public ModelAndView showAddCarPage(String actualMark) {
        return new ModelAndView(
                "new_car",
                Map.of("data", carService.getFormData(actualMark))
        );
    }
}
