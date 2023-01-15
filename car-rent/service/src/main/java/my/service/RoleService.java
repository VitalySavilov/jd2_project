package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.AppUserRoleRepository;
import my.model.AppUserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final AppUserRoleRepository appUserRoleRepository;

    public List<AppUserRole> getAllRoles() {
        return (List<AppUserRole>) appUserRoleRepository.findAll();
    }
}
