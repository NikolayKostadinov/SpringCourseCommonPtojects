package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));

        return mapToUserDetails(user);
    }

    private static UserDetails mapToUserDetails(UserEntity userEntity){
        List<GrantedAuthority> authorities = userEntity
                .getUserRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getUserRole().name()))
                .collect(Collectors.toList());

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);
    }
}
