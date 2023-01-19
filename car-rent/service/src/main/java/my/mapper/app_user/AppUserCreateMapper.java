package my.mapper.app_user;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserCreateDto;
import my.mapper.Mapper;
import my.model.AppUser;
import my.model.AppUserInfo;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class AppUserCreateMapper implements Mapper<AppUserCreateDto, AppUser> {

    @Override
    public AppUser mapFrom(AppUserCreateDto object) {
        return AppUser.builder()
                .appUserInfo(AppUserInfo.builder()
                        .firstname(object.getFirstname())
                        .lastname(object.getLastname())
                        .birthDate(object.getBirthDate())
                        .email(object.getEmail())
                        .telNumber(object.getTelNumber())
                        .build())
                .username(object.getUsername())
                .password(object.getPassword())
                .build();
    }
}
