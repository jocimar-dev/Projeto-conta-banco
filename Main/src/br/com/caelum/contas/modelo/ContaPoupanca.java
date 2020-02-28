
package br.com.caelum.contas.modelo;

public class ContaPoupanca extends br.com.caelum.contas.modelo.Conta {
    @Override
    public String getTipo() {
        return "Conta Poupança";
    }

    @Override
    public void depositar(double valorDoDeposito) {
        super.depositar(valorDoDeposito);
    }
}