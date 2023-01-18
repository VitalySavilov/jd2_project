package my.mapper.car;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarReadDto;
import my.dto.car.CarStatus;
import my.mapper.Mapper;
import my.model.Car;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarReadMapper implements Mapper<Car, CarReadDto> {

    @Override
    public CarReadDto mapFrom(Car object) {
        return new CarReadDto(
                object.getId(),
                object.getCarMark().getName(),
                object.getCarModel().getName(),
                object.getType().getName(),
                object.isAvailable() ? CarStatus.AVAILABLE.name() : CarStatus.UNAVAILABLE.name(),
                object.getColor(),
                object.getRegNumber(),
                object.getPower(),
                object.getYear(),
                object.getFuelType().name(),
                object.getFuelConsumption(),
                object.getPrice()
        );
    }
}
