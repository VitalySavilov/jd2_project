package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.CarReadDto;
import my.dto.PageResponse;
import my.service.CarImageService;
import my.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CarListController {

    private final CarService carService;
    private final CarImageService carImageService;

    @GetMapping("/cars")
    public ModelAndView showCarList(Pageable pageable) {
        Page<CarReadDto> page = carService.getAll(pageable);
        return new ModelAndView(
                "cars",
                Map.of("data", PageResponse.of(page))
        );
    }

    @ResponseBody
    @GetMapping("/image/{imageId}/photo")
    public byte[] getImage(@PathVariable("imageId") long imageId) {
        return carImageService.getImageById(imageId).getImage();
    }
}
