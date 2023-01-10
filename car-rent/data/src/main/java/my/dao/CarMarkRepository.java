package my.dao;

import my.model.CarMark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarMarkRepository extends CrudRepository<CarMark, Long> {

    List<CarMark> findAll();

    Optional<CarMark> findCarMarkByName(String name);

}
