package my.mapper.car;

import my.dto.car.CarCreateDto;
import my.mapper.Mapper;
import my.model.Car;
import my.model.Fuel;
import org.springframework.stereotype.Component;

@Component
public class CarCreateMapper implements Mapper<CarCreateDto, Car> {

    public Car mapFrom(CarCreateDto object) {
        return Car.builder()
                .color(object.getColor())
                .regNumber(object.getRegNumber())
                .fuelType(Fuel.valueOf(object.getFuelType()))
                .power(object.getPower())
                .year(object.getYear())
                .fuelConsumption(object.getFuelConsumption())
                .price(object.getPrice())
                .build();
    }
}
