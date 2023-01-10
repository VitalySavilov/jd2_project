package my.dto;

import lombok.Value;

import java.util.List;

@Value
public class CarFormDataDto {
    List<String> marks;
    List<String> models;
    List<String> types;
    List<String> fuelTypes;
    String actualMark;
}
