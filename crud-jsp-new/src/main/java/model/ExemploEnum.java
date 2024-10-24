package model;

public enum ExemploEnum {
	SALVAR(1), IMPRMIR(2), ABRIR(3), VISUALIZAR(4), FECHAR(5);

	private final int valor;

	ExemploEnum(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}

	public static void escolheOpcao(ExemploEnum opcao) {
		if (opcao == ExemploEnum.SALVAR) {
			System.out.println("Salvando o arquivo!");
		} else if (opcao == ExemploEnum.ABRIR) {
			System.out.println("Abrindo o arquivo!");
		}
	}

	public static void main(String[] args) {

		escolheOpcao(ExemploEnum.ABRIR);
	}

}