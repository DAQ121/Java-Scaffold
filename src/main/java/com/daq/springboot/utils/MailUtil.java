package com.daq.springboot.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @program: Springboot
 * @description: 发送邮件
 * @author: Daq
 * @create: 2020-07-29 14:03
 **/
@Component
public interface MailUtil {
    /**
     * 发送文本
     * @param subject 主题
     * @param content 内容
     * @param toWho 需要发送的人
     * @param ccPeoples 需要抄送的人
     * @param bccPeoples 需要密送的人
     * @param attachments 需要附带的附件
     */
    void sendSimpleTextMailActual(String subject,String content,String[] toWho,String[] ccPeoples,String[] bccPeoples,String[] attachments);

    /**
     * 发送Html
     * @param subject 主题
     * @param content 内容
     * @param toWho 需要发送的人
     */
    void sendHtmlMail(String subject,String content,String[] toWho);

    /**
     * 处理二进制邮件的基本信息，比如需要带附件的文本邮件、HTML文件、图片邮件、模板邮件等等
     * @param mimeMessageHelper：二进制文件的包装类
     * @param subject：邮件主题
     * @param content：邮件内容
     * @param toWho：收件人
     * @param ccPeoples：抄送人
     * @param bccPeoples：暗送人
     * @param isHtml：是否是HTML文件，用于区分带附件的简单文本邮件和真正的HTML文件
     * @return ：返回这个过程中是否出现异常，当出现异常时会取消邮件的发送
     */
    boolean handleBasicInfo(MimeMessageHelper mimeMessageHelper, String subject, String content, String[] toWho, String[] ccPeoples, String[] bccPeoples, boolean isHtml);

    /**
     * 用于填充简单文本邮件的基本信息
     * @param simpleMailMessage：文本邮件信息对象
     * @param subject：邮件主题
     * @param content：邮件内容
     * @param toWho：收件人
     * @param ccPeoples：抄送人
     * @param bccPeoples：暗送人
     */
    void handleBasicInfo(SimpleMailMessage simpleMailMessage, String subject, String content, String[] toWho, String[] ccPeoples, String[] bccPeoples);

    /**
     * 发送html
     * @param subject：邮件主题
     * @param content：邮件内容
     * @param toWho：收件人
     * @param mimeMessageHelper：二进制文件的包装类
     */
    void handleBasicInfo(MimeMessageHelper mimeMessageHelper,String subject, String content, String[] toWho);

    /**
     * 用于处理附件信息，附件需要 MimeMessage 对象
     * @param mimeMessageHelper：处理附件的信息对象
     * @param subject：邮件的主题，用于日志记录
     * @param attachmentFilePaths：附件文件的路径，该路径要求可以定位到本机的一个资源
     */
    void handleAttachment(MimeMessageHelper mimeMessageHelper,String subject,String[] attachmentFilePaths);
}
