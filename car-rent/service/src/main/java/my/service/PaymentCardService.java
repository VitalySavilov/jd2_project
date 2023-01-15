package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.PaymentCardRepository;
import my.model.PaymentCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentCardService {
    private final PaymentCardRepository paymentCardRepository;

    public List<PaymentCard> findPaymentCardsByUsername(String username) {
        return paymentCardRepository.findPaymentCardByAppUser_Username(username).orElse(new ArrayList<>());
    }

    public List<PaymentCard> findPaymentCardsByUserId(String userId) {
        return paymentCardRepository.findPaymentCardByAppUser_Id(userId).orElse(new ArrayList<>());
    }

}
