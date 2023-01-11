package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.CarFilter;
import my.dto.CarReadDto;
import my.dto.PageResponse;
import my.service.CarImageService;
import my.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CarListController {
    private final CarService carService;
    private final CarImageService carImageService;

    @GetMapping("/cars")
    public String showCarList(Model model, Pageable pageable, CarFilter filter) {
        Page<CarReadDto> page = carService.getAll(pageable, filter);
        model.addAttribute("data", PageResponse.of(page));
        model.addAttribute("filter", filter);
        return "cars";
    }

    @ResponseBody
    @GetMapping("/image/{imageId}/photo")
    public byte[] getImage(@PathVariable("imageId") long imageId) {
        return carImageService.getImageById(imageId).getImage();
    }
}
