package my.dao;

import my.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    @EntityGraph(attributePaths = {"carModel", "carMark", "type"})
    Page<Car> findAll(Pageable pageable);

    Optional<Car> findCarById(long id);

    Optional<Car> findCarByRegNumber(String regNumber);

}
