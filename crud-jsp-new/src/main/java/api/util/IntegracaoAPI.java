package api.util;

import com.google.gson.Gson;
import model.Nfe;
import model.veiculo.Veiculo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IntegracaoAPI {


    public static Endereco buscaCep(String cep) throws Exception {
        String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
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
            throw new Exception("Erro de conexão- status Code [" + conexao.getResponseCode() + "]. " + msgErro.toString());
        }

    }

    public static Nfe emitirNotaEletronica(String body) throws Exception {
        String enderecoURL = "https://api.sandbox.plugnotas.com.br/nfe";
        URL url = new URL(enderecoURL);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("POST");
        conexao.setDoInput(true);


        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader((conexao.getInputStream()), "utf-8"));

            String convertJsonString = Util.converteJsonEmString(buff);
            Gson gson = new Gson();
            Nfe nfe = gson.fromJson(convertJsonString, Nfe.class);
            return nfe;

        } catch (Exception msgErro) {
            throw new Exception("Erro de conexão- status Code [" + conexao.getResponseCode() + "]. " + msgErro.toString());
        }
    }




}