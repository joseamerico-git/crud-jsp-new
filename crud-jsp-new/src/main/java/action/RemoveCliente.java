package action;

import dao.ClienteDao;
import dao.UsuarioDao;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RemoveCliente {

	public void removeClienteById(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao();
		String nome = req.getParameter("nome");
		Long codigo = Long.valueOf(req.getParameter("codigo"));

		new ClienteDao().excluir(codigo);

		List<Usuario> usuarios = dao.getUsuariosNome(nome);
		req.setAttribute("clientes", usuarios);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/controladora?acao=ListaClientesApi");
		dispatcher.forward(req, resp);
	}
}
