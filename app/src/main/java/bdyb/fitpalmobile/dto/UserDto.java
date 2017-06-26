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
}
