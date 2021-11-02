package com.example.emailspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender mailSender;
/* JavaMailSender kütüphanemiz mailimizi gönderecek olan kütühanemizdir.
*  MimeMessage ve MimeMessageHelper mailimizin içeriğini oluşturmada yardımcı olacak kütüphanedir.
* */
    public String sendMail() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        try {
            messageHelper.setTo("emailadress");
            messageHelper.setText("içerik:)");
            messageHelper.setSubject("Konu");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error...";
        }
        mailSender.send(mimeMessage);
        return "Mail Sent!";
    }
}
