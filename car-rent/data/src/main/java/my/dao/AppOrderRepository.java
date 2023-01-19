package my.dao;

import my.model.AppOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppOrderRepository extends PagingAndSortingRepository<AppOrder, Long> {

    @EntityGraph(attributePaths = {"appUserInfo"})
    Page<AppOrder> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"appUserInfo"})
    AppOrder findAppOrderById(long id);

}
