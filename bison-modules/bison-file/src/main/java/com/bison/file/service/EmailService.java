package com.bison.file.service;

import com.bison.file.domain.EmailSendHist;
import com.bison.file.domain.EmailTemplate;

import java.util.List;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/10/21 21:58
 */
public interface EmailService {

    EmailSendHist sendEmail(EmailTemplate emailTemplate, TemplateParams templateParams, String toAddress);

    EmailSendHist sendEmail(EmailAccount emailAccount, String toAddress, String subject, String body);

    EmailSendHist sendEmail(String fromAddress, String toAddress, String title, String body, String alias);

    EmailTemplate getTemplate(String key, String language);

    List<EmailTemplate> listTemplates();

    List<EmailTemplate> listTemplates(String classify);

    List<String> listTemplateClassify();
}
