package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer serviceTypeID;
    protected String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

    public ServiceType() {
    }

    public Integer getServiceTypeID() {
        return serviceTypeID;
    }

    public void setServiceTypeID(Integer serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
