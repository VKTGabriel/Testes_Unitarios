package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.DataPassada;
import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.NumericoPositivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record RequestLivro(
        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 50, message = "O titulo deve ter no máximo 50 caracteres")
        String titulo,

        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 500, message = "A sinopse deve ter no máximo 500 caracteres")
        String sinopse,

        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 50, message = "O ISBN deve ter no máximo 50 caracteres")
        String isbn,

        @NotBlank(message = "Campo vazio ou nulo")
        @DataPassada
        String dataLancamento,

        @NotBlank(message = "Campo vazio ou nulo")
        @NumericoPositivo
        String edicao,

        @NotBlank(message = "Campo vazio ou nulo")
        @NumericoPositivo
        String numeroPaginas,

        @NotBlank(message = "Campo vazio ou nulo")
        @UUID
        String editora,

        @NotBlank(message = "Campo vazio ou nulo")
        @UUID
        String autor,

        @NotBlank(message = "Campo vazio ou nulo")
        @UUID
        List<String> generos
) {
}
