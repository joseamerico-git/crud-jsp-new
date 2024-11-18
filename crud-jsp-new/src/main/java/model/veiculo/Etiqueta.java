package model.veiculo;

public class Etiqueta {

    private String livro;
    private String folha;
    private String cidade;
    private String funcionario;
    private String funcao;
    private String motivo;
    private String data;

    public Etiqueta(){

    }

    public Etiqueta(String livro, String folha, String cidade, String funcionario, String funcao, String motivo, String data) {
        this.livro = livro;
        this.folha = folha;
        this.cidade = cidade;
        this.funcionario = funcionario;
        this.funcao = funcao;
        this.motivo = motivo;
        this.data = data;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
