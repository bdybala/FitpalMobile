package bdyb.fitpalmobile.dto;


import bdyb.fitpalmobile.enums.Gender;
import bdyb.fitpalmobile.enums.Role;

public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private Long birthday;
    private Gender gender;

    private Double mass;
    private Double height;

    private Double massToLoseWeight;
    private Double desiredIntervalToLoseWeight;

    private Role role;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", mass=" + mass +
                ", height=" + height +
                ", massToLoseWeight=" + massToLoseWeight +
                ", desiredIntervalToLoseWeight=" + desiredIntervalToLoseWeight +
                ", role=" + role +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Long getBirthday() {
        return birthday;
    }
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Double getMass() {
        return mass;
    }
    public void setMass(Double mass) {
        this.mass = mass;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getMassToLoseWeight() {
        return massToLoseWeight;
    }
    public void setMassToLoseWeight(Double massToLoseWeight) {
        this.massToLoseWeight = massToLoseWeight;
    }
    public Double getDesiredIntervalToLoseWeight() {
        return desiredIntervalToLoseWeight;
    }
    public void setDesiredIntervalToLoseWeight(Double desiredIntervalToLoseWeight) {
        this.desiredIntervalToLoseWeight = desiredIntervalToLoseWeight;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
