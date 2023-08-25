package controllers;

import entities.Funcionario;
import entities.FuncionarioTercerizado;
import util.Input;

public class ControleFuncionarioTercerizado extends ControleFuncionario {
    public static void setarDados(FuncionarioTercerizado funT){

        System.out.print("Empresa Tercerizada: ");
        funT.setEmpresaTercerizada(Input.nextLine());

    }

}
