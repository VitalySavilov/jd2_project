package my.mapper.payment_card;

import my.dto.app_user.AppUserCreateDto;
import my.dto.app_user.EditUserProfileDto;
import my.mapper.Mapper;
import my.model.PaymentCard;
import org.springframework.stereotype.Component;

@Component
public class PaymentCardCreateMapper implements Mapper<AppUserCreateDto, PaymentCard> {

    @Override
    public PaymentCard mapFrom(AppUserCreateDto object) {
        return PaymentCard.builder()
                .cardNumber(object.getCardNumber())
                .build();
    }

    public PaymentCard mapFrom(EditUserProfileDto editUserProfileDto) {
        return PaymentCard.builder()
                .cardNumber(editUserProfileDto.getAddCard())
                .build();
    }
}
