

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.UtilisateurRole;
import com.wdy.brobrosseur.dao.repository.base._UtilisateurRoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : UtilisateurRole.
 *
 * @author Geo
 */
@Repository
public interface UtilisateurRoleRepository extends JpaRepository<UtilisateurRole, Integer>, _UtilisateurRoleRepository {

}
