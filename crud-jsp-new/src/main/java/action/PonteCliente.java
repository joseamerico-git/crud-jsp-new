package action;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.api.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PonteCliente {

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("rota do cadastro");
        req.setAttribute("token", req.getParameter("token"));
        req.setAttribute("login", req.getParameter("login"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/cadastroCliente.jsp");
        dispatcher.forward(req, resp);
    }


    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // URL da API
            URL url = new URL("http://localhost:8081/clientes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Configurações da conexão
            con.setRequestMethod("POST");
            String bearer = "Bearer ";
            con.setRequestProperty("X-Content-Type-Options", "nosniff");
            con.setRequestProperty("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
            con.setRequestProperty("X-XSS-Protection", "1; mode=block");
            con.setRequestProperty("Pragma", "no-cache");
            con.setRequestProperty("Transfer-Encoding", "chunked");
            con.setRequestProperty("Vary", "Origin");
            con.setRequestProperty("Vary", "Access-Control-Request-Method");
            con.setRequestProperty("Vary", "Access-Control-Request-Headers");
//Access-Control-Request-Method
            String token = bearer + req.getParameter("token");


            con.setRequestProperty("authorization", token);
            con.setRequestProperty("Content-Type", "application/json");


            con.setDoOutput(true);


            Cliente cliente = new Cliente();
            cliente.setNome(req.getParameter("nome"));


            Gson gson = new Gson();
            String json = gson.toJson(cliente);
            System.out.println("Cheguei aqui " + json);


            String jsonInputString = "{\n" +
                    "  \"login\":\"zetxxx@teste1\",\n" +
                    "  \"password\":\"1\",\n" +
                    "  \"role\":\"ADMIN\"\n" +
                    "  \n" +
                    "}";

            // Enviando a solicitação
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = json.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            // Verificando a resposta
            int responseCode = con.getResponseCode();

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
            System.out.println("token do response " + response.toString());
            // req.setAttribute("id");
            System.out.print(response.toString());

            gson = new Gson();
            cliente = gson.fromJson(response.toString(), Cliente.class);
            System.out.print("codigo do cliente cadastrado " + cliente.getCodigo());
            req.setAttribute("codigo", cliente.getCodigo());
            req.setAttribute("nome", cliente.getNome());
            req.setAttribute("login", req.getParameter("login"));
            req.setAttribute("token", req.getParameter("token"));
            if (responseCode == 200 || responseCode == 201) {

                req.setAttribute("msg", "cadastrado com sucesso!");
            } else if (responseCode > 399) {
                req.setAttribute("msg", "Erro ao cadastrar!");
            }
            // Token tokenObj = gson.fromJson(response.toString(), Token.class);
            // System.out.println(tokenObj.getToken());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/editarCliente.jsp");
            dispatcher.forward(req, resp);
            // resp.getWriter().write("Cadastrado com sucesso!");

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualiza(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print(("rota ponte atualiza"));
        req.setAttribute("token", req.getParameter("token"));
        req.setAttribute("login", req.getParameter("login"));
        req.setAttribute("nome", req.getParameter("nome"));
        req.setAttribute("codigo", req.getParameter("codigo"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editarCliente.jsp");
        dispatcher.forward(req, resp);
    }

    public void lista(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print(("rota ponte lista"));
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-clientesapi.jsp");
        dispatcher.forward(req, resp);
    }

    public void listaByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print(("\n rota ponte lista por nome"));
        req.setAttribute("token", req.getParameter("token"));
        req.setAttribute("login", req.getParameter("login"));
        req.setAttribute("nome",req.getParameter("nome"));
        String nome = req.getParameter("nome");
        System.out.print(nome);
        //String aux = nome.replace(' ','+');
        //System.out.print(aux);

        URL url = new URL("http://localhost:8081/clientes/list?nome="+req.getAttribute("nome"));
        URLConnection urlConnection = url.openConnection();

        urlConnection.setDoOutput(true); // if you need to write to the URL
        urlConnection.setRequestProperty("X-Content-Type-Options", "nosniff");
        urlConnection.setRequestProperty("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        urlConnection.setRequestProperty("X-XSS-Protection", "1; mode=block");
        urlConnection.setRequestProperty("Pragma", "no-cache");
        urlConnection.setRequestProperty("Transfer-Encoding", "chunked");
        urlConnection.setRequestProperty("Vary", "Origin");
        urlConnection.setRequestProperty("Vary", "Access-Control-Request-Method");
        urlConnection.setRequestProperty("Vary", "Access-Control-Request-Headers");
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-clientesapi.jsp");
        dispatcher.forward(req, resp);

    }
}