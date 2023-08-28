package entities;

import java.util.ArrayList;

public class Disciplina implements IExibirInformacao {
    private String nome;
    private int cargaHoraria;
    private int semestre;
    ArrayList<MatriculaDisciplina> matriculaDisciplinas;

    public Disciplina() {
        matriculaDisciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String getInformacoes() {
        return "Nome: " + nome + " | Carga Horária: " + cargaHoraria + " | Semestre: " + semestre;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + " | Carga Horária: " + cargaHoraria + " | Semestre: " + semestre);
    }
}
