package my.mapper.car_model;

import my.dto.car.CarCreateDto;
import my.mapper.Mapper;
import my.model.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarModelCreateMapper implements Mapper<CarCreateDto, CarModel> {

    @Override
    public CarModel mapFrom(CarCreateDto object) {
        return CarModel.builder()
                .name(object.getCarModel())
                .build();
    }
}
