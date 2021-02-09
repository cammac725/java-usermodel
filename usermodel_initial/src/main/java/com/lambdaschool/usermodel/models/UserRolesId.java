package com.lambdaschool.usermodel.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRolesId implements Serializable {

    private long user;

    private long role;

    public UserRolesId() {
    }

    public UserRolesId(long user, long role) {
        this.user = user;
        this.role = role;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
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
        UserRolesId that = (UserRolesId) o;
            // if they share the same userid and role id, they are the same
        return this.user == that.user && this.role == that.role;
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
