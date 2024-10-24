package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;

@WebServlet("/controladora")
public class ControladoraService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");

		if (acao.equals("ListaUsuarios")) {
			new ListaUsuarios().executa(req, resp);
		} else if (acao.equals("AdicionaUsuario")) {
			new AdicionaUsuario().executa(req, resp);
		}

		else if (acao.equals("FiltrarUsuario")) {

			new ListaUsuarios().getUsuariosByLogin(req, resp);
		} else if (acao.equals("RemoveUsuario")) {

			new RemoveUsuario().removeUsuarioById(req, resp);
		} else if (acao.equals("EditaUsuario")) {
			new EditaUsuario().executa(req, resp);
		}
		else if (acao.equals("RelatorioUsuario")) {
			new RelatorioUsuario().executa(req, resp);
		}


	}
}
