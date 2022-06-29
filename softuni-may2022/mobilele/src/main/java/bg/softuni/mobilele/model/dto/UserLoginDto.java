package bg.softuni.mobilele.model.dto;

public class UserLoginDto {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
