package model;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class BaseCalculo {
	private int modalidadeDeterminacao;
	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getModalidadeDeterminacao() {
		return modalidadeDeterminacao;
	}

	public void setModalidadeDeterminacao(int modalidadeDeterminacao) {
		this.modalidadeDeterminacao = modalidadeDeterminacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	private int quantidade;

	public BaseCalculo() {
	}

	public BaseCalculo(int modalidadeDeterminacao, int valor) {
		this.modalidadeDeterminacao = modalidadeDeterminacao;
		this.valor = valor;
	}

	public BaseCalculo(int valor) {
		this.valor = valor;
	}

	public BaseCalculo(int modalidadeDeterminacao, int valor, int quantidade) {
		this.modalidadeDeterminacao = modalidadeDeterminacao;
		this.valor = valor;
		this.quantidade = quantidade;
	}
}
