package entities;

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

    public Aluno(String ra, ArrayList<MatriculaDisciplina> matriculaDisciplina, MatriculaCurso matriculaCurso) {
        this.ra = ra;
        this.matriculaDisciplina = matriculaDisciplina;
        this.matriculaCurso = matriculaCurso;
    }

    public Aluno(String nome, String cpf, LocalDate dataNascimento, String email, Endereco endereco, String ra, ArrayList<MatriculaDisciplina> matriculaDisciplina, MatriculaCurso matriculaCurso) {
        super(nome, cpf, dataNascimento, email, endereco);
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
        return null;
    }

    @Override
    public void exibirInformacoes() {

    }
}
