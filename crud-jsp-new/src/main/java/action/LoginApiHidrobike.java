package action;

import action.auth.Token;
import com.google.gson.Gson;
import model.api.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;


public class LoginApiHidrobike {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            try {
                // URL da API
                URL url = new URL("http://localhost:8081/auth/login");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                // Configurações da conexão
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setDoOutput(true);

                Usuario usuario = new Usuario();
                usuario.setLogin(req.getParameter("login"));
                usuario.setPassword(req.getParameter("password"));
                usuario.setRole("1");



                Gson gson = new Gson();
                String json ="";
                json = gson.toJson(usuario);
                System.out.println(json);
                // Corpo da solicitação
               // String jsonInputString = "{\"login\": \"doichejunior@gmail.com\", \"password\": \"1\", \"role\": 1}";

                // Enviando a solicitação
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = json.getBytes("UTF-8");
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


                in.close();
                Token tokenObj = gson.fromJson(response.toString(), Token.class);
                System.out.println(tokenObj.getToken());
                req.setAttribute("token",tokenObj.getToken());
                req.setAttribute("login",req.getParameter("login"));

                if(responseCode == 200) {

                    RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");
                    dispatcher.forward(req, resp);
                }else if(responseCode==403) {
                    req.setAttribute("mensagem","Usuário não autorizado!");
                    //resp.getWriter().write("Cadastrado com sucesso!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/loginApiHidrobike.jsp");
                    dispatcher.forward(req, resp);
                }else if(responseCode==400){
                    req.setAttribute("mensagem","Insira dados válidos!");
                    //resp.getWriter().write("Cadastrado com sucesso!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/loginApiHidrobike.jsp");
                    dispatcher.forward(req, resp);
                }else if(responseCode==500){
                    req.setAttribute("mensagem","Problemas no servidor! Tente mais tarde!");
                    //resp.getWriter().write("Cadastrado com sucesso!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/loginApiHidrobike.jsp");
                    dispatcher.forward(req, resp);
                }





            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
    }
