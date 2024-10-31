package action.services;

import api.util.Endereco;
import api.util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.UsuarioDao;
import model.Role;
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

        String role = req.getParameter("role");



        if (role.equals("ROLE_ADMIN")) {
            role = "0";
        } else if(role.equals("ROLE_USER")) {
            role = "1";
        }else{
            role="2";
        }
        Usuario usuario = new Usuario(req.getParameter("login"), req.getParameter("password"), role);
       // new UsuarioDao().salvar(usuario);
        req.setAttribute("msg","Cadastrado com sucesso!");
        System.out.print(role);


        // JSON a ser enviado no corpo da requisição
        // String jsonInputString = "{\"nome\": \"João\", \"idade\": 30}";
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(usuario);
        System.out.println("Meu json usuario "+jsonInputString);

        //***************************************

        URL url = new URL("http://localhost:8081/auth/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
/*
         jsonInputString = "{\n" +
                "  \"login\":\"doichejunior@teste1112\",\n" +
                "  \"password\":\"123\",\n" +
                "  \"role\":\"1\"\n" +
                "  \n" +
                "}\n";
*/
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
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