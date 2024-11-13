package action.services;

import action.auth.Token;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestExample {
    public static void main(String[] args) {
        try {
            // URL da API
            URL url = new URL("http://localhost:8081/auth/login");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            // Configurações da conexão
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            
            // Corpo da solicitação
            String jsonInputString = "{\"login\": \"doichejunior@gmail.com\", \"password\": \"1\", \"role\": 1}";
            
            // Enviando a solicitação
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }
            
            // Verificando a resposta
            int responseCode = con.getResponseCode();
            String token ="";
            System.out.println("Response Code: " + responseCode);
            InputStream inputStream;
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = con.getInputStream();
            } else {
                inputStream = con.getErrorStream();
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                response.append(currentLine);
            }
            System.out.println(response.toString());
            Gson gson = new Gson();
            Token tokenObj = gson.fromJson(response.toString(), Token.class);
            System.out.println(tokenObj.getToken());
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
