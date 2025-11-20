package br.com.rota_literaria.api_web_plataform.controller;

import br.com.rota_literaria.api_web_plataform.controller.dto.MailDTO;
import br.com.rota_literaria.api_web_plataform.model.usuario.Email;
import br.com.rota_literaria.api_web_plataform.service.usuario.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<String> enviarEmail(@RequestBody MailDTO mailDTO, Authentication auth) {
        Email email = new Email();
        email.setEmail(mailDTO.to());
        emailService.sendHtmlEmail(email, mailDTO.subject(), "index");

        return ResponseEntity.ok(String.format("Email enviado por: %s", auth.getName()));
    }
}
