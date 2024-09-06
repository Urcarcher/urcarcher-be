package com.urcarcher.be.syc98syc.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	
//	@Async
//	public void sendMail(String to , String subject, String body, int eCode)
//	{
//		jakarta.mail.internet.MimeMessage message = mailSender.createMimeMessage();
//		try {
//			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8"); 
//			//메일 수신 시 표시될 이름 설정
//			messageHelper.setFrom("testd6145@gmail.com","어카처");
//			messageHelper.setSubject(subject);
//			messageHelper.setTo(to);
//			body += "<h3>" + "아래의 인증 코드를 회원가입 페이지에 입력해주세요." + "</h3>";
//			body += "<h1>" + eCode + "</h1>";
//			messageHelper.setText(body,true);
//			mailSender.send(message);
//		} catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}
	
	@Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(String to, String subject, int name) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // 이메일 수신자와 제목 설정
        helper.setTo(to);
        helper.setSubject(subject);

        // 템플릿에서 HTML 내용을 생성
        Context context = new Context();
        context.setVariable("name", name); // 템플릿에 넘길 변수 설정
        String htmlContent = templateEngine.process("emailTemplate", context);

        // 이메일 내용을 설정 (HTML 형식)
        helper.setText(htmlContent, true);

        // 이메일 전송
        mailSender.send(message);
    }
}
