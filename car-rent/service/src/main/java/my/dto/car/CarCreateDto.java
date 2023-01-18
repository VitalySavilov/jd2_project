package my.dto.car;

import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Value
public class CarCreateDto {
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
    List<Long> imageIdList;
    MultipartFile[] files;
}
