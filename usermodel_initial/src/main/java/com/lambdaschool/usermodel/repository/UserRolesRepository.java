package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.UserRoles;
import com.lambdaschool.usermodel.models.UserRolesId;
import org.springframework.data.repository.CrudRepository;

public interface UserRolesRepository extends CrudRepository<UserRoles, UserRolesId> {
}
