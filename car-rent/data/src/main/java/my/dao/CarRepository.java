package my.dao;

import com.querydsl.core.types.Predicate;
import my.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>, QuerydslPredicateExecutor<Car> {

    @EntityGraph(attributePaths = {
            "carModel",
            "carMark",
            "type"
    })
    Page<Car> findAll(Predicate predicate, Pageable pageable);

    Optional<Car> findCarById (long id);

}
