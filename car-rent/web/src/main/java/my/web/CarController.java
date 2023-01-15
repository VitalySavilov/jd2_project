package my.web;

import lombok.RequiredArgsConstructor;
import my.service.CarImageService;
import my.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarImageService carImageService;

    @GetMapping("/car/{carId}")
    public String showCar(@PathVariable("carId") long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        return "car";
    }

    @ResponseBody
    @GetMapping("car/image/{imageId}")
    public byte[] getImage(@PathVariable("imageId") long imageId) {
        byte[] img = carImageService.getImageById(imageId).getImage();
        return img;
    }
}
