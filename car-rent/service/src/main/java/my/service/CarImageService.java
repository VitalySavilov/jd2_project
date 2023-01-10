package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.CarImageRepository;
import my.model.CarImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarImageService {
    private final CarImageRepository carImageRepository;

    public CarImage getImageById(long imageId) {
        return carImageRepository.getCarImageById(imageId);
    }
}
