package my.mapper.car_image;

import lombok.SneakyThrows;
import my.dto.car.CarCreateDto;
import my.mapper.Mapper;
import my.model.CarImage;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarImageCreateMapper implements Mapper<CarCreateDto, List<CarImage>> {

    @Override
    @SneakyThrows
    public List<CarImage> mapFrom(CarCreateDto object) {
        List<CarImage> images = new ArrayList<>();
        for (MultipartFile file : object.getFiles()) {
            images.add(CarImage.builder()
                    .image(file.getBytes())
                    .build());
        }
        return images;
    }
}
