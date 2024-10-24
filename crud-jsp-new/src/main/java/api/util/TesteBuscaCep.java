package api.util;

import java.util.Scanner;

public class TesteBuscaCep {

	public static void main(String[] args) throws Exception {
		System.out.print("Informe seu CEP: ");
		@SuppressWarnings("resource")
		String cep = new Scanner(System.in).nextLine();
		Endereco endereco = BuscaCep.buscaCep(cep);

		System.out.println("CEP Consultado: ");
		System.out.println("Complemento: ");
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Localidade: " + endereco.getLocalidade());
		System.out.println("DDD: " + endereco.getDdd());

	}
}
