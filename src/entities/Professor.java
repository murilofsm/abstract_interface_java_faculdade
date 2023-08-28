package entities;

public class Professor extends Funcionario{
    protected String formacao;
    protected Curso curso;

    public Professor() {
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getInformacoes(){
        return super.getInformacoes() + "Formação: " + formacao + " | Curso: " + curso.getNome();
    }
    public void exibirInformacoes(){
        System.out.println(super.getInformacoes() + "Formação: " + formacao + " | Curso: " + curso.getNome());
    }
}
