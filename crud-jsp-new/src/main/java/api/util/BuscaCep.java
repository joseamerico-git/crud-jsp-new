package api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class BuscaCep {

	public static Endereco buscaCep(String cep) throws Exception {
		String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
		@SuppressWarnings("deprecation")
		URL url = new URL(enderecoURL);
		HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
		conexao.setRequestMethod("GET");
		conexao.setDoInput(true);
		try {
			BufferedReader buff = new BufferedReader(new InputStreamReader((conexao.getInputStream()), "utf-8"));

			String convertJsonString = Util.converteJsonEmString(buff);
			Gson gson = new Gson();
			Endereco endereco = gson.fromJson(convertJsonString, Endereco.class);
			return endereco;

		} catch (Exception msgErro) {
			throw new Exception(
					"Erro de conexão- status Code [" + conexao.getResponseCode() + "]. " + msgErro.toString());
		}

	}

}