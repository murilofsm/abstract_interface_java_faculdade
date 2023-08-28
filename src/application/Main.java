package application;

import controllers.ControleCurso;
import controllers.ControleDisciplina;
import controllers.ControlePessoa;
import controllers.Menus;
import util.DialogBoxUtils;
import util.MenusUtils;

public class Main {
    public static void main(String[] args) {
        ControleCurso controleCurso = new ControleCurso();
        ControlePessoa controlePessoa = new ControlePessoa();
        ControleDisciplina controleDisciplina = new ControleDisciplina();

        boolean travaTela = true;

        do{
            switch (Menus.selecionarOpcaoMenuPrincipal()){
                case 1 ->{
                    controleCurso.menuControleCurso();
                }

                case 2 ->{
                    controleDisciplina.menuControleDisciplina();
                }

                case 3 ->{
                    controlePessoa.menuControlePessoa();
                }
                case 0 ->{
                    travaTela = false;
                }

                default -> MenusUtils.opcaoInvalida();
            }
        }while (travaTela);


    }
}