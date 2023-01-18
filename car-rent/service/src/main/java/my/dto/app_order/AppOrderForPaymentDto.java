package my.dto.app_order;

import lombok.Value;
import my.dto.app_user.AppUserDto;
import my.dto.car.CarDto;

import java.sql.Date;

@Value
public class AppOrderForPaymentDto {
    Long id;
    Date startDate;
    Date endDate;
    String status;
    CarDto car;
    AppUserDto appUser;
    Double sum;
}
