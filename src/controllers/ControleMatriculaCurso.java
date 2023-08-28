package controllers;

import entities.Aluno;
import entities.Curso;
import entities.MatriculaCurso;
import entities.MatriculaDisciplina;
import util.Input;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControleMatriculaCurso {

    protected static MatriculaCurso adicionarNovaMatricula(Curso curso){
        MatriculaCurso matCurso = new MatriculaCurso();
        matCurso.setCurso(curso);
        matCurso.setAno(LocalDate.now().getYear());
        matCurso.setDataMatricula(LocalDate.now());
        matCurso.setSituacao("Matriculado");

        return matCurso;
    }



    protected static String escolhaSituacao(){
        do{
            System.out.println(" 1 - Matriculado");
            System.out.println(" 2 - Trancado");
            System.out.println(" 3 - Cancelado");
            int resp = Input.nextInt();

            switch (resp){
                case 1 -> {
                    return "Matriculado";
                }
                case 2 -> {
                    return "Trancado";
                }
                case 3 -> {
                    return "Cancelado";
                }
                default ->{
                    System.out.println("\nEscolha inválida !! Tente novamente !! \n");
                }
            }
        }while (true);
    }
    public static int calcAlunosCurso(ArrayList<MatriculaCurso> listaMatCurso){
        int contAlunos = 0;

        for (MatriculaCurso matC : listaMatCurso){
            if (matC.getSituacao().equals("Matriculado")){
                contAlunos++;
            }
        }
        return contAlunos;
    }
}
