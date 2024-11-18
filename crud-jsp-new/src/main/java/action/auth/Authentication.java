package action.auth;


import dao.UsuarioDao;
import model.api.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
          if(usuario.getLogin()!=null){
              req.setAttribute("login", login);
              RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");
              dispatcher.forward(req, resp);
          }
          else{
              req.setAttribute("mensagem", "Usuário ou senha inválidos!");
              RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
              dispatcher.forward(req, resp);
          }





    }
    }
}
