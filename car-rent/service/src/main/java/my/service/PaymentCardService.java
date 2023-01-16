package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.PaymentCardRepository;
import my.dto.payment_card.PaymentCardReadDto;
import my.mapper.payment_card.PaymentCardReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentCardService {
    private final PaymentCardRepository paymentCardRepository;
    private final PaymentCardReadMapper paymentCardReadMapper;

    public List<PaymentCardReadDto> findPaymentCardsByUsername(String username) {
        return paymentCardRepository.findPaymentCardByAppUser_Username(username)
                .map(x -> x.stream()
                        .map(paymentCardReadMapper::mapFrom)
                        .collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }

    public List<PaymentCardReadDto> findPaymentCardsByUserId(String userId) {
        return paymentCardRepository.findPaymentCardByAppUser_Id(userId)
                .map(x -> x.stream()
                        .map(paymentCardReadMapper::mapFrom)
                        .collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }
}
