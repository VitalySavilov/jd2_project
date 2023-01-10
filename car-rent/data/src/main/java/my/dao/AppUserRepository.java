package my.dao;

import my.model.AppUser;
import my.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, String> {

    @EntityGraph(attributePaths = {"roles"})
    List<AppUser> findAppUserByUsernameEquals(String username);

    List<AppUser> findAll();

    @EntityGraph(attributePaths = {"roles", "appUserInfo"})
    Page<AppUser> findAll(Pageable pageable);
}
