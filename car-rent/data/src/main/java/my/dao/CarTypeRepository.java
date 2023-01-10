package my.dao;

import my.model.CarType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarTypeRepository extends CrudRepository<CarType, Long> {

    List<CarType> findAll();

    Optional<CarType> findCarTypeByName(String name);
}
