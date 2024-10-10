

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.ImagesPrestation;
import com.wdy.brobrosseur.dao.repository.base._ImagesPrestationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : ImagesPrestation.
 *
 * @author Geo
 */
@Repository
public interface ImagesPrestationRepository extends JpaRepository<ImagesPrestation, Integer>, _ImagesPrestationRepository {

}
