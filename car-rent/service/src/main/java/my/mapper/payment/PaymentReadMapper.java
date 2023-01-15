package my.mapper.payment;

import lombok.RequiredArgsConstructor;
import my.dto.payment.PaymentReadDto;
import my.mapper.Mapper;
import my.mapper.app_order.AppOrderReadMapper;
import my.model.Payment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentReadMapper implements Mapper<Payment, PaymentReadDto> {
    private final AppOrderReadMapper mapper;

    @Override
    public PaymentReadDto mapFrom(Payment object) {
        return new PaymentReadDto(object.getId(),
                object.getPaymentDate(),
                mapper.mapFrom(object.getAppOrder()));
    }
}
