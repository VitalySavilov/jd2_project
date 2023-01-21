package my.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"my"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login**").permitAll()
                .antMatchers("/users/user").permitAll()
                .antMatchers("/users/profile**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/users**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/cars").permitAll()
                .antMatchers(HttpMethod.GET, "/cars/{\\d+}").permitAll()
                .antMatchers("/cars**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/orders/order").hasAnyRole("ADMIN", "USER")
                .antMatchers("/orders**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/payments/payment").hasAnyRole("ADMIN", "USER")
                .antMatchers("/payments**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/cars")
                        .permitAll());
        return http.build();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth,
                                        @Qualifier("authService") AuthenticationService service) throws Exception {
        auth.userDetailsService(service);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

