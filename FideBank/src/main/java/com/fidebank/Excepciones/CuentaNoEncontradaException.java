package com.fidebank.Excepciones;

public class CuentaNoEncontradaException extends Exception {
    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}