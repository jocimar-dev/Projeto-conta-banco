package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class RepositorioDeContas {
    public void salva(List<Conta> contas) {
        PrintStream stream = null;

        try {
            stream = new PrintStream("contas.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Conta conta : contas) {
            stream.println(conta.getTipo() + "," + conta.getNumero() + ","
                    + conta.getAgencia() + "," + conta.getTitular() + ","
                    + conta.getSaldo());
        }

        stream.close();
    }
}