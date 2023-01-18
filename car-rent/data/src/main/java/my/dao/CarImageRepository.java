package my.dao;

import my.model.CarImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarImageRepository extends CrudRepository<CarImage, Long> {

    CarImage getCarImageById(Long id);

    @Query(value = "SELECT I_ID FROM t_car_image WHERE C_ID = :carId", nativeQuery = true)
    List<Long> getImagesIdList (@Param("carId") Long carId);

}
