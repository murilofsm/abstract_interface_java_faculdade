package controllers;

import entities.*;
import util.Input;
import util.MenusUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ControlePessoa implements ICadastro{

    protected static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static ArrayList<Pessoa> getListaPessoas(){
        return listaPessoas;
    }

    public ControlePessoa(){

    }
    public void menuControlePessoa(){
        int op;
        do{
            op = Menus.selecionarOpcaoMenuCadastro("Pessoa");
            switch (op){
                case 1 ->
                        cadastrar();
                case 2 ->
                        pesquisar();
                case 3 ->
                        alterar();
                case 4 ->
                        remover();
                case 5 ->
                        listar(getListaPessoas());
            }
        }while(op != 0);
    }

    protected void cadastrarAluno(){
        cadastrar(new Aluno());
    }
    protected void cadastrarFuncionario(){
        cadastrar(new Funcionario());
    }
    protected void cadastrarFuncionarioTercerizado(){
        cadastrar(new FuncionarioTercerizado());
    }
    protected void cadastrarProfessor(){
        cadastrar(new Professor());
    }

    @Override
    public void cadastrar() {
        boolean travaTela = true;
        do{
            System.out.println(" 1 - Cadastrar Aluno: ");
            System.out.println(" 2 - Cadastrar Funcionario: ");
            System.out.println(" 3 - Cadastrar Funcionario Tercerizado: ");
            System.out.println(" 4 - Cadastrar Funcionario Professor: ");
            System.out.print("R:");
            switch (Input.nextInt()){
                case 1 -> {
                    travaTela = false;
                    cadastrarAluno();
                }
                case 2 -> {
                    travaTela = false;
                    cadastrarFuncionario();
                }

                case 3 ->{
                    travaTela = false;
                    cadastrarFuncionarioTercerizado();
                }

                case 4 ->{
                    travaTela = false;
                    cadastrarProfessor();
                }
                default -> System.out.println("\nValor errado !! Tente novamente !!\n");
            }


        }while (travaTela);

    }
    private void cadastrar(Pessoa pessoa) {
        try{
            setarDados(pessoa);
            listaPessoas.add(pessoa);
            MenusUtils.cadastroRealizadoComSucesso();
        }catch (Exception ex){
            MenusUtils.cadastroNaoRealizadoComSucesso();
        }
    }
    protected static void setarDados(Pessoa pessoa){
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
            ControleAluno.setarDados((Aluno) pessoa);
        } else if (pessoa instanceof Funcionario){
            if (pessoa instanceof FuncionarioTercerizado){
                ControleFuncionarioTercerizado.setarDados((FuncionarioTercerizado) pessoa);
            } else if (pessoa instanceof Professor){
                ControleProfessor.setarDados((Professor) pessoa);
            }else{
                ControleFuncionario.setarDados((Funcionario) pessoa);
            }
        }
    }

    @Override
    public void alterar() {
        System.out.println("Insira o nome ou cpf do usuário que deseja ALTERAR: ");
        String resp = Input.nextLine();

        Pessoa pessoaBusca = pesquisaEquals(resp);

        if (pessoaBusca != null){
            setarDados(pessoaBusca);
        }else {
            MenusUtils.usuarioNaoEncontrado();
        }
    }

    @Override
    public void pesquisar() {
        System.out.println("Insira o nome ou cpf do usuário que deseja PESQUISAR: ");
        String resp = Input.nextLine();

        ArrayList<Pessoa> resultListaPessoas = pesquisaContains(resp);

        if (resultListaPessoas.isEmpty()){
            MenusUtils.usuarioNaoEncontrado();
        }else {
            listar(resultListaPessoas);
        }
    }

    protected static ArrayList<Pessoa> pesquisaContains(String dadoBusca){
        ArrayList<Pessoa> result = new ArrayList<>();
        for (Pessoa listaPessoa : getListaPessoas()){
            if (listaPessoa.getNome().contains(dadoBusca) || listaPessoa.getCpf().equals(dadoBusca)){
                result.add(listaPessoa);
            }
        }
        return result;
    }
    protected static Pessoa pesquisaEquals(String dadoBusca){
        for (Pessoa listaPessoa : getListaPessoas()){
            if (listaPessoa.getNome().equals(dadoBusca) || listaPessoa.getCpf().equals(dadoBusca)){
                return listaPessoa;
            }
        }
        return null;
    }

    @Override
    public void remover() {
        System.out.println("Insira o nome ou cpf do usuário que deseja REMOVER: ");
        String resp = Input.nextLine();

        Pessoa pessoaBusca = pesquisaEquals(resp);

        if (pessoaBusca != null){
            getListaPessoas().remove(pessoaBusca);
            MenusUtils.remocaoSucesso();
        }else {
            MenusUtils.usuarioNaoEncontrado();
        }
    }

    public void listar() {
        boolean travaTela = true;
        do{
            System.out.println(" 1 - Listar Aluno: ");
            System.out.println(" 2 - Listar Funcionario: ");
            System.out.println(" 3 - Listar Funcionario Tercerizado: ");
            System.out.println(" 4 - Listar Funcionario Professor: ");
            System.out.print("R:");
            switch (Input.nextInt()){
                case 1 -> {
                    travaTela = false;
                    ordenarLista();
                }
                case 2 -> {
                    travaTela = false;
                    cadastrarFuncionario();
                }

                case 3 ->{
                    travaTela = false;
                    cadastrarFuncionarioTercerizado();
                }

                case 4 ->{
                    travaTela = false;
                    listar();
                }
                default -> System.out.println("\nValor errado !! Tente novamente !!\n");
            }


        }while (travaTela);
    }




    public static int escolhaTipoListagem() {
        System.out.println("Informe a forma de ordenação");
        System.out.println("\n1 - Crescente \n2 - Decrescente");
        System.out.print("opção: ");
        return Input.nextInt();
    }


    public void ordenarLista() {
        int resp = escolhaTipoListagem();
        switch (resp) {
            case 1 ->
                    ordenarLista(listaPessoas, true);
            case 2 ->
                    ordenarLista(listaPessoas, false);
            default ->
                    System.out.println("\nEscolha Inválida !!\n");
        }

    }

    public  void ordenarLista(ArrayList<Pessoa> lista, boolean ordemCrescente) {
        if (ordemCrescente) {
            Collections.sort(lista);
        } else {
            lista.sort(Collections.reverseOrder());
        }
    }


}
