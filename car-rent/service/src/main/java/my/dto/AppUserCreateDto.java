package my.dto;

import lombok.Value;

import java.sql.Date;

@Value
public class AppUserCreateDto {
    String username;
    String password;
    String firstname;
    String lastname;
    Date birthDate;
    String email;
    String telNumber;
}
