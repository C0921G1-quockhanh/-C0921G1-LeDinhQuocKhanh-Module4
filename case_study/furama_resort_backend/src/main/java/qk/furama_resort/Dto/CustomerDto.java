package qk.furama_resort.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import qk.furama_resort.model.Contract;
import qk.furama_resort.model.CustomerType;
import qk.furama_resort.validate.RegexPattern;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDto implements Validator {

//    @NotNull(message = "ID not null")
    protected Integer customerID;

    @NotBlank(message = "Name not blank!")
    protected String customerName;

    @NotBlank(message = "Birthday not blank!")
    @Pattern(regexp = RegexPattern.REGEX_TIME, message = "Birthday form is yyyy-MM-dd!")
    protected String dateOfBirth;

    protected boolean sex;

    @NotBlank(message = "Identity number not blank!")
    @Pattern(regexp = RegexPattern.REGEX_IDENTITY_NUMBER, message = "Identity number form is X(9) or X(12)!")
    protected String identityNumber;

    @NotBlank(message = "Phone number not blank!")
    @Pattern(regexp = RegexPattern.REGEX_PHONE_NUMBER, message = "Phone number form is wrong! Type again!")
    protected String phoneNumber;

    @NotBlank(message = "Email not blank!")
    @Email(message = "Email form is wrong! Type again!")
    protected String email;

    @NotBlank(message = "Address not blank!")
    protected String address;

    private CustomerType customerType;
    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String dateOfBirth = customerDto.dateOfBirth;

        if (RegexPattern.validateDateOfBirth(dateOfBirth)) {
            errors.rejectValue("dateOfBirth","dateOfBirth.age");
        }
    }
}
