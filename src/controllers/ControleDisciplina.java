package controllers;

import entities.Disciplina;
import util.Input;
import util.MenusUtils;

import java.util.ArrayList;

public class ControleDisciplina implements ICadastro {
    private static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();

    public static ArrayList<Disciplina> getListaDisciplinas(){
        return listaDisciplinas;
    }

    public void menuControleDisciplina(){
        int op;
        do{
            op = Menus.selecionarOpcaoMenuCadastro("Disciplina");
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
                        listar(getListaDisciplinas());
            }
        }while(op != 0);
    }




    protected static void setarDados(Disciplina disciplina){
        System.out.print("Nome disciplina: ");
        disciplina.setNome(Input.nextLine());
        System.out.print("Carga horária: ");
        disciplina.setCargaHoraria(Input.nextInt());
        System.out.print("Semestre: ");
        disciplina.setSemestre(Input.nextInt());
    }

    @Override
    public void cadastrar() {
        try{
            Disciplina disciplina = new Disciplina();
            setarDados(disciplina);
            listaDisciplinas.add(disciplina);
            MenusUtils.cadastroRealizadoComSucesso();
        }catch (Exception ex){
            MenusUtils.cadastroNaoRealizadoComSucesso();
        }
    }

    @Override
    public void alterar() {
        System.out.println("Insira o nome da Disciplina que deseja alterar: ");
        String dadoBusca = Input.nextLine();
        Disciplina disciplina = pesquisaEquals(dadoBusca);
        if(disciplina != null){
            try {
                setarDados(disciplina);
                MenusUtils.alteracaoSucesso();
            }catch (Exception ex){
                MenusUtils.erroAlteracao();
            }
        }
    }

    @Override
    public void pesquisar() {
        System.out.print("Insira o nome da Disciplina que deseja pesquisar: ");
        String dadoBusca = Input.nextLine();
        ArrayList<Disciplina> resultPesquisa = pesquisaContains(dadoBusca);
        if(!resultPesquisa.isEmpty()){
            try {
                listar(resultPesquisa);
            }catch (Exception ex){
                MenusUtils.erroAlteracao();
            }
        }
    }

    @Override
    public void remover() {
        System.out.print("Insira o nome da Disciplina que deseja remover: ");
        String dadoBusca = Input.nextLine();
        Disciplina disciplina = pesquisaEquals(dadoBusca);
        if (disciplina != null){
            try{
                System.out.println("Deseja realmente removar a disciplina: " + disciplina.getInformacoes());
                String resp = Input.nextLine();
                if(MenusUtils.confirmacaoSim(resp)){
                    getListaDisciplinas().remove(disciplina);
                    MenusUtils.remocaoSucesso();
                }else {
                    MenusUtils.operacaoCanceladaComSucesso();
                }
            }catch (Exception ex){
                MenusUtils.erroRemocao();
            }
        }
    }


    protected static ArrayList<Disciplina> pesquisaContains(String nome){
        ArrayList<Disciplina> resultado = new ArrayList<>();
        for (Disciplina listaDisciplinas : getListaDisciplinas()) {
            if(listaDisciplinas.getNome().contains(nome)){
                resultado.add(listaDisciplinas);
            }
        }
        return resultado;
    }
    protected static Disciplina pesquisaEquals(String nome){
        for (Disciplina listaDisciplinas : getListaDisciplinas()) {
            if(listaDisciplinas.getNome().equals(nome)){
                return listaDisciplinas;
            }
        }
        return null;
    }

    @Override
    public void listar() {
        listar(getListaDisciplinas());
    }
    public static void listar(ArrayList<Disciplina> listaDisciplinas) {
        for(Disciplina disciplina : listaDisciplinas){
            disciplina.exibirInformacoes();
        }
    }
}
