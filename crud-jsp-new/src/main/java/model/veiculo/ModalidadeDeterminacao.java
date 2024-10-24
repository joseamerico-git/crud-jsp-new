package model.veiculo;

public enum ModalidadeDeterminacao {

	Margen_valor_agregado("0"), Pauta("1"), Preço_tabelado_max("2"), Valor_operação("3");

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	ModalidadeDeterminacao(String descricao) {
		this.descricao = descricao;
	}

}
