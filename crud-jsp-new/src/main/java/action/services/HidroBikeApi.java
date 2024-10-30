package action.services;

import api.util.Endereco;
import api.util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.Usuario;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HidroBikeApi {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        System.out.print(req.getParameter("login"));
        System.out.print(req.getParameter("role"));
        System.out.print(req.getParameter("password"));

        Usuario usuario = new Usuario();
        usuario.setLogin(req.getParameter("login"));
        usuario.setPassword(req.getParameter("password"));
        usuario.setRole(req.getParameter("role"));


        // JSON a ser enviado no corpo da requisição
        // String jsonInputString = "{\"nome\": \"João\", \"idade\": 30}";
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(usuario);
        System.out.println("Meu json usuario "+jsonInputString);

        //***************************************

        try {
            String url = "http://localhost:8081/auth/register";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Método POST
            con.setRequestMethod("POST");
            //con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
           // con.setRequestProperty("Content-Type", "application/json");

           // String urlParameters = "username=user&password=pass";

            // Enviando o POST request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(jsonInputString.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprimindo a resposta
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        //***************************************



            /*

            // Envia o JSON no corpo da requisição
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Lê a resposta
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
            /*

        } catch (Exception e) {
            e.printStackTrace();
        }
         */



    }
}