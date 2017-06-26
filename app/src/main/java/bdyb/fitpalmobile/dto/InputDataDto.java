package bdyb.fitpalmobile.dto;

import bdyb.fitpalmobile.enums.Gender;
import bdyb.fitpalmobile.enums.PhysicalActivity;

/**
 * Created by BDyb on 2017-06-27.
 */

public class InputDataDto {

    private Double mass;
    private Double height;
    private Gender gender;
    private Integer age;
    private PhysicalActivity physicalActivity;

    public InputDataDto() {
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
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public PhysicalActivity getPhysicalActivity() {
        return physicalActivity;
    }
    public void setPhysicalActivity(PhysicalActivity physicalActivity) {
        this.physicalActivity = physicalActivity;
    }
}