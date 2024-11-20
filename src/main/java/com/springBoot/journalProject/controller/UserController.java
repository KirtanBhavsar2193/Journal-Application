package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.repository.UserRepo;
import com.springBoot.journalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService uservice;
    @Autowired
    private UserRepo urepo;


    @GetMapping
    public List<User> getAllUser()
    {
        return uservice.getAll();
    }

    @PutMapping
    public ResponseEntity<?> updateuser(@RequestBody User uuser)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userIndb = uservice.findByUserName(userName);
        userIndb.setUserName(uuser.getUserName());
        userIndb.setPassword(uuser.getPassword());
        uservice.saveEntry(userIndb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        urepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}