

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.repository.base._UtilisateurRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Utilisateur.
 *
 * @author Geo
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>, _UtilisateurRepository {

}
