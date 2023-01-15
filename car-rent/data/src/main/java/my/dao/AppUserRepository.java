package my.dao;

import my.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, String> {

    @EntityGraph(attributePaths = {"roles"})
    Optional<AppUser> findAppUserByUsernameEquals(String username);

    @EntityGraph(attributePaths = {"roles", "appUserInfo"})
    Page<AppUser> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"roles", "appUserInfo"})
    Optional<AppUser> findAppUserById(String id);
}
