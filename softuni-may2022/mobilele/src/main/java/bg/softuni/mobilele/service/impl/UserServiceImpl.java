package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);;

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;



    public UserServiceImpl(UserRepository userRepository,
                           CurrentUser currentUser,
                           PasswordEncoder passwordEncoder,
                           UserMapper mapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    public boolean login(UserLoginDto loginDTO) {
        Optional<UserEntity> userOpt = this.userRepository.findByEmail(loginDTO.getUsername());
        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", loginDTO.getUsername());
            return false;
        }

        boolean success = this.passwordEncoder.matches(loginDTO.getPassword(), userOpt.get().getPassword());
        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    @Override
    public void logout() {
        LOGGER.debug("User with name [{}] logged out.", currentUser.getEmail());
        this.currentUser.clear();
    }

    @Override
    public void register(UserRegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
            LOGGER.debug("Fail to create user [{}] passwords not match!",
                    registerDto.getFirstName() + " " + registerDto.getLastName());
            return;
        }
        UserEntity user = this.mapper.userDtoToUserEntity(registerDto);
        this.userRepository.save(user);
        LOGGER.debug("Registered user [{}].", registerDto.getFirstName() + " " + registerDto.getLastName());
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    private void login(UserEntity userEntity) {
        this.currentUser.setLoggedIn(true);
        this.currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
        LOGGER.debug("User with name [{}] logged in.", currentUser.getEmail());
    }


}
