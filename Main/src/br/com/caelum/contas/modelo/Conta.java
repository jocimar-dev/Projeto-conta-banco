package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exception.SaldoInsuficienteException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta {
    private static Set<Conta> contas = new HashSet<>();

    protected String titular;
    protected String agencia;
    protected Date dataDeAbertura;
    protected double saldo;
    protected int numero;

    public Conta() {
        dataDeAbertura = Calendar.getInstance().getTime();

        contas.add(this);
    }

    public Conta(String titular, String agencia, double saldo, int numero) {
        this.titular = titular;
        this.agencia = agencia;
        this.dataDeAbertura = Calendar.getInstance().getTime();
        this.saldo = saldo;
        this.numero = numero;

        contas.add(this);
    }

    public static Set<Conta> getContas() {
        return contas;
    }

    public static void setContas(Set<Conta> contas) {
        Conta.contas = contas;
    }

    public void transfere(double valorDaTransferencia, Conta destino) {
        sacar(valorDaTransferencia);
        destino.depositar(valorDaTransferencia);
    }

    public abstract String getTipo();

    public double getRendimento() {
        return saldo + (saldo * 0.1);
    }

    public void sacar(double valorDoSaque) {
        if (valorDoSaque < 0) {
            throw new IllegalArgumentException("Vocẽ tentou sacar um valor negativo");
        }

        if (valorDoSaque > saldo) {
            throw new SaldoInsuficienteException(valorDoSaque);
        }

        saldo -= valorDoSaque;
    }

    public void depositar(double valorDoDeposito) {
        if (valorDoDeposito < 0) {
            throw new IllegalArgumentException("Você informou um valor negativo para o depósito.");
        }

        saldo += valorDoDeposito;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return titular;
    }
}
