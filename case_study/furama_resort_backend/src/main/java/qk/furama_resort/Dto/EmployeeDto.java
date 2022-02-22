package qk.furama_resort.Dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import qk.furama_resort.model.*;
import qk.furama_resort.validate.RegexPattern;

import javax.validation.constraints.*;
import java.util.Set;

public class EmployeeDto implements Validator {

    protected Integer employeeID;

    @NotBlank(message = "Name not blank!")
    protected String employeeName;

    @NotBlank(message = "Birthday not blank!")
    @Pattern(regexp = RegexPattern.REGEX_TIME, message = "Birthday form is yyyy-MM-dd!")
    protected String dateOfBirth;

    @NotBlank(message = "Identity number not blank!")
    @Pattern(regexp = RegexPattern.REGEX_IDENTITY_NUMBER, message = "Identity number form is X(9) or X(12)!")
    protected String identityNumber;

    protected Double salary;

    @NotBlank(message = "Phone number not blank!")
    @Pattern(regexp = RegexPattern.REGEX_PHONE_NUMBER, message = "Phone number form is wrong! Type again!")
    protected String phoneNumber;

    @NotBlank(message = "Email not blank!")
    @Email(message = "Email form is wrong! Type again!")
    protected String email;

    protected String address;

    private Position position;
    private Qualification qualification;
    private Department department;
    private User user;
    private Set<Contract> contracts;

    public EmployeeDto() {
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;

        String dateOfBirth = employeeDto.dateOfBirth;
        Double salary = employeeDto.salary;

        if (RegexPattern.validateDateOfBirth(dateOfBirth)) {
            errors.rejectValue("dateOfBirth","dateOfBirth.age");
        }

        if (salary == null) {
            errors.rejectValue("salary","salary.null");
        } else {
            if (!RegexPattern.validatePositive(salary)) {
                errors.rejectValue("salary","salary.positive");
            }
        }
    }
}
