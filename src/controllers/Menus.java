package controllers;
import util.Input;

public class Menus {

    public static void menuPrincipal(){

        System.out.println("1 - Controle Curso");
        System.out.println("2 - Controle Disciplina");
        System.out.println("3 - Controle Pessoas");
        System.out.println("0 - SAIR");

    }
    public static void menuControle(String controle){
        System.out.println("Controle " + controle);
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Pesquisar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Remover");
        System.out.println("5 - Listar");
        if (controle.equals("Curso")){
            System.out.println("6 - teste");
        }
        if (controle.equals("Aluno")){
            System.out.println("6 - Gerenciar matricula disciplina");
            System.out.println("7 - Gerenciar matricula curso");
        }



        System.out.println("0 - VOLTAR");
    }

    public static int selecionarOpcaoMenuPrincipal(){
        menuPrincipal();
        System.out.print("R: ");
        return Input.nextInt();
    }

    public static int selecionarOpcaoMenuCadastro(String controle){
        menuControle(controle);
        System.out.print("R: ");
        return Input.nextInt();
    }
}
