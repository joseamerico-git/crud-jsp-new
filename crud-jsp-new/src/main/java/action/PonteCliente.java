package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PonteCliente{

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("rota ponte");
        req.setAttribute("token",req.getParameter("token"));
        req.setAttribute("login",req.getParameter("login"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cadastroCliente.jsp");
        dispatcher.forward(req, resp);
    }
}
