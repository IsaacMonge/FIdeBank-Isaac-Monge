package com.fidebank.Excepciones;

public class PinInvalidoException extends Exception {
    public PinInvalidoException(String mensaje) {
        super(mensaje);
    }
}