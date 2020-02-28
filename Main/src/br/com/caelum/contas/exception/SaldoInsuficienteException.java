package br.com.caelum.contas.exception;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(double valor) {
        super("Saldo insuficiente para sacar o valor de: " + valor);
    }
}