package com.junrylmaraviles.job.portal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Value("${spring.mail.host}") private String host;
    @Value("${spring.mail.port}") private String port;
    @Value("${spring.mail.debug}") private String debug;

    public MailService() {
    }

    public void sendMail(String email, String subject, String text) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.debug", debug);
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("admin@jobseekers.ph"));
        message.setRecipient(RecipientType.TO, new InternetAddress(email));
        message.setSubject(subject);
        message.setText(text, "UTF-8"); // as "text/plain"
        message.setSentDate(new Date());
        Transport.send(message);
    }

}
