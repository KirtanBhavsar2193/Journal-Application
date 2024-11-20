package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private UserService userservice;

    @GetMapping("/all-user")
    public ResponseEntity<?> getAllUser()
    {
        List<User> all = userservice.getAll();
        if (all != null && !all.isEmpty())
        {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public void createAdmin(@RequestBody User user)
    {
        userservice.saveAdmin(user);
    }
}
