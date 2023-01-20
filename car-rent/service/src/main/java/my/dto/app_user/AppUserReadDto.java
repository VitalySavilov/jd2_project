package my.dto.app_user;

import lombok.Value;
import my.dto.role.RoleDto;
import my.model.*;

import java.util.List;

@Value
public class AppUserReadDto {
    String id;
    AppUserInfo appUserInfo;
    String username;
    List<RoleDto> roles;
}
