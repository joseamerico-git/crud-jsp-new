package action;


import dao.ClienteDao;

import model.Cliente;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ListaClientesApi {
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.print("ListaClietnesApi");
		System.out.print("meu token "+req.getParameter("token"));
		System.out.print("meu cliente "+req.getParameter("nome"));


		URL url = new URL("http://localhost:8081/clientes");
		URLConnection urlConnection = url.openConnection();

		urlConnection.setDoOutput(true); // if you need to write to the URL
		urlConnection.setRequestProperty("Content-Type", "application/json");
		String bearer = "Bearer ";
		String token = bearer + req.getParameter("token");



		urlConnection.setRequestProperty("authorization", token);
		urlConnection.setRequestProperty("Content-Type", "application/json");
		urlConnection.connect();

		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		System.out.print(content.toString());
		//Gson gson = new Gson();
		//List<Cliente> clientes = gson.fromJson(content,Cliente.class)

		/*

		List<Cliente> clientes = dao.getClientes();
		*/

	//	req.setAttribute("clientes", clientes);
	//	RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-clientesapi.jsp");
		//dispatcher.forward(req, resp);
	}

	public void getClienteByNome(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		String nome = req.getParameter("nome");
		List<Cliente> usuarios = dao.getUsuariosNome(nome);
		req.setAttribute("clientes", usuarios);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-clientesapi.jsp");
		dispatcher.forward(req, resp);
	}

}
