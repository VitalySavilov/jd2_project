package my.dto.app_order;

import lombok.Value;
import my.dto.app_user.AppUserReadDto;
import my.dto.car.CarReadDto;

import java.sql.Date;

@Value
public class AppOrderReadDto {
    Long id;
    Date startDate;
    Date endDate;
    CarReadDto car;
    AppUserReadDto appUser;
    Double sum;
}
