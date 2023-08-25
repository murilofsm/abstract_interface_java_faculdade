package entities;

import java.util.ArrayList;

public class Curso implements IExibirInformacao {
    private String nome;
    private int cargaHoraria;
    private int qtdSemestres;
    Professor coordenador;
    private ArrayList<Disciplina> listaDisciplinas;

    public Curso() {
        listaDisciplinas = new ArrayList<>();
    }

    public Curso(String nome, int cargaHoraria, int qtdSemestres, Professor coordenador, ArrayList<Disciplina> listaDisciplinas) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.qtdSemestres = qtdSemestres;
        this.coordenador = coordenador;
        this.listaDisciplinas = listaDisciplinas;
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

    public int getQtdSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(int qtdSemestres) {
        this.qtdSemestres = qtdSemestres;
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public ArrayList<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    @Override
    public String getInformacoes() {
        return null;
    }

    @Override
    public void exibirInformacoes() {

    }
}
