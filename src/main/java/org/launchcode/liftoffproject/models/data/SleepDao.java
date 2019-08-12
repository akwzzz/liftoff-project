package org.launchcode.liftoffproject.models.data;

import org.launchcode.liftoffproject.models.Sleep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface SleepDao extends CrudRepository<Sleep, Integer> {
}
