
package com.springBoot.journalProject.repository;

import com.springBoot.journalProject.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId>
{
    User findByUserName(String userName);

    void deleteByUserName(String username);

}
