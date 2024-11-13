package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import action.auth.Authentication;
import action.services.HidroBikeApi;
import action.services.Impressao;
import action.services.RegisterApiHidrobike;
import model.Etiqueta;

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
            new RegisterApiHidrobike().efetuarLogin(req,resp);
        } else if (acao.equals("auth/login")) {

            new LoginApiHidrobike().doPost(req, resp);
        } else if (acao.equals("imprimir")) {
            new Impressao().doPost(req,resp);
        }
    }
}
