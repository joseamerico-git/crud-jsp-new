package api.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.Nfe;

public class UtilNfeJson {

	public static String convertJsonFromObject(Nfe nfe, String path) {

		Gson gson = new Gson();

		// Converte um objeto java para json salva no arquivo
		String json = gson.toJson(nfe);

		try {

			FileWriter fileWriter = new FileWriter("nfE.json");
			fileWriter.write(json);
			fileWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;

	}

	public static String converteArrayNfeEmJson(ArrayList<Nfe> listNfe, String nameFile) {

		String jsonteste = new Gson().toJson(listNfe);
		System.out.println("meu json teste === > " + jsonteste);
		salvarArquivo(nameFile, jsonteste);
		return jsonteste;
	}

	/**
	 * Salva um arquivo passando caminho + nome
	 * 
	 * @param path      caminho ou nome do arquivo
	 * @param jsonInput String com o conteúdo do meu .json
	 */
	public static void salvarArquivo(String path, String jsonInput) {
		try {

			FileWriter writer = new FileWriter(path);
			writer.write(jsonInput);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Convete um arquivo de objeto Json para um objeto java
	 * 
	 * @param nfe  A nota fiscal eletrônica
	 * @param path O caminho ou nome do arquivoex: ("arquivo.json")
	 * @return Objeto Nfe Nota fiscal eletrônica
	 * 
	 */
	public static Nfe converteObjetoFromJson(Nfe nfe, String path) {

		Gson gson = new Gson();
		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			// converte o json para objeto java
			nfe = gson.fromJson(bufferedReader, Nfe.class);

		} catch (IOException e) {
			e.printStackTrace();

		}

		return nfe;
	}
}