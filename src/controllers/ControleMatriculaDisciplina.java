package controllers;

import entities.Aluno;
import entities.Disciplina;
import entities.MatriculaDisciplina;
import util.Input;

import java.time.LocalDate;


public class ControleMatriculaDisciplina {



    protected static MatriculaDisciplina adicionarNovaMatricula(Aluno aluno) {
        MatriculaDisciplina matDisp = new MatriculaDisciplina();

        System.out.println("Disciplina: ");
        String nomeDisciplina = Input.nextLine();

        Disciplina resultDisciplina = ControleDisciplina.pesquisaEquals(nomeDisciplina);
        if (resultDisciplina != null){
            matDisp.setDisciplina(resultDisciplina);
            matDisp.setAno(LocalDate.now().getYear());
            System.out.print("Semestre: ");
            matDisp.setSemestre(Input.nextInt());
            System.out.print("Média final: ");
            matDisp.setMediaFinal(Input.nextDouble());
            System.out.print("Percentual de frequencia: ");
            matDisp.setPercentualFrequencia(Input.nextInt());
            System.out.print("Situação: ");
            matDisp.setSituacao(escolhaSituacao());
        }else {
            System.out.println("\nDisciplina não encontrada !! Cancelando Operação !!\n");
            return null;
        }


        return matDisp;
    }

    protected static String escolhaSituacao(){
        do{
            System.out.println(" 1 - Em andamento");
            System.out.println(" 2 - Aprovado");
            System.out.println(" 3 - Reprovado");
            int resp = Input.nextInt();

            switch (resp){
                case 1 -> {
                    return "Em andamento";
                }
                case 2 -> {
                    return "Aprovado";
                }
                case 3 -> {
                    return "Reprovado";
                }
                default ->{
                    System.out.println("\nEscolha inválida !! Tente novamente !! \n");
                }
            }
        }while (true);
    }
}
