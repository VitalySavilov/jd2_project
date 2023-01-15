package my.dao;

import my.model.AppOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppOrderRepository extends PagingAndSortingRepository<AppOrder, Long>,
        QuerydslPredicateExecutor<AppOrder> {

    @EntityGraph(attributePaths = {"appUser", "appUser.appUserInfo", "car"})
    Page<AppOrder> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"appUser", "appUser.appUserInfo", "car"})
    AppOrder findAppOrdersById(long id);
}
