package br.com.caelum.contas.modelo;

public class ContaCorrente extends br.com.caelum.contas.modelo.Conta implements Tributavel {
    @Override
    public void sacar(double valorDoSaque) {
        saldo -= (valorDoSaque + 0.10);
    }

    @Override
    public void depositar(double valorDoDeposito) {
        super.depositar(valorDoDeposito);
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }
}
