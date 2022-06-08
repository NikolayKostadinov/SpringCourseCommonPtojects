package bg.manhattan.pathfinder.model;

import bg.manhattan.pathfinder.model.enums.Level;
import bg.manhattan.pathfinder.model.enums.UserRoles;
import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    /**
     * Accepts values, which should be at least 2 characters.
     */
    @Column(nullable = false,  unique = true)
    private String username;

    /**
     * Accepts values, which should be at least 2 characters
     */
    @Column(nullable = false)
    private String password;

    @Column(name="full_name")
    private String fullName;

    private int age;

    /**
     * Accepts values, which contain the '@' symbol
     */
    @Column(unique = true)
    private String email;

    /**
     * Each registered user should have a "User" role
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToMany(mappedBy = "author")
    private Set<Message> writtenMessages;

    @OneToMany(mappedBy = "recipient")
    private Set<Message> receivedMessages;

    public User() {
        this.roles = new HashSet<>();
        this.writtenMessages = new HashSet<>();
        this.receivedMessages = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public Set<Message> getWrittenMessages() {
        return writtenMessages;
    }

    public User setWrittenMessages(Set<Message> writtenMessages) {
        this.writtenMessages = writtenMessages;
        return this;
    }

    public Set<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public User setReceivedMessages(Set<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
        return this;
    }
}
