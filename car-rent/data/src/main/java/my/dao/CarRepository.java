package my.dao;

import my.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>, QuerydslPredicateExecutor<Car> {

    @EntityGraph(attributePaths = {"carModel", "images", "carMark", "type"})
    Page<Car> findAll(Pageable pageable);

}
