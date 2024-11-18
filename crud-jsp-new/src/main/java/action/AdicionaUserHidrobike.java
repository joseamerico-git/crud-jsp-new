package action;

import model.api.Role;
import model.api.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdicionaUserHidrobike  {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if (role.equals("1")) {
            role = Role.ADMIN.getDescricao();
        } else {
            role = Role.USER.getDescricao();
        }

        Usuario usuario = new Usuario(login, password, role);
       // new UsuarioDao().salvar(usuario);
        req.setAttribute("msg","Cadastrado com sucesso!");
        // resp.getWriter().write("Cadastrado com sucesso!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/register-users-api.jsp");
        dispatcher.forward(req, resp);
    }
}
