package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String email; // email of the user.
    private String password; // password of the user.

    @Column(nullable = false)
    private String firstName; //  first name of the user.

    @Column(nullable = false)
    private String lastName; //  last name of the user.
    private boolean isActive; // true OR false.
    private String imageUrl; // a url of user's picture.

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> userRoles; //  user's roles (User, Moderator or Admin)

    public UserEntity setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public UserEntity() {
        this.userRoles = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<UserRoleEntity> getUserRoles() {
        return Collections.unmodifiableList(userRoles);
    }

    public UserEntity addRole(UserRoleEntity role){
        this.userRoles.add(role);
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", userRoles=" + userRoles.stream().map(ur->ur.getUserRole().toString()).collect(Collectors.joining(
                        ", ")) +
                '}';
    }

    // created // a date and time.
    // modified // a date and time.
}
