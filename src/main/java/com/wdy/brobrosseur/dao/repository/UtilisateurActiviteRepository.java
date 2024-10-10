

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.UtilisateurActivite;
import com.wdy.brobrosseur.dao.repository.base._UtilisateurActiviteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : UtilisateurActivite.
 *
 * @author Geo
 */
@Repository
public interface UtilisateurActiviteRepository extends JpaRepository<UtilisateurActivite, Integer>, _UtilisateurActiviteRepository {

}
