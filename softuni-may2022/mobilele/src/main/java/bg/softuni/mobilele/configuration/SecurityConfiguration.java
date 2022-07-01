package bg.softuni.mobilele.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // allow anonymous access to all static resources
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // allows anonymous access to home, login and registration
                .antMatchers("/", "/users/register", "/users/login").permitAll()
                // forbid all other for anonymous users;
                //.antMatchers("/**").authenticated() or
                .anyRequest().authenticated()
                .and()
                // configure login with login form
                .formLogin()
                // login page is http://<<serveradderss>>:<port>/users/login
                .loginPage("/users/login")
                //this is the name of the input in login form where user enters his unique identifier
                //the value will be presented to UserDetailsService
                .usernameParameter("email")
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("/")
                .failureForwardUrl("/user/login-error")
                .and()
                .logout()
                // the logout page
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        return httpSecurity.build();
    }
}
