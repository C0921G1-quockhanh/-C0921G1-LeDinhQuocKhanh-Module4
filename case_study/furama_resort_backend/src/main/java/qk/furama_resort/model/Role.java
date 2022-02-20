package qk.furama_resort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer roleID;
    protected String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
