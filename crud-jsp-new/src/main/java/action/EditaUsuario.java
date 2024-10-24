package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;

public class EditaUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(req.getParameter("id")));
		usuario.setLogin(req.getParameter("login"));
		usuario.setPassword(req.getParameter("password"));
		String role = req.getParameter("role");
		usuario.setRole(req.getParameter("role"));
		String descRole = "";
		if (role == "1") {
			descRole = "ADMIN";
		} else if (role == "2") {
			descRole = "USER";
		}

		System.out.println("Usuario dados novos " + usuario.toString());
		new UsuarioDao().alterar(usuario);

		// List<Usuario> usuarios= dao.getUsuariosNome(login);
		req.setAttribute("id", usuario.getId());
		req.setAttribute("login", usuario.getLogin());
		req.setAttribute("role", usuario.getRole());
		req.setAttribute("password", usuario.getPassword());
		req.setAttribute("descRole", descRole);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/editar-usuario.jsp");
		dispatcher.forward(req, resp);

	}
}
