package my.mapper;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import my.dao.CarMarkRepository;
import my.dao.CarModelRepository;
import my.dao.CarTypeRepository;
import my.dto.CarCreateDto;
import my.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class CarCreateMapper {
    private final CarTypeRepository carTypeRepository;
    private final CarModelRepository carModelRepository;
    private final CarMarkRepository carMarkRepository;

    @SneakyThrows
    public Car mapFrom(CarCreateDto object) {
        Car car = Car.builder()
                .color(object.getColor())
                .fuelType(Fuel.valueOf(object.getFuelType()))
                .power(object.getPower())
                .year(object.getYear())
                .fuelConsumption(object.getFuelConsumption())
                .price(object.getPrice())
                .carMark(carMarkRepository.findCarMarkByName(object.getCarMark())
                        .orElse(CarMark.builder()
                                .name(object.getCarMark())
                                .build()))
                .carModel(carModelRepository.findCarModelByName(object.getCarModel())
                        .orElse(CarModel.builder()
                                .name(object.getCarModel())
                                .build()))
                .type(carTypeRepository.findCarTypeByName(object.getType())
                        .orElse(CarType.builder()
                                .name(object.getType())
                                .build()))
                .build();
        car.getCarModel().setCarMark(car.getCarMark());
        for (MultipartFile file : object.getFiles()) {
            car.getImages().add(CarImage.builder()
                    .image(file.getBytes())
                    .build());
        }
        return car;
    }
}
