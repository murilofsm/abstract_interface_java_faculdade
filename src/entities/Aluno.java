package entities;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    protected String ra;
    protected MatriculaDisciplina matriculaDisciplina;
    protected MatriculaCurso matriculaCurso;
    public Aluno(){
        matriculaDisciplina = new MatriculaDisciplina();
        matriculaCurso = new MatriculaCurso();
    }
    public Aluno(String ra, MatriculaDisciplina matriculaDisciplina, MatriculaCurso matriculaCurso) {
        this.ra = ra;
        this.matriculaDisciplina = matriculaDisciplina;
        this.matriculaCurso = matriculaCurso;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public MatriculaDisciplina getMatriculaDisciplina() {
        return matriculaDisciplina;
    }

    public void setMatriculaDisciplina(MatriculaDisciplina matriculaDisciplina) {
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
        return null;
    }

    @Override
    public void exibirInformacoes() {

    }
}
