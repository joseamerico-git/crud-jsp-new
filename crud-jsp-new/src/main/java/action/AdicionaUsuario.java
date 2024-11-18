package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.api.Role;
import model.api.Usuario;

public class AdicionaUsuario {

	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String role = req.getParameter("role");

		if (role.equals("1")) {
			role = Role.ADMIN.getDescricao();
		} else {
			role = Role.USER.getDescricao();
		}

		Usuario usuario = new Usuario(login, password, role);
		new UsuarioDao().salvar(usuario);
		req.setAttribute("msg","Cadastrado com sucesso!");
       // resp.getWriter().write("Cadastrado com sucesso!");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/adiciona-usuarios.jsp");
		dispatcher.forward(req, resp);

	}

}
