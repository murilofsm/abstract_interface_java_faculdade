package controllers;

import entities.Aluno;
import entities.Funcionario;
import entities.Pessoa;
import util.Input;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ControleFuncionario extends ControlePessoa {

    public static void setarDados(Funcionario fun){
        System.out.print("Insira o CTPS: ");
        fun.setCtps(Input.nextLine());
        System.out.print("Insira o salário: ");
        fun.setSalario(Input.nextDouble());
        System.out.print("Insira o cargo: ");
        fun.setCargo(Input.nextLine());
    }
    public ArrayList<Funcionario> listaDeFuncionarios() {
        return (ArrayList<Funcionario>) listaPessoas.stream().filter(e -> e.getClass() == Funcionario.class).map(a -> (Funcionario) a).collect(Collectors.toList());
    }
}
