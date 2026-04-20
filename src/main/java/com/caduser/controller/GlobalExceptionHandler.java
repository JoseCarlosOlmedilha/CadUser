package com.caduser.controller;

import com.caduser.exception.ResponseErro;
import com.caduser.exception.UsuarioEmailException;
import com.caduser.exception.UsuarioExceprtion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UsuarioExceprtion.class)
    public ResponseEntity<ResponseErro> usuarioExceptionHandler(UsuarioExceprtion ex) {
        ResponseErro erro = new ResponseErro(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(UsuarioEmailException.class)
    public ResponseEntity<ResponseErro> usuarioEmailExceptionHandler(UsuarioEmailException ex) {
        ResponseErro erro = new ResponseErro(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErro> usuarioCPFInvalido(MethodArgumentNotValidException ex) {
        ResponseErro erro = new ResponseErro(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
