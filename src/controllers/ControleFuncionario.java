package controllers;

import entities.Funcionario;
import util.Input;

public class ControleFuncionario extends ControlePessoa {

    public static void setarDados(Funcionario fun){
        System.out.print("Insira o CTPS: ");
        fun.setCtps(Input.nextLine());
        System.out.print("Insira o salário: ");
        fun.setSalario(Input.nextDouble());
        System.out.print("Insira o cargo: ");
        fun.setCargo(Input.nextLine());
    }
}
