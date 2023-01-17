package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarStatus;
import my.dto.car.EditCarDto;
import my.service.CarImageService;
import my.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class EditCarController {
    private final CarService carService;
    private final CarImageService carImageService;

    @GetMapping("/admin-car/{carId}")
    public String showCar(@PathVariable("carId") long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        model.addAttribute("statusList",
                Arrays.stream(CarStatus.values())
                .map(Enum::name)
                .collect(Collectors.toList()));
        return "edit_car";
    }

    @ResponseBody
    @GetMapping("admin-car/image/{imageId}")
    public byte[] getImage(@PathVariable("imageId") long imageId) {
        byte[] img = carImageService.getImageById(imageId).getImage();
        return img;
    }

    @PostMapping("/admin-car/{carId}")
    public String editCar(@PathVariable("carId") long carId, EditCarDto editCarDto) {
        carService.updateCar(carId, editCarDto);
        return "redirect:/admin-car/" + carId;
    }
}
