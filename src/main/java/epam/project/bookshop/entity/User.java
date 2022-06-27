package epam.project.bookshop.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class User extends BaseDomain {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private Long roleId;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(roleId, user.roleId);
    }

    @Override
    public int hashCode() {

        int result = 1;

        result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
        result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
        result = 31 * result + (username == null ? 0 : username.hashCode());
        result = 31 * result + (email == null ? 0 : email.hashCode());
        result = 31 * result + (phoneNumber == null ? 0 : phoneNumber.hashCode());
        result = 31 * result + (password == null ? 0 : password.hashCode());
        result = 31 * result + (roleId == null ? 0 : roleId.hashCode());
        result = 31 * super.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("email='" + email + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("roleId=" + roleId)
                .add(super.toString())
                .toString();
    }
}

