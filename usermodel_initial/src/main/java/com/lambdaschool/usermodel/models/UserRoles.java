package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userroles")
@IdClass(UserRolesId.class)
public class UserRoles extends Auditable implements Serializable {

    // complex, compound ids
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "roles", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Role role;

    // constructors
    public UserRoles() {
    }

    public UserRoles(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    // getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
            // compare the object to itself
        if (this == o) return true;
            // compare to null or compare the types
        if (o == null || getClass() != o.getClass()) return false;
            // cast the generic object passed in as a UserRolesId object
            // makes sure it has the right methods and fields
        UserRoles that = (UserRoles) o;
            // if they share the same userid and role id, they are the same
        return (((this.user == null) ? 0 : this.user.getUserid())
                        == ((that.user == null) ? 0 : that.user.getUserid()))
                && (((this.role == null) ? 0 : this.role.getRoleid())
                        == ((that.role == null) ? 0 : that.role.getRoleid()));
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
