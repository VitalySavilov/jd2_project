package my.dto.app_order;

import lombok.Value;
import my.dto.app_user.AppUserDto;
import my.dto.car.CarReadDto;

import java.sql.Date;

@Value
public class AppOrderDto {
    Long id;
    Date startDate;
    Date endDate;
    String status;
    CarReadDto car;
    AppUserDto appUser;
    Double sum;
}
