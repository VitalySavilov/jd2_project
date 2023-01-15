package my.mapper.app_user;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserReadDto;
import my.mapper.Mapper;
import my.model.AppUser;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppUserReadMapper implements Mapper<AppUser, AppUserReadDto> {

    @Override
    public AppUserReadDto mapFrom(AppUser object) {
        return new AppUserReadDto(
                object.getId(),
                object.getAppUserInfo(),
                object.getUsername(),
                object.getRoles()
        );
    }
}
