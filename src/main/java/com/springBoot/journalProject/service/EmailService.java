package com.springBoot.journalProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService
{
    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String body, String from)
    {
        try
        {
            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            mail.setFrom(from);

            javaMailSender.send(mail);
        }
        catch (Exception e)
        {
            System.out.println("Error in sending Mail !!!!!!!! \n"+ e.getMessage());
            e.printStackTrace();
        }
    }

}
