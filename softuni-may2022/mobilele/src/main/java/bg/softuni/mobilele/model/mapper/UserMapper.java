package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", source = "password", qualifiedByName = "passwordToPasswordHash")
    UserEntity userDtoToUserEntity(UserRegisterDto registerDto);

    @Named("passwordToPasswordHash")
    public static String passwordToPasswordHash(String password) {
        PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        return encoder.encode(password);
    }
}
