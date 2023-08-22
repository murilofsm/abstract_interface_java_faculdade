package entities;

import java.time.LocalDate;

public class FuncionarioTercerizado extends Funcionario{
    private String empresaTercerizada;

    public FuncionarioTercerizado(){

    }
    public FuncionarioTercerizado(String nome, String cpf, LocalDate dataNascimento, String email, String ctps, double salario, String cargo, String empresaTercerizada) {
        super(nome, cpf, dataNascimento, email, ctps, salario, cargo);
        this.empresaTercerizada = empresaTercerizada;
    }

    public String getEmpresaTercerizada() {
        return empresaTercerizada;
    }

    public void setEmpresaTercerizada(String empresaTercerizada) {
        this.empresaTercerizada = empresaTercerizada;
    }

}
