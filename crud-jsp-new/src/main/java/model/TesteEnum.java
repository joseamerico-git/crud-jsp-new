package model;

import model.veiculo.TipoOperacao;

public class TesteEnum {

	public static void main(String[] args) {
		for (TipoOperacao t : TipoOperacao.values()) {
			System.out.println(t.getDescricao() + " - " + t.name());

		}
	}

}
