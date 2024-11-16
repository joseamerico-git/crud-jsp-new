package action.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import action.auth.Authentication;
import servlet.PonteCliente;

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
        } else if (acao.equals("FiltrarUsuario")) {

            new ListaUsuarios().getUsuariosByLogin(req, resp);
        } else if (acao.equals("RemoveUsuario")) {

            new RemoveUsuario().removeUsuarioById(req, resp);
        } else if (acao.equals("EditaUsuario")) {
            new EditaUsuario().doPost(req, resp);
        } else if (acao.equals("SalvaUsuario")) {
            System.out.print("Salvando alterações");
            new SalvaUsuario().executa(req, resp);
            //	String mensagem = req.getParameter("mensagem");
            //	req.setAttribute("mensagem", mensagem);
            //req.getRequestDispatcher("resultado.jsp").forward(req, resp);
        } else if (acao.equals("RelatorioUsuario")) {
            new RelatorioUsuario().executa(req, resp);
        } else if (acao.equals("Authentication")) {

            //System.out.println("Bateu na rota authentication");
            new Authentication().doPost(req, resp);
        } else if (acao.equals("auth/register")) {
            new RegisterApiHidrobike().register(req,resp);
        } else if (acao.equals("auth/login")) {

            new LoginApiHidrobike().doPost(req, resp);
        } else if (acao.equals("imprimir")) {
            new Impressao().doPost(req,resp);
        }

        else if (acao.equals("pontecliente")) {
            new PonteCliente().executa(req,resp);
        }
        else if(acao.equals("RegisterClienteApi")){
            System.out.print("rota do register cliente...");
            new RegisterClienteApi().register(req,resp);
        }
    }
}