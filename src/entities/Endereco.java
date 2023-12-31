package entities;

public class Endereco implements IExibirInformacao{
    protected String cidade;
    protected String rua;
    protected String numero;

    public Endereco() {
    }

    public Endereco(String cidade, String rua, String numero) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getInformacoes() {
        return " Cidade: " + cidade + " Rua: " + rua + " Número: " + numero;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(" Cidade: " + cidade + " Rua: " + rua + " Número: " + numero);
    }
}
