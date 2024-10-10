

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.Role;
import com.wdy.brobrosseur.dao.repository.base._RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Role.
 *
 * @author Geo
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, _RoleRepository {

}
