package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.entity.PostEntry;
import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.service.EntryService;
import com.springBoot.journalProject.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class EntryControllerV2
{

    @Autowired
    private EntryService es;
    @Autowired
    private UserService uservice;

    @GetMapping
    public ResponseEntity<?> getallEntriesofUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = uservice.findByUserName(userName);
        List<PostEntry> all = user.getEntry() ;
        if (all != null && !all.isEmpty())
        {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<PostEntry> cerate(@RequestBody PostEntry entry)
    {
        try
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            es.saveEntry(entry, userName);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            System.out.println("Some problem to save post "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("id/{id}")
    public ResponseEntity<PostEntry> getdata(@PathVariable ObjectId id)
    {
        Optional<PostEntry> allEntry = es.findById(id);
        if (allEntry.isPresent())
        {
            return new ResponseEntity<>(allEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("id/{userName}/{id}")
    public ResponseEntity<?> deletedata(@PathVariable ObjectId id, @PathVariable String userName)
    {
        es.deleteById(id, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("id/{userName}/{id}")
    public ResponseEntity<?> update(@PathVariable ObjectId id, @RequestBody PostEntry update, @PathVariable String userName)
    {
        PostEntry old = es.findById(id).orElse(null);
        if (old != null)
        {
            old.setTitle(update.getTitle() != null && !update.getTitle().equals("") ? update.getTitle() : old.getTitle());
            old.setContent(update.getContent() != null && !update.getContent().equals("") ? update.getContent() : old.getContent());
            es.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
