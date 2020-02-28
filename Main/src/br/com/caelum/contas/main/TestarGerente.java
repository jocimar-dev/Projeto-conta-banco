package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Gerente;

public class TestarGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();

        gerente.setNome("João da Silva");
        gerente.setSenha(4231);
        gerente.autentica(4231);

        System.out.println("gerente = " + gerente);
    }
}