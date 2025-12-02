package com.fidebank;

import java.io.Serializable;
import java.util.ArrayList;
import com.fidebank.Excepciones.SaldoInsuficienteException;

public class Cuenta implements Serializable {
    private String numeroCuenta;
    private double saldo;
    private ArrayList<Transaccion> historial;

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
        this.historial = new ArrayList<>();
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a 0");
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a 0");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        saldo -= monto;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
}
