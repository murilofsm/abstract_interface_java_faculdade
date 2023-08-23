package controllers;

import entities.*;
import util.DialogBoxUtils;
import util.Input;

import java.util.ArrayList;

public class ControlePessoa implements ICadastro{

    protected static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static ArrayList<Pessoa> getListaPessoas(){
        return listaPessoas;
    }



    protected static void cadastrarAluno(){
        cadastrar(new Aluno());
    }
    protected static void cadastrarFuncionario(){
        cadastrar(new Funcionario());
    }
    protected static void cadastrarFuncionarioTercerizado(){
        cadastrar(new FuncionarioTercerizado());
    }
    protected static void cadastrarProfessor(){
        cadastrar(new Professor());
    }

    @Override
    public void cadastrar() {

    }
    public static void cadastrarPessoa(Pessoa pessoa) {
        try{
            setarDados(pessoa);
            listaPessoas.add(pessoa);
            DialogBoxUtils.exibirCaixaConfirmacao("Cadastro", "Cadastro realizado com sucesso !!");
        }catch (Exception ex){
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro !! Deu merda no cadastro !!!!");
        }
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
        pessoa.setEndereco(pessoa.getEndereco());

        if (pessoa instanceof Aluno){
            ControleAluno.setarDados();
        } else if (pessoa instanceof Funcionario){
            if (pessoa instanceof FuncionarioTercerizado){

            }else if (pessoa instanceof Professor){

            }else{

            }
        }
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
