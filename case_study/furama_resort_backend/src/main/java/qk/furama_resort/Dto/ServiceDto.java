package qk.furama_resort.Dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import qk.furama_resort.model.Contract;
import qk.furama_resort.model.RentalType;
import qk.furama_resort.model.ServiceType;
import qk.furama_resort.validate.RegexPattern;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class ServiceDto implements Validator {

    protected Integer serviceID;

    @NotBlank(message = "Name not blank!")
    protected String serviceName;

    protected Integer serviceArea;

    protected Double rentalCost;

    protected Integer maxPeople;

    @NotBlank(message = "Room standard not blank!")
    protected String roomStandard;

    @NotBlank(message = "Extra amenity not blank!")
    protected String extraAmenity;

    protected Double poolArea;

    protected Integer levels;

    private ServiceType serviceType;
    private RentalType rentalType;
    private Set<Contract> contracts;

    public ServiceDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return ServiceDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;

        Integer serviceArea = serviceDto.serviceArea;

        if (serviceArea == null)
            errors.rejectValue("serviceArea","serviceArea.null");
        else {
            if (!RegexPattern.validateIntegerPositive(serviceArea))
                errors.rejectValue("serviceArea","serviceArea.positive");
        }

        Double rentalCost = serviceDto.rentalCost;

        if (rentalCost == null)
            errors.rejectValue("rentalCost","rentalCost.null");
        else {
            if (!RegexPattern.validatePositive(rentalCost))
                errors.rejectValue("rentalCost","rentalCost.positive");
        }

        Integer maxPeople = serviceDto.maxPeople;

        if (maxPeople == null)
            errors.rejectValue("maxPeople","maxPeople.null");
        else {
            if (maxPeople < 0 || maxPeople >20)
                errors.rejectValue("maxPeople","maxPeople.range");
        }

        Double poolArea = serviceDto.poolArea;

        if (poolArea == null)
            errors.rejectValue("poolArea","poolArea.null");
        else {
            if (poolArea < 0)
                errors.rejectValue("poolArea","poolArea.positive");
        }

        Integer levels = serviceDto.levels;

        if (levels == null)
            errors.rejectValue("levels","levels.null");
        else {
            if (levels < 0 || levels > 10)
                errors.rejectValue("levels","levels.range");
        }
    }
}
