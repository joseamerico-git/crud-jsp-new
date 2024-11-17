package action.services;

import api.util.Endereco;
import api.util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import dao.UsuarioDao;
import model.Cliente;
import model.Role;
import model.Usuario;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HidroBikeApi {

    public void listarClientesApi(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            System.out.print(("rota lista"));
            req.setAttribute("token", req.getParameter("token"));
            req.setAttribute("login", req.getParameter("login"));

            URL url = new URL("http://localhost:8081/clientes");
            URLConnection urlConnection = url.openConnection();

            urlConnection.setDoOutput(true); // if you need to write to the URL
            urlConnection.setRequestProperty("Content-Type", "application/json");
            String bearer = "Bearer ";
            String token = bearer + req.getParameter("token");


            urlConnection.setRequestProperty("authorization", token);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.print(content.toString());

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Cliente>>() {
            }.getType();
            ArrayList<Cliente> clientes = gson.fromJson(content.toString(), listType);
            req.setAttribute("clientes", clientes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("controladora?acao=RelatorioClientes");
            dispatcher.forward(req, resp);


        } catch (Exception e) {
            System.out.print(e);
        }


}


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