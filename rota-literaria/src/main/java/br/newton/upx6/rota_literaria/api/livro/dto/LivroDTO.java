package br.newton.upx6.rota_literaria.api.livro.dto;

import br.newton.upx6.rota_literaria.validation.constrain.DataPassada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;

public record LivroDTO(@NotBlank(message = "")
                       @Size(max = 100, message = "")
                       String titulo,

                       @NotBlank
                       @Size(max = 50)
                       String isbn,

                       @NotBlank
                       @Size(max = 500)
                       Integer sinopse,

                       @NotBlank
                       @DataPassada
                       String dataLancamento,

                       @NotBlank
                       @UUID
                       String autor,

                       @NotBlank
                       @UUID
                       String editora) {
}
