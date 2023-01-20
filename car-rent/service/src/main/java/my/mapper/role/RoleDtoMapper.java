package my.mapper.role;

import my.dto.role.RoleDto;
import my.mapper.Mapper;
import my.model.AppUserRole;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoMapper implements Mapper<AppUserRole, RoleDto> {

    @Override
    public RoleDto mapFrom(AppUserRole object) {
        return new RoleDto(
                object.getId(),
                object.getName());
    }
}
