package com.fidebank;

import java.io.Serializable;
import java.util.Date;

public abstract class Transaccion implements Serializable {
    protected String idTransaccion;
    protected Date fecha;
    protected double monto;
    protected Cuenta cuentaOrigen;
    protected String tipo;

    public Transaccion(double monto, Cuenta cuentaOrigen, String tipo) {
        this.idTransaccion = "T" + System.currentTimeMillis();
        this.fecha = new Date();
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.tipo = tipo;
    }

    public abstract void ejecutar() throws Exception;

    public String generarComprobante() {
        return "Transacción: " + tipo + "\nMonto: " + monto + "\nFecha: " + fecha + "\nCuenta: " + cuentaOrigen.getNumeroCuenta();
    }
}
