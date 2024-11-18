package action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.api.Role;
import model.api.Usuario;

public class EditaUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("text/html;charset=UTF-8");

		/* carregando dados de enums */
		req.setAttribute("enums", Arrays.asList(Role.values()));

		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(req.getParameter("id")));
		usuario.setLogin(req.getParameter("login"));
		usuario.setPassword(req.getParameter("password"));
		usuario.setRole(req.getParameter("role"));
		String role = req.getParameter("role");

		String descRole = "";
		if (role == "1") {
			descRole = "ADMIN";
		} else if (role == "2") {
			descRole = "USER";
		}

		req.setAttribute("id", usuario.getId());
		req.setAttribute("login", usuario.getLogin());
		req.setAttribute("role", usuario.getRole());
		req.setAttribute("password", usuario.getPassword());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/editar-usuario.jsp");
		dispatcher.forward(req, resp);

	}


}
