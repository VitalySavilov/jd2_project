package my.dto.car;

import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

@Value
public class CarCreateDto {
    String carMark;
    String carModel;
    String type;
    String color;
    Long power;
    String year;
    String fuelType;
    Double fuelConsumption;
    Double price;
    MultipartFile[] files;
}
