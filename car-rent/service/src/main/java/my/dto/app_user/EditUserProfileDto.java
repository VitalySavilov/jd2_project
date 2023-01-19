package my.dto.app_user;

import lombok.Value;

import java.sql.Date;

@Value
public class EditUserProfileDto {
    String firstname;
    String lastname;
    Date birthDate;
    String email;
    String telNumber;
    String addCard;
    Long delCardId;
}
