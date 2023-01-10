package my.mapper;

import lombok.RequiredArgsConstructor;
import my.dto.CarReadDto;
import my.model.Car;
import my.model.CarImage;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarReadMapper implements Mapper<Car, CarReadDto> {

    @Override
    public CarReadDto mapFrom(Car object) {
        return new CarReadDto(
                object.getCarMark().getName(),
                object.getCarModel().getName(),
                object.getType().getName(),
                object.getColor(),
                object.getPower(),
                object.getYear(),
                object.getFuelType().name(),
                object.getFuelConsumption(),
                object.getPrice(),
                object.getImages().stream()
                        .map(CarImage::getId)
                        .collect(Collectors.toList())
        );
    }
}
