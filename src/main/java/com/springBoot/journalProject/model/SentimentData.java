package com.springBoot.journalProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SentimentData
{
    private String email;
    private String sentiment;

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSentiment() {
        return sentiment;
    }
}
