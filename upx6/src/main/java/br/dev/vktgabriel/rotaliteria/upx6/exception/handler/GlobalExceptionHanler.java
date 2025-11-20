package br.dev.vktgabriel.rotaliteria.upx6.exception.handler;

import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.components.CampoErro;
import br.dev.vktgabriel.rotaliteria.upx6.exception.components.RespostaErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHanler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<RespostaErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<CampoErro> erros = e.getFieldErrors()
                .stream()
                .map((error) -> new CampoErro(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(RespostaErro.unprocessableEntity(erros));
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<RespostaErro> handleRegistroDuplicadoException(RegistroDuplicadoException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(RespostaErro.conflict(e.getCampoErro()));
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RespostaErro> handleRegistroNaoEncontradoException(RegistroNaoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RespostaErro.not_found(e.getCampoErro()));
    }
}
