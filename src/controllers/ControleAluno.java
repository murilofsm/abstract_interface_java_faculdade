package controllers;

import entities.*;
import util.Input;
import util.MenusUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ControleAluno extends ControlePessoa{



     public ControleAluno(){

     }

    public void alterar(){

    }
    protected static void setarDados(Aluno aluno){

        System.out.print("RA: ");
        aluno.setRa(Input.nextLine());
        matricularAlunoCurso(aluno);
        aluno.setMatriculaDisciplina(adicionarMatriculaDisciplinasAluno(aluno));
    }

    protected static void matricularAlunoCurso(Aluno aluno){
        boolean travaCurso = true;
        do{
            System.out.print("Insira o curso que deseja se matricular: ");
            String nomeCurso = Input.nextLine();

            Curso curso = ControleCurso.pesquisaEquals(nomeCurso);
            if (curso != null){

                MatriculaCurso novaMatricula = ControleMatriculaCurso.adicionarNovaMatricula(curso);
                aluno.setMatriculaCurso(novaMatricula);
                curso.getMatriculaCurso().add(novaMatricula);
                travaCurso = false;
            }else {
                System.out.println("\nCurso não encontrado !! Tente Novamente !! \n");
            }
        }while (travaCurso);
    }
    protected static ArrayList<MatriculaDisciplina> adicionarMatriculaDisciplinasAluno(Aluno aluno){
        ArrayList<MatriculaDisciplina> listaDisciplinas = new ArrayList<>();
        do{
            MatriculaDisciplina newMatDisc = ControleMatriculaDisciplina.adicionarNovaMatricula(aluno);
            listaDisciplinas.add(newMatDisc);
            System.out.print("Deseja adicionar uma nova Disciplina? ");
            System.out.print("R: ");
            String resp = Input.nextLine();

            if(!MenusUtils.confirmacaoSim(resp)){
                return listaDisciplinas;
            }
        }while (true);

    }


    public static ArrayList<Pessoa> getListaPessoaAlunos(){
         ArrayList<Pessoa> result = new ArrayList<>();
         for (Pessoa p : getListaPessoas()){
             if (p instanceof Aluno){
                 result.add(p);
             }
         }
         return result;
    }

    public static ArrayList<Aluno> getListaDeAlunos() {
        return (ArrayList<Aluno>) listaPessoas.stream().filter(e -> e.getClass() == Aluno.class).map(a -> (Aluno) a).collect(Collectors.toList());
    }

    @Override
    public void listar() {

    }
}
