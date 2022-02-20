package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer serviceID;
    protected String serviceName;
    protected Integer serviceArea;
    protected Double rentalCost;
    protected Integer maxPeople;
    protected String roomStandard;
    protected String extraAmenity;
    protected Double poolArea;
    protected Integer levels;

    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;

    @ManyToOne(targetEntity = RentalType.class)
    private RentalType rentalType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    public Service() {
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(Double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getExtraAmenity() {
        return extraAmenity;
    }

    public void setExtraAmenity(String extraAmenity) {
        this.extraAmenity = extraAmenity;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
