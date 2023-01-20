package my.mapper.app_user;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserReadDto;
import my.mapper.Mapper;
import my.mapper.role.RoleDtoMapper;
import my.model.AppUser;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppUserReadMapper implements Mapper<AppUser, AppUserReadDto> {
    private final RoleDtoMapper roleDtoMapper;

    @Override
    public AppUserReadDto mapFrom(AppUser object) {
        return new AppUserReadDto(
                object.getId(),
                object.getAppUserInfo(),
                object.getUsername(),
                object.getRoles().stream().map(roleDtoMapper::mapFrom).collect(Collectors.toList())
        );
    }
}
