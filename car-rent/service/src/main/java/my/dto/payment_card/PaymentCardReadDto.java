package my.dto.payment_card;

import lombok.Value;

@Value
public class PaymentCardReadDto {
    Long id;
    String cardNumber;
}
