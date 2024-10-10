

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.repository.base._PrestationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Prestation.
 *
 * @author Geo
 */
@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Integer>, _PrestationRepository {

}
