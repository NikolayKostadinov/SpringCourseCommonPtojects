package bg.manhattan.pathfinder.model;

import bg.manhattan.pathfinder.model.enums.UserRoles;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    public UserRoles getRole() {
        return role;
    }

    public Role setRole(UserRoles role) {
        this.role = role;
        return this;
    }
}
