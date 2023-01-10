package my.mapper;

import lombok.RequiredArgsConstructor;
import my.dao.AppUserRoleRepository;
import my.dto.AppUserCreateDto;
import my.model.AppUser;
import my.model.AppUserInfo;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class AppUserCreateMapper implements Mapper<AppUserCreateDto, AppUser> {
    private final AppUserRoleRepository appUserRoleRepository;

    @Override
    public AppUser mapFrom(AppUserCreateDto object) {
        AppUser appUser = AppUser.builder()
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
        appUser.getRoles().add(appUserRoleRepository.findAppUserRoleByName("USER"));
        return appUser;
    }
}
