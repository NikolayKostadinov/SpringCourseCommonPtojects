package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;

public interface UserService {
    boolean login(UserLoginDto loginDTO);

    void logout();

    void register(UserRegisterDto registerDto);
}
