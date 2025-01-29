package com.springBoot.journalProject.service;

import com.springBoot.journalProject.entity.PostEntry;
import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.repository.PostEntryRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EntryService
{

    private final PostEntryRepo postEntryRepo;
    private final UserService uservice;


    public void saveEntry(PostEntry postEntry, String userName)
    {
        try
        {
            User user = uservice.findByUserName(userName);
            postEntry.setDate(LocalDateTime.now());
            PostEntry saved = postEntryRepo.save(postEntry);
            user.getEntry().add(saved);
            uservice.saveEntry(user);
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry ",e);
        }
    }


    public void saveEntry(PostEntry postEntry)
    {
        postEntryRepo.save(postEntry);
    }


    public List<PostEntry> getAll()
    {
        return postEntryRepo.findAll();
    }

    public Optional<PostEntry> findById(ObjectId id)
    {
        return postEntryRepo.findById(id);
    }

    public boolean deleteById(ObjectId id, String userName)
    {
        boolean removed = false;
        try {
            User user = uservice.findByUserName(userName);
            removed = user.getEntry().removeIf(x -> x.getId().equals(id));
            if (removed) {
                uservice.saveEntry(user);
                postEntryRepo.deleteById(id);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
        return removed;
    }
}