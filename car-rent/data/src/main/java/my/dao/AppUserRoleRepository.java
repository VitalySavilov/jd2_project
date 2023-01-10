package my.dao;

import my.model.AppUserRole;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRoleRepository extends CrudRepository<AppUserRole, Long> {

    AppUserRole findAppUserRoleByName(String name);
}
