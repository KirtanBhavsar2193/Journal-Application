/*
package com.springBoot.journalProject.service;

import com.springBoot.journalProject.repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class UserDetailsServiceImplTest
{
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepo urepo;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest()
    {
        when(urepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(
                (com.springBoot.journalProject.entity.User)
                        User.builder().username("Joy").password("wefger").roles(String.valueOf(new ArrayList<>())).build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}*/
