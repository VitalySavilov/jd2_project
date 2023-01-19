package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.CarImageRepository;
import my.dao.CarRepository;
import my.model.CarImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarImageService {
    private final CarImageRepository carImageRepository;
    private final CarRepository carRepository;

    public CarImage getImageById(long imageId) {
        return carImageRepository.getCarImageById(imageId);
    }

    public List<Long> getImageIdList(long carId) {
        return carImageRepository.getImagesIdList(carId);
    }
}
