package com.fidebank;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private String nombre;
    private String cedula;
    private String pin;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String cedula, String pin) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.pin = pin;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(numeroCuenta)) {
                return c;
            }
        }
        return null;
    }

    public boolean validarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public ArrayList<Cuenta> getCuentas() { return cuentas; }
}

//bla bla bla