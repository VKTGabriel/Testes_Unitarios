package br.com.rota_literaria.api_web_plataform.service.usuario;

import br.com.rota_literaria.api_web_plataform.config.MailConfiguration;
import br.com.rota_literaria.api_web_plataform.model.usuario.Email;
import br.com.rota_literaria.api_web_plataform.repository.usuario.EmailRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;
    private final MailConfiguration mailConfiguration;

    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendSimpleEmail(Email destinatariao, String assunto, String texto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destinatariao.getEmail());
            message.setSubject(assunto);
            message.setText(texto);
            mailSender.send(message);
            logger.info("Email enviado com sucesso");
        } catch (Exception e) {
            String msg = String.format("Erro ao enviar e-mail: %s", e.getMessage());
            logger.error(msg);
        }
    }

    public void sendHtmlEmail(Email destinatario, String assunto, String htmlFileName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(mailConfiguration.getRemetente());
            helper.setSubject(assunto);
            helper.setTo(destinatario.getEmail());

            String html = carregarHtml(htmlFileName);
            html = html.replace("${nome}","Nome do Usuario");

            helper.setText(html, true);

            mailSender.send(message);
            logger.info("Email HTML enviado com sucesso");
        } catch (Exception e) {
            String msg = String.format("Erro ao enviar e-mail HTML: %s", e.getMessage());
            logger.error(msg);
        }
    }

    public String carregarHtml(String html) throws IOException {
        String htmlFormatado = String.format("static/%s.html", html);
        ClassPathResource classPathResource = new ClassPathResource(htmlFormatado);
        return new String(classPathResource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
