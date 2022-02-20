package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class RentalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer rentalTypeID;
    protected String rentalTypeName;

    @OneToMany(mappedBy = "rentalType")
    private Set<Service> services;

    public RentalType() {
    }

    public Integer getRentalTypeID() {
        return rentalTypeID;
    }

    public void setRentalTypeID(Integer rentalTypeID) {
        this.rentalTypeID = rentalTypeID;
    }

    public String getRentalTypeName() {
        return rentalTypeName;
    }

    public void setRentalTypeName(String rentalTypeName) {
        this.rentalTypeName = rentalTypeName;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
