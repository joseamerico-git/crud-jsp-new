package action;

import com.google.gson.Gson;
import model.api.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoveClienteApi {

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // URL da API
            URL url = new URL("http://localhost:8081/clientes/"+ req.getParameter("codigo"));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Configurações da conexão
            con.setRequestMethod("DELETE");

            con.setRequestProperty("X-Content-Type-Options", "nosniff");
            con.setRequestProperty("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
            con.setRequestProperty("X-XSS-Protection", "1; mode=block");
            con.setRequestProperty("Pragma", "no-cache");
            con.setRequestProperty("Transfer-Encoding", "chunked");
            con.setRequestProperty("Vary", "Origin");
            con.setRequestProperty("Vary", "Access-Control-Request-Method");
            con.setRequestProperty("Vary", "Access-Control-Request-Headers");

            String bearer = "Bearer ";
           String token = bearer + req.getParameter("token");



            con.setRequestProperty("authorization", token);
            con.setRequestProperty("Content-Type", "application/json");


            // Verificando a resposta
            int responseCode = con.getResponseCode();

            System.out.println("Response Code: " + responseCode);
           con.disconnect();
            req.setAttribute("token",req.getParameter("token"));

            new PonteCliente().lista(req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
