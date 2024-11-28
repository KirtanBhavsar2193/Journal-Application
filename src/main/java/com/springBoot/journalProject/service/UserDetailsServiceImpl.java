package com.springBoot.journalProject.service;

import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo urepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = urepo.findByUserName(username);
        if (user != null)
        {
            UserDetails userdetail = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
            return userdetail;
        }
        System.out.println("\n\n\n error: User Not Found with UserName " + "\n\n\n");
        throw new UsernameNotFoundException("User Not Found with UserName " + username);
    }
}
