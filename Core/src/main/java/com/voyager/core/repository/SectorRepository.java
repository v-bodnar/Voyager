package com.voyager.core.repository;

import com.voyager.model.entity.Sector;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by volodymyr.bodnar on 6/20/2017.
 */
@Repository
public interface SectorRepository extends MongoRepository<Sector, String> {
}
