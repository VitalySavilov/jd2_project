package my.dao;

import my.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>,
        QuerydslPredicateExecutor<Payment> {

    @EntityGraph(attributePaths = {"appOrder", "appOrder.appUser", "appOrder.appUser.appUserInfo", "appOrder.car"})
    Page<Payment> findAll(Pageable pageable);

}
