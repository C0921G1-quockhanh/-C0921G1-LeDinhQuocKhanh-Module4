package qk.registration_form.Model;

import javax.validation.constraints.*;

public class UserDto {

    protected Integer id;

    @NotEmpty(message = "First name not empty")
    @Size(min = 5,max = 45,message = "Length from 5 to 45")
    protected String firstName;

    @NotEmpty(message = "Last name not empty")
    @Size(min = 5,max = 45,message = "Length from 5 to 45")
    protected String lastName;

    @NotEmpty(message = "Phone number not empty")
    @Pattern(regexp = "^0[0-9]{9,10}$",message = "Phone number not follow the rules")
    protected String phoneNumber;

    @NotNull(message = "Age not empty")
    @Min(value = 18,message = "Age greater than 18")
    protected Integer age;

    @NotEmpty(message = "Email not empty")
    @Email(message = "Email not follow the rules")
    protected String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
