package org.launchcode.liftoffproject.models.data;


import org.launchcode.liftoffproject.models.Trends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TrendsDao extends CrudRepository<Trends, Integer> {
}
