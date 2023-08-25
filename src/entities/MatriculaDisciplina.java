package entities;

public class MatriculaDisciplina implements IExibirInformacao {
    private int ano;
    private int semestre;
    private double mediaFinal;
    private int percentualFrequencia;
    private String situacao;
    private Disciplina disciplina;
    protected Aluno aluno;

    public MatriculaDisciplina() {
        disciplina = new Disciplina();
        aluno = new Aluno();
    }

    public MatriculaDisciplina(int ano, int semestre, double mediaFinal, int percentualFrequencia, String situacao, Disciplina disciplina, Professor professor, Aluno aluno) {
        this.ano = ano;
        this.semestre = semestre;
        this.mediaFinal = mediaFinal;
        this.percentualFrequencia = percentualFrequencia;
        this.situacao = situacao;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public int getPercentualFrequencia() {
        return percentualFrequencia;
    }

    public void setPercentualFrequencia(int percentualFrequencia) {
        this.percentualFrequencia = percentualFrequencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }



    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String getInformacoes() {
        return null;
    }

    @Override
    public void exibirInformacoes() {

    }
}
