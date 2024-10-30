package action.services;

import impressao.Impressora;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;

public class Impressao {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String texto = req.getParameter("texto");

        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat pf = pjob.defaultPage();

        try {
            if (pjob.printDialog()) {
                pjob.print();
            }
        } catch (PrinterException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        //new Impressora().detectaImpressoras();
       // new Impressora().imprime(texto);
    }
}
