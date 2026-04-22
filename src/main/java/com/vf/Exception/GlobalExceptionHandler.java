//package com.vf.Exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.NoSuchElementException;
//
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ErroResposta> handleNotFound(NoSuchElementException ex){
//        ErroResposta erro = new ErroResposta("Recurso não encontrado no banco de dados", HttpStatus.NOT_FOUND.value());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErroResposta> handleGeneralError(Exception ex){
//        ErroResposta err = new ErroResposta("Erro interno no servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
//    }
//}
