

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.PrestationMoyenDeplacement;
import com.wdy.brobrosseur.dao.repository.base._PrestationMoyenDeplacementRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : PrestationMoyenDeplacement.
 *
 * @author Geo
 */
@Repository
public interface PrestationMoyenDeplacementRepository extends JpaRepository<PrestationMoyenDeplacement, Integer>, _PrestationMoyenDeplacementRepository {

}
