package entities;

import controllers.IExibirInformacao;
import util.DateUtils;

import java.time.LocalDate;

public abstract class Pessoa implements IExibirInformacao {
    protected String nome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected String email;
    protected Endereco endereco;

    public Pessoa() {
        endereco = new Endereco();
    }

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, String email, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdade(){
        return (int) DateUtils.quantidadeAnosEntreDatas(getDataNascimento(), LocalDate.now());
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
