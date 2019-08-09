package org.launchcode.liftoffproject.models.data;

import org.launchcode.liftoffproject.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface FoodDao extends CrudRepository<Food, Integer> {
}
