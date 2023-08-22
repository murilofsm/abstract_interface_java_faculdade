package controllers;

import entities.ICadastro;
import entities.Pessoa;
import util.Input;

import java.util.ArrayList;

public class ControlePessoa {

    protected static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static ArrayList<Pessoa> getListaPessoas(){
        return listaPessoas;
    }
    public static void setarDados(Pessoa pessoa){
        System.out.print("Nome: ");
        pessoa.setNome(Input.nextLine());
        System.out.print("CPF: ");
        pessoa.setCpf(Input.nextLine());
        System.out.print("Data Nascimento: ");
        pessoa.setDataNascimento(Input.nextLocalDate());
        System.out.print("Email: ");
        pessoa.setEmail(Input.nextLine());
    }
    @Override
    public void cadastrar() {

    }

    @Override
    public void alterar() {

    }

    @Override
    public void pesquisar() {

    }

    @Override
    public void remover() {

    }

    @Override
    public void listar() {

    }
}
