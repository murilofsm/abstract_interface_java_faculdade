package controllers;

import entities.Aluno;
import entities.Pessoa;
import entities.Professor;
import util.Input;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ControleProfessor extends ControlePessoa{

    protected static void setarDados(Professor prof){
        ControleFuncionario.setarDados(prof);
        System.out.println("Formacao: ");
        prof.setFormacao(Input.nextLine());
    }

    public static ArrayList<Professor> listaDeProfessores() {
        return (ArrayList<Professor>) listaPessoas.stream().filter(e -> e.getClass() == Professor.class).map(a -> (Professor) a).collect(Collectors.toList());
    }
    public void listar() {
        for (Professor listaPessoa : listaDeProfessores()){
            listaPessoa.exibirInformacoes();
        }
    }
}
