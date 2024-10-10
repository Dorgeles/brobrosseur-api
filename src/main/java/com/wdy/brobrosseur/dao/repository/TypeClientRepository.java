

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.TypeClient;
import com.wdy.brobrosseur.dao.repository.base._TypeClientRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : TypeClient.
 *
 * @author Geo
 */
@Repository
public interface TypeClientRepository extends JpaRepository<TypeClient, Integer>, _TypeClientRepository {

}
