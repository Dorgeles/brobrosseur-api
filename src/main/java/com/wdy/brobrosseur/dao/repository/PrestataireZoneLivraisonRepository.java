

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.PrestataireZoneLivraison;
import com.wdy.brobrosseur.dao.repository.base._PrestataireZoneLivraisonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : PrestataireZoneLivraison.
 *
 * @author Geo
 */
@Repository
public interface PrestataireZoneLivraisonRepository extends JpaRepository<PrestataireZoneLivraison, Integer>, _PrestataireZoneLivraisonRepository {

}
