package com.springBoot.journalProject.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "userinfo")
//@Data
//@Getter
//@Setter
@NoArgsConstructor
public class User
{
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private List<JournalEntry> entry = new ArrayList<>();
    private List<String> roles;

    public ObjectId getId()
    {
        return id;
    }

    public @NonNull String getUserName()
    {
        return userName;
    }

    public @NonNull String getPassword()
    {
        return password;
    }

    public List<JournalEntry> getEntry()
    {
        return entry;
    }

    public List<String> getRoles()
    {
        return roles;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }

    public void setUserName(@NonNull String userName)
    {
        this.userName = userName;
    }

    public void setPassword(@NonNull String password)
    {
        this.password = password;
    }

    public void setEntry(List<JournalEntry> entry)
    {
        this.entry = entry;
    }

    public void setRoles(List<String> roles)
    {
        this.roles = roles;
    }
}

