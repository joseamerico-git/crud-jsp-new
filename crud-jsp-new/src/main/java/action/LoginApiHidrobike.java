package action;

import action.auth.Token;
import com.google.gson.Gson;
import dao.UsuarioDao;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;



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
                if(token!=""){


                req.setAttribute("token",tokenObj.getToken());
                // resp.getWriter().write("Cadastrado com sucesso!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/loginApiHidrobike.jsp");
                dispatcher.forward(req, resp);
                }else{
                    
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
    }
