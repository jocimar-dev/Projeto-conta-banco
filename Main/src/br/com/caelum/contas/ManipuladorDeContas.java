package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

import java.util.List;

public class ManipuladorDeContas {
    private Conta conta;

    public void criaConta(Evento evento) {
        String tipoDeConta = evento.getSelecionadoNoRadio("tipo");

        if (tipoDeConta.equals("Conta Corrente")) {
            conta = new ContaCorrente();
        }

        if (tipoDeConta.equals("Conta Poupança")) {
            conta = new ContaPoupanca();
        }

        conta.setAgencia(evento.getString("agencia"));
        conta.setNumero(evento.getInt("numero"));
        conta.setTitular(evento.getString("titular"));
    }

    public void deposita(Evento evento) {
        double valorDigitado = evento.getDouble("valorOperacao");
        conta.depositar(valorDigitado);
    }

    public void saca(Evento evento) {
        double valorDigitado = evento.getDouble("valorOperacao");

        conta.sacar(valorDigitado);
    }

    public void transfere(Evento evento) {
        Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
        conta.transfere(evento.getDouble("valorTransferencia"), destino);
    }

    public void salvaDados(Evento evento){
        List<Conta> contas = evento.getLista("listaContas");
        RepositorioDeContas repository = new RepositorioDeContas();

        repository.salva(contas);
    }
}
