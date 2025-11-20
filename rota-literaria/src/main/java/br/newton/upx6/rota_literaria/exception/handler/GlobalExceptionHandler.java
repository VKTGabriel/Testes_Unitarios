package br.newton.upx6.rota_literaria.exception.handler;

import br.newton.upx6.rota_literaria.exception.dto.CampoErroDTO;
import br.newton.upx6.rota_literaria.exception.dto.ErroRespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<CampoErroDTO> erros = exception.getFieldErrors().stream()
                .map((error) -> new CampoErroDTO(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ErroRespostaDTO.requisicaoInvalida(erros));
    };
}
