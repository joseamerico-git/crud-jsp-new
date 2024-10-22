package model;



// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class BaseCalculo {

	private Integer modalidadeDeterminacao;
	private Double valor;
	private Integer quantidade;

	public BaseCalculo(Integer modalidadeDeterminacao, Double valor) {
		this.modalidadeDeterminacao = modalidadeDeterminacao;
		this.valor = valor;
	}

	public BaseCalculo(Double valor, Integer quantidade) {
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public BaseCalculo(Double valor) {
		this.valor = valor;
	}
}
