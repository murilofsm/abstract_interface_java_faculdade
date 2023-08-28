package entities;

import java.time.LocalDate;

public class FuncionarioTercerizado extends Funcionario{
    private String empresaTercerizada;

    public FuncionarioTercerizado(){

    }


    public String getEmpresaTercerizada() {

        return this.empresaTercerizada;
    }

    public void setEmpresaTercerizada(String empresaTercerizada) {
        this.empresaTercerizada = empresaTercerizada;
    }



    @Override
    public String getInformacoes() {

        return super.getInformacoes() + " | Empresa Tercerizada: " + empresaTercerizada;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(super.getInformacoes() + " | Empresa Tercerizada: " + empresaTercerizada);
    }

}
