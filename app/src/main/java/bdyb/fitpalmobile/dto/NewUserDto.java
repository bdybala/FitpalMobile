package bdyb.fitpalmobile.dto;

public class NewUserDto {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Integer height;
    private Integer mass;
    private Long birthday;

    public NewUserDto(String login, String password, String firstName, String lastName, Integer height, Integer mass, Long birthday) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.mass = mass;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "NewUserDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", birthday=" + birthday +
                '}';
    }

    public NewUserDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
}
