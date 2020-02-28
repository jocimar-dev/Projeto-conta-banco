package br.com.caelum.contas.modelo;

public class Gerente extends br.com.caelum.contas.modelo.Funcionario {
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    public Gerente() {
    }

    public Gerente(String nome, String cpf, double salario, int senha, int numeroDeFuncionariosGerenciados) {
        super(nome, cpf, salario);
        this.senha = senha;
        this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
    }

    @Override
    public double getBonificacao() {
        return super.getBonificacao() + 1000;
    }

    public boolean autentica(int senha) {
        if (this.senha == senha) {
            System.out.println("Acesso Permitido!");
            return true;
        }

        System.out.println("Acesso Negado!");
        return false;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getNumeroDeFuncionariosGerenciados() {
        return numeroDeFuncionariosGerenciados;
    }

    public void setNumeroDeFuncionariosGerenciados(int numeroDeFuncionariosGerenciados) {
        this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "senha=" + senha +
                ", numeroDeFuncionariosGerenciados=" + numeroDeFuncionariosGerenciados +
                '}';
    }
}