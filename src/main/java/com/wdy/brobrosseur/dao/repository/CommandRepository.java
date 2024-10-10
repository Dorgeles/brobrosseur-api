

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.Command;
import com.wdy.brobrosseur.dao.repository.base._CommandRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Command.
 *
 * @author Geo
 */
@Repository
public interface CommandRepository extends JpaRepository<Command, Integer>, _CommandRepository {

}
