package com.springBoot.journalProject.repository;

import com.springBoot.journalProject.entity.PostEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostEntryRepo extends MongoRepository<PostEntry, ObjectId>
{

}
