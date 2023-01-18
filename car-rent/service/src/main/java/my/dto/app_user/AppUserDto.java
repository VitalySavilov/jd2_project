package my.dto.app_user;

import lombok.Value;
import my.model.AppUserInfo;

@Value
public class AppUserDto {
    String id;
    AppUserInfo appUserInfo;
    String username;
}
