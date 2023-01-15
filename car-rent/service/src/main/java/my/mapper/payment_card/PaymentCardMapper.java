package my.mapper.payment_card;

import my.dto.app_user.AppUserCreateDto;
import my.mapper.Mapper;
import my.model.PaymentCard;
import org.springframework.stereotype.Component;

@Component
public class PaymentCardMapper implements Mapper<AppUserCreateDto, PaymentCard> {

    @Override
    public PaymentCard mapFrom(AppUserCreateDto object) {
        return PaymentCard.builder()
                .cardNumber(object.getCardNumber())
                .build();
    }
}
