package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarCreateDto;
import my.model.Fuel;
import my.service.CarMarkService;
import my.service.CarModelService;
import my.service.CarService;
import my.service.CarTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AddCarController {
    private final CarService carService;
    private final CarMarkService carMarkService;
    private final CarModelService carModelService;
    private final CarTypeService carTypeService;

    @PostMapping("/new-car")
    public String addCar(CarCreateDto carCreateDto) {
        carService.create(carCreateDto);
        return "redirect:/";
    }

    @GetMapping("/new-car")
    public String showAddCarPage(String actualMark, Model model) {
        actualMark = actualMark != null ? actualMark : "";
        model.addAttribute("marks", carMarkService.getMarkNameList());
        model.addAttribute("models", carModelService.getActualModelList(actualMark));
        model.addAttribute("types", carTypeService.getCarTypeNameList());
        model.addAttribute("fuelTypes",
                Arrays.stream(Fuel.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));
        model.addAttribute("actualMark", actualMark);
        return "new_car";
    }
}
