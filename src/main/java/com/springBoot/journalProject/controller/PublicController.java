package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.service.UserDetailsServiceImpl;
import com.springBoot.journalProject.service.UserService;
import com.springBoot.journalProject.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/public")
public class PublicController
{

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService uservice;
    private final UserDetailsServiceImpl userDetailsService;


    @GetMapping("/health")
    public String health()
    {
        return "OK !!";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User iuser)
    {
        uservice.saveEntry(iuser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User iuser) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(iuser.getUserName(), iuser.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(iuser.getUserName());
            String jwt = jwtUtils.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }
}