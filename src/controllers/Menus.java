package controllers;
import util.Input;

public class Menus {

    public static void menuPrincipal(){
        System.out.println(" 1 - Controle Aluno");
        System.out.println(" 2 - Controle Funcionário");
        System.out.println(" 3 - Controle Funcionário Tercerizado");
        System.out.println(" 4 - Controle Professor");
        System.out.println(" 5 - Controle Disciplina");
        System.out.println(" 6 - Controle Curso");
    }
    public static void menuControle(String controle){
        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Pesquisar");
        System.out.println(" 3 - Alterar");
        System.out.println(" 4 - Remover");
        System.out.println(" 5 - Listar");
    }

    public static int selecionarOpcaoMenuPrincipal(){
        menuPrincipal();
        System.out.println("R: ");
        return Input.nextInt();
    }

    public static int selecionarOpcaoMenuCadastro(String controle){
        menuControle(controle);
        System.out.print("R: ");
        return Input.nextInt();
    }
}
