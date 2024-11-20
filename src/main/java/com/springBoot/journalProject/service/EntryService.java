package com.springBoot.journalProject.service;

import com.springBoot.journalProject.entity.JournalEntry;
import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.repository.EntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class EntryService
{
    @Autowired
    private EntryRepo erp;
    @Autowired
    private UserService uservice;

    @Transactional
    public void saveEntry(JournalEntry je, String userName)
    {
        try
        {
            User user = uservice.findByUserName(userName);
            je.setDate(LocalDateTime.now());
            JournalEntry saved = erp.save(je);
            user.getEntry().add(saved);
            uservice.saveEntry(user);
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry ",e);
        }
    }


    public void saveEntry(JournalEntry je)
    {
        erp.save(je);
    }


    public List<JournalEntry> getAll()
    {
        return erp.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id)
    {
        return erp.findById(id);
    }

    public void deleteById(ObjectId id, String userName)
    {
        User user = uservice.findByUserName(userName);
        user.getEntry().removeIf(x -> x.getId().equals(id));
        uservice.saveEntry(user);
        erp.deleteById(id);
    }


}
