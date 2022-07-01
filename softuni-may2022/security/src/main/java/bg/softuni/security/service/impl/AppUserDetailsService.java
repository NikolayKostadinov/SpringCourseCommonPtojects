package bg.softuni.security.service.impl;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
        return this.map(userEntity);
    }

    private UserDetails map(UserEntity userEntity) {
        return new User(userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getUserRoles()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toList()));
    }

    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole
                        .getUserRole().name());
    }

}
