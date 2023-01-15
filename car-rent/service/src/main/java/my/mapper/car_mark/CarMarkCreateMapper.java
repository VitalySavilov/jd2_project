package my.mapper.car_mark;

import my.dto.car.CarCreateDto;
import my.mapper.Mapper;
import my.model.CarMark;
import org.springframework.stereotype.Component;

@Component
public class CarMarkCreateMapper implements Mapper<CarCreateDto, CarMark> {

    @Override
    public CarMark mapFrom(CarCreateDto object) {
        return CarMark.builder()
                .name(object.getCarMark())
                .build();
    }
}
