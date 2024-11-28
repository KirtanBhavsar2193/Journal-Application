package com.springBoot.journalProject.cache;

import com.springBoot.journalProject.entity.ConfigEntry;
import com.springBoot.journalProject.repository.ConfigRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache
{

    @Autowired
    private ConfigRepo configRepo;

    public Map<String , String> APP_Cache = new HashMap<>();

    @PostConstruct
    public void init()
    {
        List<ConfigEntry> all = configRepo.findAll();
        for (ConfigEntry configEntry : all) {
            APP_Cache.put(configEntry.getKey(), configEntry.getValue());
        }
    }
}
