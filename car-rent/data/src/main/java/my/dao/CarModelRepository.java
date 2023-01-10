package my.dao;

import my.model.CarModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarModelRepository extends CrudRepository<CarModel, Long> {

    List<CarModel> findAll();

    Optional<CarModel> findCarModelByName(String name);
}
