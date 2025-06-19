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
@Data
//@Getter
//@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    private String email;
    private boolean sentimentAnalysis;
    @NonNull
    private String password;
    @DBRef
    private List<PostEntry> entry = new ArrayList<>();
    private List<String> roles;

   /* public void setEmail(String email) {
        this.email = email;
    }

    public void setSentimentAnalysis(boolean sentimentAnalysis) {
        this.sentimentAnalysis = sentimentAnalysis;
    }

    public String getEmail() {
        return email;
    }

    public boolean isSentimentAnalysis() {
        return sentimentAnalysis;
    }

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

    public List<PostEntry> getEntry()
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

    public void setEntry(List<PostEntry> entry)
    {
        this.entry = entry;
    }

    public void setRoles(List<String> roles)
    {
        this.roles = roles;
    }*/

}