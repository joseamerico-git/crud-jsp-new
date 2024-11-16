package action;

import com.google.gson.Gson;
import model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterClienteApi {

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
            System.out.println("Cheguei aqui "+ json);




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
            System.out.println("token do response "+ response.toString());
           // req.setAttribute("id");
           System.out.print(response.toString());

           gson = new Gson();
             cliente = gson.fromJson(response.toString(), Cliente.class);
             System.out.print("codigo do cliente cadastrado "+cliente.getCodigo());
            req.setAttribute("codigo",cliente.getCodigo());
            req.setAttribute("nome",cliente.getNome());
            req.setAttribute("login",req.getParameter("login"));
            req.setAttribute("msg","cadastrado com sucesso!");
            req.setAttribute("token",req.getParameter("token"));
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


}
