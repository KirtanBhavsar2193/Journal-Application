package com.springBoot.journalProject.service;


import com.springBoot.journalProject.model.SentimentData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SentimentConsumerService {

    private final EmailService emailService;

   // @KafkaListener(topics = "weekly-sentiments", groupId = "weekly-sentiment-group")
    public void consume(SentimentData sentimentData) {
        sendEmail(sentimentData);
    }

    private void sendEmail(SentimentData sentimentData) {
        emailService.sendMail(sentimentData.getEmail(), "Sentiment for previous week", sentimentData.getSentiment(),"kimybh44@gmail.com");
    }
}
