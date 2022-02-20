package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer customerTypeID;
    protected String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

    public Integer getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(Integer customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
