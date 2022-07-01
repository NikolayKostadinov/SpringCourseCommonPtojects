package bg.softuni.security.service.impl;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.model.enums.UserRoleEnum;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder encoder;

    private final String adminPassword;

    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder encoder,
                       @Value("${app.default.admin.password}") String adminPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.encoder = encoder;
        this.adminPassword = adminPassword;
    }

    public void init(){
        if (userRepository.count() == 0 && userRoleRepository.count() == 0){
            UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
            UserRoleEntity moderatorRole = new UserRoleEntity().setUserRole(UserRoleEnum.MODERATOR);
            UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);

            adminRole = this.userRoleRepository.save(adminRole);
            moderatorRole = this.userRoleRepository.save(moderatorRole);
            userRole = this.userRoleRepository.save(userRole);

            initAdmin(List.of(adminRole, moderatorRole));
            initModerator(List.of(moderatorRole));
            initUser(List.of(userRole));
        }
    }

    private void initAdmin(List<UserRoleEntity> roles){
        UserEntity admin = new UserEntity()
                .setUserRoles(roles)
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setEmail("admin@test.com")
                .setPassword(this.encoder.encode(adminPassword));
        this.userRepository.save(admin);
    }

    private void initModerator(List<UserRoleEntity> roles){
        UserEntity moderator = new UserEntity()
                .setUserRoles(roles)
                .setFirstName("Moderator")
                .setLastName("Moderatorov")
                .setEmail("moderator@test.com")
                .setPassword(this.encoder.encode(adminPassword));
        this.userRepository.save(moderator);

    }

    private void initUser(List<UserRoleEntity> roles){
        UserEntity user = new UserEntity()
                .setUserRoles(roles)
                .setFirstName("User")
                .setLastName("Userov")
                .setEmail("user@test.com")
                .setPassword(this.encoder.encode(adminPassword));
        this.userRepository.save(user);
    }
}
