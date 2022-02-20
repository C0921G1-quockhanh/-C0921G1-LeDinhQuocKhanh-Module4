package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer positionID;
    protected String positionName;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;

    public Position() {
    }

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


}
