package my.dto.payment;

import lombok.Value;
import my.dto.app_order.AppOrderReadDto;

import java.sql.Date;

@Value
public class PaymentReadDto {
    Long id;
    Date paymentDate;
    AppOrderReadDto appOrder;
}
