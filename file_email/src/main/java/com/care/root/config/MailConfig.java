package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
    public static JavaMailSender mailSender() {
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost("smtp.gmail.com");//google SMTP 서버 설정
        jms.setPort(587);	// google SMTP 메일 포트
        jms.setUsername("woojin97318@gmail.com");
        jms.setPassword("gHarry990!!");

        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.debug", "true");
        jms.setJavaMailProperties(prop);

        return jms;
    }
}
