package my.mapper.app_user;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserCreateDto;
import my.mapper.Mapper;
import my.model.AppUser;
import my.model.AppUserInfo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class AppUserCreateMapper implements Mapper<AppUserCreateDto, AppUser> {
    private final PasswordEncoder passwordEncoder;

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
                .password(passwordEncoder.encode(object.getPassword()))
                .build();
    }
}
