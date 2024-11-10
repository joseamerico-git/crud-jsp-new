package action;

import com.google.gson.Gson;
import dao.UsuarioDao;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;



public class LoginApiHidrobike {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            resp.setContentType("text/html;charset=UTF-8");

            PrintWriter out = resp.getWriter();
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setPassword(password);

            Gson gson = new Gson();

            String json = gson.toJson(usuario);
            String rawData = json;
            String type = "application/x-www-form-urlencoded";
            String encodedData = URLEncoder.encode( rawData, "UTF-8" );
            URL u = new URL("http://localhost:8081/auth/login");
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty( "Content-Type", type );
            conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
            OutputStream os = conn.getOutputStream();
            os.write(encodedData.getBytes());
            System.out.print("chegou auqi");


        }
    }
    }
