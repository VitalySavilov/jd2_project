package my.mapper.payment_card;

import my.dto.payment_card.PaymentCardReadDto;
import my.mapper.Mapper;
import my.model.PaymentCard;
import org.springframework.stereotype.Component;

@Component
public class PaymentCardReadMapper implements Mapper<PaymentCard, PaymentCardReadDto> {

    @Override
    public PaymentCardReadDto mapFrom(PaymentCard object) {
        return new PaymentCardReadDto(
                object.getId(),
                object.getCardNumber());
    }
}
