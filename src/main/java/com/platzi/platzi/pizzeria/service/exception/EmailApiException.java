package com.platzi.platzi.pizzeria.service.exception;

public class EmailApiException extends RuntimeException{
    public EmailApiException() {
        super("Error al enviar correo");
    }
}
