package Esercizio7112023.Esercizio7112023.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {
    @Bean
    public JavaMailSender javaMailSender(@Value("${spring.mail.username}")String name,@Value("${spring.mail.password}")String password,@Value("${spring.mail.port}") int port,@Value("${spring.mail.host}") String host) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(name);
        mailSender.setPassword(password);
        mailSender.setProtocol("smtp");



        return mailSender;
    }
}
