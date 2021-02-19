package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Role to the rest of the application
 */
public interface RoleRepository
        extends CrudRepository<Role, Long>
{
    /**
     * JPA Query to find a role by name case insensitive search
     *
     * @param name the name of the role which you seek
     * @return the first role matching the given name using a case insensitive search
     */
    Role findByNameIgnoreCase(String name);

    @Modifying
    @Query(value = "UPDATE roles " +
            "SET name = :name, " +
            "        last_modified_date = CURRENT_TIMESTAMP " +
            "        last_modified_by = :uname " +
            "WHERE roleid = :roleid", nativeQuery = true)
    void updateRoleName(long roleid, String name, String uname);

}
