package com.fidebank;

import java.util.ArrayList;
import com.fidebank.Excepciones.PinInvalidoException;
import com.fidebank.Excepciones.CuentaNoEncontradaException;

public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        clientes = new ArrayList<>();
    }

    public Cliente autenticarCliente(String cedula, String pin) throws PinInvalidoException {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                if (c.validarPin(pin)) return c;
                else throw new PinInvalidoException("PIN incorrecto");
            }
        }
        throw new PinInvalidoException("Cliente no encontrado");
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cuenta abrirCuenta(Cliente cliente) {
        String numero = "ACC-" + (int)(Math.random() * 10000);
        Cuenta nueva = new Cuenta(numero);
        cliente.agregarCuenta(nueva);
        return nueva;
    }

    public Cuenta buscarCuenta(String numeroCuenta) throws CuentaNoEncontradaException {
        for (Cliente c : clientes) {
            for (Cuenta cuenta : c.getCuentas()) {
                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                    return cuenta;
                }
            }
        }
        throw new CuentaNoEncontradaException("Cuenta no encontrada");
    }
}