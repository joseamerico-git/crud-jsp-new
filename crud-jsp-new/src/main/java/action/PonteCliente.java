package action;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PonteCliente{

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("rota ponte");
        req.setAttribute("token",req.getParameter("token"));
        req.setAttribute("login",req.getParameter("login"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cadastroCliente.jsp");
        dispatcher.forward(req, resp);
    }

    public void atualiza(HttpServletRequest req, HttpServletResponse resp) throws  ServletException,IOException{
        System.out.print(("rota ponte atualiza"));
        req.setAttribute("token",req.getParameter("token"));
        req.setAttribute("login",req.getParameter("login"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editaCliente.jsp");
        dispatcher.forward(req, resp);
    }

    public void lista(HttpServletRequest req, HttpServletResponse resp) throws  ServletException,IOException{
        System.out.print(("rota ponte lista"));
        req.setAttribute("token",req.getParameter("token"));
        req.setAttribute("login",req.getParameter("login"));

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
        Type listType = new TypeToken<ArrayList<Cliente>>() {}.getType();
        ArrayList<Cliente> clientes = gson.fromJson(content.toString(), listType);
        req.setAttribute("clientes",clientes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-clientesapi.jsp");
        dispatcher.forward(req, resp);
    }



}
