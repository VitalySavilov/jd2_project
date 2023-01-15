package my.mapper.car_type;

import my.dto.car.CarCreateDto;
import my.mapper.Mapper;
import my.model.CarType;
import org.springframework.stereotype.Component;

@Component
public class CarTypeCreateMapper implements Mapper<CarCreateDto, CarType> {

    @Override
    public CarType mapFrom(CarCreateDto object) {
        return CarType.builder()
                .name(object.getType())
                .build();
    }
}
