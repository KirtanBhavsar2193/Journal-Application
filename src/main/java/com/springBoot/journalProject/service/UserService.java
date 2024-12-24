package com.springBoot.journalProject.service;

import com.springBoot.journalProject.entity.User;
import com.springBoot.journalProject.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
//@Slf4j
@RequiredArgsConstructor
public class UserService
{

    private final UserRepo urepo;

    private static final PasswordEncoder passEncoder = new BCryptPasswordEncoder();

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public boolean saveEntry(User user)
    {
        try {
            user.setPassword(passEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            urepo.save(user);
            return true;
        }
        catch (Exception e)
        {
            log.error("hahahahahaha");
            log.info("hahahahahaha");
            log.warn("hahahahahaha");
            log.debug("hahahahahaha");
            log.trace("hahahahahaha");
            return false;
        }
    }

    public void saveNewUser(User user)
    {
        user.setPassword(passEncoder.encode(user.getPassword()));
        urepo.save(user);
    }

    public List<User> getAll()
    {
        return urepo.findAll();
    }

/*
    public Optional<user> findById(ObjectId id)
    {
        return urepo.findById(id);
    }


    public void deleteById(ObjectId id)
    {
        urepo.deleteById(id);
    }*/


    public User findByUserName(String userName)
    {
        return urepo.findByUserName(userName);
    }

    public void saveAdmin(User user)
    {
        user.setPassword(passEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        urepo.save(user);
    }
}