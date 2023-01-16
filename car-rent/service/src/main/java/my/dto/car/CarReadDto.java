package my.dto.car;

import lombok.Value;

import java.util.List;

@Value
public class CarReadDto {
    Long id;
    String carMark;
    String carModel;
    String type;
    String color;
    String regNumber;
    Long power;
    String year;
    String fuelType;
    Double fuelConsumption;
    Double price;
    List<Long> imageIdList;
}
