package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    boolean login(UserLoginDto loginDTO);

    void logout();

    void register(UserRegisterDto registerDto);

    Optional<UserEntity> getByEmail(String email);
}
