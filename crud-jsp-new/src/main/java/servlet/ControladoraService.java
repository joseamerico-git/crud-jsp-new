package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import action.auth.Authentication;
import action.services.HidroBikeApi;
import action.services.Impressao;

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
			new EditaUsuario().doPost(req, resp);
		}
		else if (acao.equals("SalvaUsuario")){
			System.out.print("Salvando alterações");
			new SalvaUsuario().executa(req,resp);
		//	String mensagem = req.getParameter("mensagem");
		//	req.setAttribute("mensagem", mensagem);
			//req.getRequestDispatcher("resultado.jsp").forward(req, resp);
		}


		else if (acao.equals("RelatorioUsuario")) {
			new RelatorioUsuario().executa(req, resp);
		}

		else if(acao.equals("Authentication")){

			//System.out.println("Bateu na rota authentication");
			new Authentication().doPost(req, resp);
		}else if(acao.equals("auth/register")){
            try {

                new HidroBikeApi().doPost(req,resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
		else if(acao.equals("auth/login")){

			new LoginApiHidrobike().doPost(req,resp);
		}
		else if (acao.equals("imprimir")){
			//new Impressao().doPost(req,resp);
			System.out.println("IMPRIMINDO...");
			StringBuilder saida = new StringBuilder();
			BufferedReader leitor;
			ProcessBuilder processos;

			String livro = req.getParameter("livro");
			String folha = req.getParameter("folha");
			String cidade = req.getParameter("cidade");
			String funcionario = req.getParameter("funcionario");
			String funcao = req.getParameter("funcao");
			String motivo = req.getParameter("motivo");
			String data = req.getParameter("data");
			System.out.println("\"texto\"");

			 String etiqueta ="                   CANCELAMENTO DO TERMO \\n \\n"
					+ "CERTIFICO QUE FICA SEM EFEITOS A PÁGINA DO LIVRO N. " + livro + " FOLHA N. "
					+ folha + ": MOTIVO:  " + motivo + ". " + "\\n EU " + funcionario + ", " + funcao
					+ "(a) CONFERI E ASSINO.\\n" + cidade + " " + data;
             System.out.println(etiqueta);

			Process processo;
			//String comandos ="java -jar C:\\Users\\jose.junior\\Desktop\\Exec\\bin3.jar \""+texto+"\"" ;
			String comandos ="java -jar bin3.jar \""+etiqueta+"\"" ;

			try {
				processos = new ProcessBuilder("cmd.exe", "/c", String.join(" && ", comandos));
				processo = processos.start();
				processo.waitFor();
				leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));

				String linha = "";

				while ((linha = leitor.readLine()) != null) {
					saida.append(linha).append("\n");
				}
			} catch (IOException | InterruptedException ex) {
				System.out.println(ex.getCause());
			}

		}


	}
}
