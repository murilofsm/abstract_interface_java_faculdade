package controllers;

import entities.Disciplina;
import entities.ICadastro;
import util.DialogBoxUtils;
import util.Input;
import util.MenusUtils;

import java.util.ArrayList;

public class ControleDisciplina implements ICadastro {
    protected static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
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
        Disciplina disciplina = new Disciplina();

        try{
            setarDados(disciplina);
            listaDisciplinas.add(disciplina);
            MenusUtils.cadastroRealizadoComSucesso();
        }catch (Exception ex){
            MenusUtils.cadastroNaoRealizadoComSucesso();
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
