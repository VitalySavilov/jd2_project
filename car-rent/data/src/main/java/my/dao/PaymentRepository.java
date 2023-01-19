package my.dao;

import my.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {

    @EntityGraph(attributePaths = {"appOrder", "appOrder.appUserInfo"})
    Page<Payment> findAll(Pageable pageable);

}
