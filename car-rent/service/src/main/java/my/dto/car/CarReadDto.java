package my.dto.car;

import lombok.Value;

@Value
public class CarReadDto {
    Long id;
    String carMark;
    String carModel;
    String type;
    String status;
    String color;
    String regNumber;
    Long power;
    String year;
    String fuelType;
    Double fuelConsumption;
    Double price;
}
