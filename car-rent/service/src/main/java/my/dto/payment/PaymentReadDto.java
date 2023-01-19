package my.dto.payment;

import lombok.Value;
import my.dto.app_order.AppOrderDto;

import java.sql.Date;

@Value
public class PaymentReadDto {
    Long id;
    Date paymentDate;
    AppOrderDto appOrder;
}
