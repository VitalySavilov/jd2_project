package my.dto.app_user;

import lombok.Value;
import my.model.*;

import java.util.List;

@Value
public class AppUserReadDto {
    String id;
    AppUserInfo appUserInfo;
    String username;
    List<AppUserRole> roles;
}
