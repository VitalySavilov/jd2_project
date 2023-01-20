package my.dto.app_order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.sql.Date;

@Value
public class AppOrderDto {
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date endDate;
    String status;
    Double sum;
    String carNumber;
    String firstname;
    String lastname;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date birthDate;
    String email;
    String telNumber;
}
