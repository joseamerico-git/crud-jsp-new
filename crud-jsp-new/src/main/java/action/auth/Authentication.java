package action.auth;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import dao.UsuarioDao;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Authentication  {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      {
            resp.setContentType("text/html;charset=UTF-8");

            PrintWriter out = resp.getWriter();
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            byte chave1[] = login.getBytes();
            byte chave2[] = password.getBytes();

          Usuario usuario = new UsuarioDao().getUsuarioLoginSenha(login,password);
          System.out.println("Usuário autenticado: "+usuario.getLogin());




    }
    }
}
