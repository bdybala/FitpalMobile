package bdyb.fitpalmobile.dto;

import java.util.Date;

import bdyb.fitpalmobile.enums.Gender;
import bdyb.fitpalmobile.enums.Role;

public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private Date birthday;
    private Gender gender;
    private Double mass;
    private Double height;

    private Double massToLoseWeight;
    private Double desiredIntervalToLoseWeight;

    private Role role;
}
