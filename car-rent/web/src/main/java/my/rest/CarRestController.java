package my.rest;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarReadDto;
import my.dto.page_response.PageResponse;
import my.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarRestController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<PageResponse<CarReadDto>> getAllCars(Pageable pageable) {
        Page<CarReadDto> page = carService.getAll(pageable);
        return new ResponseEntity<>(
                PageResponse.of(page),
                HttpStatus.OK);
    }
}
