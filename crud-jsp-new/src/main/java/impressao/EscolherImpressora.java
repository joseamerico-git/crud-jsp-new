package impressao;

import java.io.*;

public class EscolherImpressora {

	public static void main(String[] args) {
		 String texto;



			// testando quebra delinhas funcao

			String novoTexto = ("     \n\n" + "                              CUPOM FISCAL         "
					+ "                            \n" + "Pedido: 001         16/07/2024\n" + "Itens: \n" +

					"01 - Óleo de soja COAMO 900ml  KG  6,80 2  13,60 \n"
					+ "01 - Óleo de soja COAMO 900ml  KG  6,80 2  13,60 \n"
					+ "                               total:    27,30     "
					+ "\n Obrigado pela preferência! \n\n Volte sempre!");
			File file = new File("novoCupom.txt");
			if (!file.exists()) {
				System.out.println("Existe");
				try {
					file.createNewFile();
					System.out.println("Arquivo criado!");

					// Fluxo de saida de um arquivo
					OutputStream os = new FileOutputStream("novoCupom.txt"); // nome do arquivo que será escrito
					Writer wr = new OutputStreamWriter(os); // criação de um escritor
					BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

					br.write(novoTexto);
					br.newLine();

					br.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			texto = novoTexto;


	}

}
