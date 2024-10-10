

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.ZoneLivraison;
import com.wdy.brobrosseur.dao.repository.base._ZoneLivraisonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : ZoneLivraison.
 *
 * @author Geo
 */
@Repository
public interface ZoneLivraisonRepository extends JpaRepository<ZoneLivraison, Integer>, _ZoneLivraisonRepository {

}
