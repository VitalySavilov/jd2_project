package my.dto;

import lombok.Value;

import java.util.List;

@Value
public class CarReadDto {
    String carMark;
    String carModel;
    String type;
    String color;
    Long power;
    String year;
    String fuelType;
    Double fuelConsumption;
    Double price;
    List<Long> imageIdList;
}
