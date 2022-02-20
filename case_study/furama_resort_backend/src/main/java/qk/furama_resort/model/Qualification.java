package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer qualificationID;
    protected String qualificationName;

    @OneToMany(mappedBy = "qualification")
    private Set<Employee> employees;

    public Qualification() {
    }

    public Integer getQualificationID() {
        return qualificationID;
    }

    public void setQualificationID(Integer qualificationID) {
        this.qualificationID = qualificationID;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
