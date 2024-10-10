

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.ActivitePrestation;
import com.wdy.brobrosseur.dao.repository.base._ActivitePrestationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : ActivitePrestation.
 *
 * @author Geo
 */
@Repository
public interface ActivitePrestationRepository extends JpaRepository<ActivitePrestation, Integer>, _ActivitePrestationRepository {

}
