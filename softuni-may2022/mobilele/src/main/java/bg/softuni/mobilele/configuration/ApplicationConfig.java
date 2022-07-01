package bg.softuni.mobilele.configuration;

import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationConfig {


//    @Bean
//    public ModelMapper modelMapper(PasswordEncoder passwordEncoder) {
//        ModelMapper mapper = new ModelMapper();
//
//
//        mapper.addConverter(ctx -> LocalDate.parse(ctx.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
//                String.class, LocalDate.class);
//
//        Converter<String, String> toEncodedPassword =
//                ctx -> ctx.getSource() == null ? null : passwordEncoder.encode(ctx.getSource());
//
//        mapper.createTypeMap(UserRegisterDto.class, UserEntity.class)
//                .addMappings(mpr -> mpr.using(toEncodedPassword).map(UserRegisterDto::getPassword,
//                        UserEntity::setPassword));
//
//        return mapper;
//    }
}
