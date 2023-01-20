package my.security;

import lombok.RequiredArgsConstructor;
import my.model.AppUser;
import my.model.AppUserRole;
import my.service.AppUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("authService")
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new User(
                appUser.getUsername(),
                appUser.getPassword(),
                true,
                true,
                true,
                true,
                appUser.getRoles().stream()
                        .map(AppUserRole::getName)
                        .map(n -> "ROLE_" + n)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
    }
}
