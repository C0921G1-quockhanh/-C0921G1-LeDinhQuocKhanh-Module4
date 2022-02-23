package qk.furama_resort.Dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import qk.furama_resort.model.Customer;
import qk.furama_resort.model.DetailContract;
import qk.furama_resort.model.Employee;
import qk.furama_resort.model.Service;
import qk.furama_resort.validate.RegexPattern;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class ContractDto implements Validator {

    protected Integer contractID;

    @NotBlank(message = "Start date not blank")
    @Pattern(regexp = RegexPattern.REGEX_TIME, message = "Date form is yyyy-MM-dd!")
    protected String startDate;

    @NotBlank(message = "End date not blank")
    @Pattern(regexp = RegexPattern.REGEX_TIME, message = "Date form is yyyy-MM-dd!")
    protected String endDate;

    protected Double deposit;

    private Employee employee;
    private Customer customer;
    private Service service;
    private Set<DetailContract> detailContracts;

    public ContractDto() {
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(Set<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ContractDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        Double deposit = contractDto.deposit;

        if (deposit == null)
            errors.rejectValue("deposit","deposit.null");
        else {
            if (deposit <= 0)
                errors.rejectValue("deposit","deposit.positive");
        }

        String startDate = contractDto.startDate;
        String endDate = contractDto.endDate;

        if (RegexPattern.validateDateContract(startDate,endDate)) {
            errors.rejectValue("startDate","startDate.before");
            errors.rejectValue("endDate","endDate.after");
        }
    }
}
