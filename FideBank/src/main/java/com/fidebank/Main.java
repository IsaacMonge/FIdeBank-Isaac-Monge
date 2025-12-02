package com.fidebank;


import com.fidebank.Excepciones.*;

public class Main {
    public static void main(String[] args) {
        // Crear el banco
        Banco banco = new Banco();

        // ===== HISTORIA DE USUARIO 1 =====
        System.out.println("=== Abrir una cuenta nueva ===");
        Cliente nuevo = new Cliente("Isaac Monge", "123456789", "2025");
        banco.agregarCliente(nuevo);

        Cuenta cuenta = banco.abrirCuenta(nuevo);
        System.out.println("Cuenta creada exitosamente: " + cuenta.getNumeroCuenta());
        System.out.println("---------------------------------------------");

        // ===== HISTORIA DE USUARIO 2 =====
        System.out.println("=== Autenticarse con PIN ===");
        try {
            Cliente autenticado = banco.autenticarCliente("123456789", "2025");
            System.out.println("Bienvenido, " + autenticado.getNombre());
        } catch (PinInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---------------------------------------------");

        // ===== HISTORIA DE USUARIO 3 =====
        System.out.println("=== Consultar saldo");
        Cuenta c = nuevo.getCuentas().get(0);
        System.out.println("Saldo actual: " + c.consultarSaldo());
        System.out.println("---------------------------------------------");

    }
}