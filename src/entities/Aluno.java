package entities;

import controllers.ControleDisciplina;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    protected String ra;
    protected ArrayList<MatriculaDisciplina> matriculaDisciplina;
    protected MatriculaCurso matriculaCurso;
    public Aluno(){
        matriculaDisciplina = new ArrayList<MatriculaDisciplina>();
        matriculaCurso = new MatriculaCurso();
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public ArrayList<MatriculaDisciplina> getMatriculaDisciplina() {
        return matriculaDisciplina;
    }

    public void setMatriculaDisciplina(ArrayList<MatriculaDisciplina> matriculaDisciplina) {
        this.matriculaDisciplina = matriculaDisciplina;
    }

    public MatriculaCurso getMatriculaCurso() {
        return matriculaCurso;
    }

    public void setMatriculaCurso(MatriculaCurso matriculaCurso) {
        this.matriculaCurso = matriculaCurso;
    }

    @Override
    public String getInformacoes() {

        return super.getInformacoes() + " RA: " + ra + "| Curso: " + matriculaCurso.getCurso().getNome();
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(super.getInformacoes() + " RA: " + ra + "| Curso: " + matriculaCurso.getCurso().getNome());
    }
}
