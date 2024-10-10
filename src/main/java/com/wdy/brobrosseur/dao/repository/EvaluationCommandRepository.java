

package com.wdy.brobrosseur.dao.repository;

import com.wdy.brobrosseur.dao.entity.EvaluationCommand;
import com.wdy.brobrosseur.dao.repository.base._EvaluationCommandRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : EvaluationCommand.
 *
 * @author Geo
 */
@Repository
public interface EvaluationCommandRepository extends JpaRepository<EvaluationCommand, Integer>, _EvaluationCommandRepository {

}
