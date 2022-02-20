package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class AccompaniedService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer accompaniedServiceID;
    protected String accompaniedServiceName;
    protected Double price;
    protected String unit;
    protected String status;

    @OneToMany(mappedBy = "accompaniedService")
    private Set<DetailContract> detailContracts;

    public AccompaniedService() {
    }

    public Integer getAccompaniedServiceID() {
        return accompaniedServiceID;
    }

    public void setAccompaniedServiceID(Integer accompaniedServiceID) {
        this.accompaniedServiceID = accompaniedServiceID;
    }

    public String getAccompaniedServiceName() {
        return accompaniedServiceName;
    }

    public void setAccompaniedServiceName(String accompaniedServiceName) {
        this.accompaniedServiceName = accompaniedServiceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(Set<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }
}
