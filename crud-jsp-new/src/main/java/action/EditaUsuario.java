package action;



import dao.UsuarioDao;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EditaUsuario extends HttpServlet {

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
       // String login = req.getParameter("login");
      //  String role = req.getParameter("role");
       // String password = req.getParameter("password");
       int id = Integer.valueOf(idStr);
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        usuario.setId(Integer.valueOf(req.getParameter("id")));
       usuario.setLogin(req.getParameter("login"));
        usuario.setPassword(req.getParameter("password"));
        usuario.setRole(req.getParameter("role"));

        System.out.println("Usuario dados novos "+ usuario.toString());
             new UsuarioDao().alterar(usuario);

       // List<Usuario> usuarios= dao.getUsuariosNome(login);
        req.setAttribute("id",usuario.getId());
        req.setAttribute("login",usuario.getLogin());
        req.setAttribute("role",usuario.getRole());
        req.setAttribute("password",usuario.getPassword());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editar-usuario.jsp");
        dispatcher.forward(req,resp);


    }
}
