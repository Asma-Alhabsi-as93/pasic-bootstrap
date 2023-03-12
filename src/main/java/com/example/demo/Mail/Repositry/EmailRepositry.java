package com.example.demo.Mail.Repositry;

import com.example.demo.Mail.Model.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepositry {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
