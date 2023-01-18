package my.mapper.car;

import lombok.RequiredArgsConstructor;
import my.dto.car.CarDto;
import my.mapper.Mapper;
import my.model.Car;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarMapper implements Mapper<Car, CarDto> {
    @Override
    public CarDto mapFrom(Car object) {
        return new CarDto(
                object.getId(),
                object.getRegNumber());
    }
}
