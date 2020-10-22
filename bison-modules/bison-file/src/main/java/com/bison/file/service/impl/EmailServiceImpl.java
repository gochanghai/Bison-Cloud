package com.bison.file.service.impl;

import com.bison.common.core.utils.StringUtils;
import com.bison.file.domain.EmailTemplate;
import com.bison.file.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/10/21 22:00
 */
public class EmailServiceImpl implements EmailService {

    private static final InstaLanguage DEFAULT_TEMPLATE_LANGUAGE = InstaLanguage.en_US;

    @Autowired
    EmailAccountDao accountDao;

    @Autowired
    EmailTemplateDao emailTemplateDao;

    @Autowired
    EmailSendRecordService emailSendRecordService;

    @Autowired
    EmailSender emailSender;

    @Autowired
    TemplateHandlerFactory templateHandlerFactory;

    @Override
    public EmailSendRecord sendEmail(EmailTemplate emailTemplate, TemplateParams templateParams, String toAddress) {
        if (emailTemplate == null) {
            //throw new InstaException(CommonErrorCode.TemplateNotFound);
        }

        EmailTemplateType templateType = EmailTemplateType.parse(emailTemplate.getTemplateType());
        TemplateHandler templateHandler = templateHandlerFactory.getTemplateHandler(templateType);
        templateHandler.handle(emailTemplate, templateParams);
        String subject = templateHandler.getSubject();
        String body = templateHandler.getBody();

        EmailAccount emailAccount = accountDao.selectById(emailTemplate.getFromAccount());
        EmailSendRecord sendRecord = sendEmail(emailAccount, toAddress, subject, body);

        // 保存邮件模板信息
        sendRecord.setTemplate(emailTemplate.getKey());
        sendRecord.setLanguage(emailTemplate.getLanguage());
        emailSendRecordService.updateById(sendRecord);

        return sendRecord;
    }

    @Override
    public EmailSendRecord sendEmail(EmailAccount emailAccount, String toAddress, String subject, String body) {
        if (emailAccount == null) {
            //throw new InstaException(CommonErrorCode.EmailAccountNotFound);
        }

        if (StringUtils.isBlank(subject)) {
            //throw new InstaException(CommonErrorCode.InvalidEmailSubject);
        }

        if (StringUtils.isBlank(body)) {
            //throw new InstaException(CommonErrorCode.InvalidEmailBody);
        }

        String fromAddress = emailAccount.getEmail();
        String alias = emailAccount.getAlias();

        EmailSender.EmailData emailData = new EmailSender.EmailData();
        emailData.setFromAddres(fromAddress);
        emailData.setToAddress(toAddress);
        emailData.setSubject(subject);
        emailData.setBody(body);
        emailData.setAlias(alias);
        return emailSender.sendEmail(emailData);
    }

    @Override
    public EmailSendRecord sendEmail(String fromAddress, String toAddress, String subject, String body, String alias) {
        EmailSender.EmailData emailData = new EmailSender.EmailData();
        emailData.setFromAddres(fromAddress);
        emailData.setToAddress(toAddress);
        emailData.setSubject(subject);
        emailData.setBody(body);
        emailData.setAlias(alias);
        return emailSender.sendEmail(emailData);
    }

    @Override
    public EmailTemplate getTemplate(String key, InstaLanguage language) {
        if (language != null) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("`key`", key);
            wrapper.eq("language", language.name());
            EmailTemplate template = emailTemplateDao.selectOne(wrapper);
            if (template != null) {
                return template;
            }
        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("`key`", key);
        wrapper.eq("language", DEFAULT_TEMPLATE_LANGUAGE.name());
        return emailTemplateDao.selectOne(wrapper);
    }

    @Override
    public List<EmailTemplate> listTemplates() {
        QueryWrapper<EmailTemplate> qw = new QueryWrapper<>();
        qw.select("`key`", "`language`","title");
        return emailTemplateDao.selectList(qw);
    }

    @Override
    public List<EmailTemplate> listTemplates(String classify) {
        QueryWrapper<EmailTemplate> qw = new QueryWrapper<>();
        qw.select("`key`", "`language`","title");
        qw.eq("classify", classify);
        return emailTemplateDao.selectList(qw);
    }

    @Override
    public List<String> listTemplateClassify() {
        QueryWrapper<EmailTemplate> qw = new QueryWrapper<>();
        qw.select("DISTINCT(classify)");
        List<EmailTemplate> emailTemplates = emailTemplateDao.selectList(qw);
        return emailTemplates.stream().map(t->t.getClassify()).collect(Collectors.toList());
    }
}
