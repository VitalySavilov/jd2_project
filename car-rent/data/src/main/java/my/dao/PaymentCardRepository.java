package my.dao;

import my.model.PaymentCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentCardRepository extends CrudRepository<PaymentCard, Long> {

    Optional<List<PaymentCard>> findPaymentCardByAppUser_Username(String username);

    Optional<List<PaymentCard>> findPaymentCardByAppUser_Id(String id);

}
