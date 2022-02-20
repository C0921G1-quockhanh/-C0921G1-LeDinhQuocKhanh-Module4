package qk.furama_resort.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer contractID;
    protected String startDate;
    protected String endDate;
    protected Double deposit;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @ManyToOne(targetEntity = Service.class)
    private Service service;

    @OneToMany(mappedBy = "contract")
    private Set<DetailContract> detailContracts;

    public Contract() {
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
}
