

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.RecordImage;
import com.wdy.brobrosseur.dao.repository.base._RecordImageRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : RecordImage.
 *
 * @author Geo
 */
@Repository
public interface RecordImageRepository extends JpaRepository<RecordImage, Integer>, _RecordImageRepository {

}
