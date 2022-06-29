package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    ;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;


    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }


    @Override
    public void register(UserRegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            LOGGER.debug("Fail to create user [{}] passwords not match!",
                    registerDto.getFirstName() + " " + registerDto.getLastName());
            return;
        }
        UserEntity newUser = this.mapper.userDtoToUserEntity(registerDto);
        //todo: register new user
        this.userRepository.save(newUser);
        LOGGER.debug("Registered user [{}].", registerDto.getFirstName() + " " + registerDto.getLastName());
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }


}
