package my.mapper.app_user;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserDto;
import my.mapper.Mapper;
import my.model.AppUser;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppUserMapper implements Mapper<AppUser, AppUserDto> {

    @Override
    public AppUserDto mapFrom(AppUser object) {
        return new AppUserDto(
                object.getId(),
                object.getAppUserInfo(),
                object.getUsername()
        );
    }
}
