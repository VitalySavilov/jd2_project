package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.AppOrderRepository;
import my.dao.PaymentRepository;
import my.dto.payment.PaymentReadDto;
import my.mapper.payment.PaymentReadMapper;
import my.model.AppOrder;
import my.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final AppOrderRepository appOrderRepository;
    private final PaymentReadMapper paymentReadMapper;

    @Transactional
    public PaymentReadDto createPayment(long orderId) {
        AppOrder order = appOrderRepository.findById(orderId).orElseThrow();
        Payment payment = Payment.builder()
                .paymentDate(Date.valueOf(LocalDate.now()))
                .appOrder(order)
                .build();
        return paymentReadMapper
                .mapFrom(paymentRepository.save(payment));
    }

    public Page<PaymentReadDto> getAll(Pageable pageable) {
        return paymentRepository.findAll(pageable)
                .map(paymentReadMapper::mapFrom);
    }

    public PaymentReadDto getPaymentById(long id) {
        return paymentRepository.findById(id)
                .map(paymentReadMapper::mapFrom)
                .orElseThrow();
    }
}
