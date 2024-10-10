

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.Activite;
import com.wdy.brobrosseur.dao.repository.base._ActiviteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Activite.
 *
 * @author Geo
 */
@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Integer>, _ActiviteRepository {

}
