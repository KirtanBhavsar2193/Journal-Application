package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.api.response.WeatherResponse;
import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.repository.UserRepo;
import com.springBoot.journalProject.service.UserService;
import com.springBoot.journalProject.service.WeatherService;
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
    @Autowired
    private WeatherService weatherService;


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

    @GetMapping("/say")
    public ResponseEntity<?> greeting()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<WeatherResponse> weatherResponse = (List<WeatherResponse>) weatherService.getWeather("India");
        if (weatherResponse == null || weatherResponse.isEmpty()) {
            return new ResponseEntity<>("Hyy " + authentication.getName() + "\nNo universities found.", HttpStatus.OK);
        }
        StringBuilder univerBuilder = new StringBuilder();
        for (WeatherResponse response : weatherResponse) {
            univerBuilder.append(response.toString()).append("\n");
        }
        return new ResponseEntity<>("Hyy " + authentication.getName() + "\n" + univerBuilder.toString(), HttpStatus.OK);
    }

}