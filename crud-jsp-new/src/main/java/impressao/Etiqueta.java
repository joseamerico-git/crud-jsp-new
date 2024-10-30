package impressao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Etiqueta implements Imprimivel {

	private String descricao;
	private String livro;
	private String folha;
	private String data;
	private String motivo;
	private String texto;
	private String funcionario;
	private String funcao = "ESCREVENTE AUTORIZADO";
	private String cidade;

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String getCabecalhoPagina() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

	@Override
	public String getCorpoPagina() {
		// TODO Auto-generated method stub
		return this.texto;
	}

	public String montaEtiqueta() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			Date data = sdf.parse(this.data);

			this.texto = "                     CANCELAMENTO DO TERMO  "
					+ "\n\nCERTIFICO QUE FICA SEM EFEITOS A PÁGINA DO LIVRO N. " + this.livro + " FOLHA N. "
					+ this.folha + ": MOTIVO:  " + this.motivo + ". " + "\n EU " + this.funcionario + ", " + this.funcao
					+ "(a) CONFERI E ASSINO.\n" + this.cidade + " " + sdf.format(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.texto;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
