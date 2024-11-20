package com.springBoot.journalProject.repository;

import com.springBoot.journalProject.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepo extends MongoRepository<JournalEntry, ObjectId>
{

}
