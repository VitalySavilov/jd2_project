package my.dto.app_order;

import lombok.Value;

import java.sql.Date;

@Value
public class AppOrderDto {
    Long id;
    Date startDate;
    Date endDate;
    String status;
    Double sum;
    String carNumber;
    String firstname;
    String lastname;
    Date birthDate;
    String email;
    String telNumber;
}
