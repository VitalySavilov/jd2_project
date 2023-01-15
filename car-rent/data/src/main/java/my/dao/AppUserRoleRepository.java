package my.dao;

import my.model.AppUserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRoleRepository extends CrudRepository<AppUserRole, Long> {

    AppUserRole findAppUserRoleByName(String name);

}
