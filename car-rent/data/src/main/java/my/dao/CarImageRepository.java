package my.dao;

import my.model.CarImage;
import org.springframework.data.repository.CrudRepository;

public interface CarImageRepository extends CrudRepository<CarImage, Long> {

    CarImage getCarImageById(Long id);
}
