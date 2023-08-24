package entities;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
    protected String ctps;
    protected double salario;
    protected String cargo;

    public Funcionario(){

    }
    public Funcionario(String ctps, double salario, String cargo) {
        this.ctps = ctps;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, String email, Endereco endereco, String ctps, double salario, String cargo) {
        super(nome, cpf, dataNascimento, email, endereco);
        this.ctps = ctps;
        this.salario = salario;
        this.cargo = cargo;
    }



    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String getInformacoes() {
        return null;
    }

    @Override
    public void exibirInformacoes() {

    }
}
