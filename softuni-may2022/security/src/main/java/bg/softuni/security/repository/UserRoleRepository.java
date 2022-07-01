package bg.softuni.security.repository;

import bg.softuni.security.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
}
