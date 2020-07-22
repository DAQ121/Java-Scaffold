package com.daq.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author daq
 * @description 发送邮件的工具类，发送一个简单邮件，发送一个复杂的邮件
 */
@SuppressWarnings("all")
public class SendMailUtil {

    @Autowired
    private static JavaMailSenderImpl mailSender;


    /**
     * @Author daq
     * @description 发送一个简单邮件
     * @param subject 邮件头
     * @param text 邮件体
     */
    public static void sendSimpleMail(String subject,String text){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setTo("1018505421@qq.com");
        mailMessage.setFrom("2829025551@qq.com");
        mailSender.send(mailMessage);
    }


    /**
     * @description 发送一个复杂邮件
     * @param html  是否支持html
     * @param subject 邮件头
     * @param text  邮件体
     * @throws MessagingException 抛出异常
     */
    public static void sendMimeMail(Boolean html,String subject,String text) throws MessagingException {
        {
            //一个复杂的邮件
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            //组装
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
            //正文
            helper.setSubject(subject);
            helper.setText(text,true);
            //附件,添加文件名称以及，文件的相对路径
            helper.addAttachment("1.jpg",new File(""));
            helper.addAttachment("2.jpg",new File(""));
            //发送方和接收方
            helper.setTo("2829025551@qq.com");
            helper.setFrom("2829025551@qq.com");
            mailSender.send(mimeMessage);
        }
    }
}
