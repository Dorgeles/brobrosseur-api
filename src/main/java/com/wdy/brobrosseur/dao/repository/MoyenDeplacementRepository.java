

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.MoyenDeplacement;
import com.wdy.brobrosseur.dao.repository.base._MoyenDeplacementRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : MoyenDeplacement.
 *
 * @author Geo
 */
@Repository
public interface MoyenDeplacementRepository extends JpaRepository<MoyenDeplacement, Integer>, _MoyenDeplacementRepository {

}
