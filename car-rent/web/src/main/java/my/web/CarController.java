package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarCreateDto;
import my.dto.car.CarReadDto;
import my.dto.car.CarStatus;
import my.dto.car.EditCarDto;
import my.dto.filter.CarFilter;
import my.dto.page_response.PageResponse;
import my.model.Fuel;
import my.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarImageService carImageService;
    private final CarMarkService carMarkService;
    private final CarModelService carModelService;
    private final CarTypeService carTypeService;

    @GetMapping
    public String getAllCars(Model model, Pageable pageable, CarFilter filter) {
        Page<CarReadDto> page = carService.getAll(pageable, filter);
        model.addAttribute("data", PageResponse.of(page));
        model.addAttribute("filter", filter);
        return "cars";
    }

    @GetMapping("/{carId}")
    public String getCar(@PathVariable("carId") long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        return "car";
    }

    @ResponseBody
    @GetMapping("car/image/{imageId}")
    public byte[] getImage(@PathVariable("imageId") long imageId) {
        return carImageService.getImageById(imageId).getImage();
    }

    @GetMapping("/car/{carId}")
    public String getCarForUpdate(@PathVariable("carId") long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        model.addAttribute("statusList",
                Arrays.stream(CarStatus.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));
        return "edit_car";
    }

    @PostMapping("/car/{carId}/update")
    public String updateCar(@PathVariable("carId") long carId, EditCarDto editCarDto) {
        carService.updateCar(carId, editCarDto);
        return "redirect:/cars/car/{carId}";
    }

    @PostMapping("/car")
    public String createCar(CarCreateDto carCreateDto) {
        carService.create(carCreateDto);
        return "redirect:/";
    }

    @GetMapping("/car")
    public String showCreateCarPage(String actualMark, Model model) {
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
