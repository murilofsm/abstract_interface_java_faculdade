package controllers;

import entities.Endereco;
import util.Input;

public class ControleEndereco {
    protected static void setarDados(Endereco endereco){
        System.out.print("Cidade: ");
        endereco.setCidade(Input.nextLine());
        System.out.print("Rua: ");
        endereco.setRua(Input.nextLine());
        System.out.print("Número: ");
        endereco.setNumero(Input.nextLine());
    }
}
