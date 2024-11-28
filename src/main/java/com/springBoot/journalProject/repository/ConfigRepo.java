
package com.springBoot.journalProject.repository;

import com.springBoot.journalProject.entity.ConfigEntry;
import com.springBoot.journalProject.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRepo extends MongoRepository<ConfigEntry, ObjectId>
{

}
