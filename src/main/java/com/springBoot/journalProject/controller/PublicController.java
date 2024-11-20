package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController
{
    @Autowired
    private UserService uservice;

    @GetMapping("/health")
    public String health()
    {
        return "OK !!";
    }

    @PostMapping("/insert")
    public void insertUser(@RequestBody User iuser)
    {
        uservice.saveEntry(iuser);
    }
}