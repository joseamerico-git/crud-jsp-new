package action.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.api.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioClientes {
    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DocumentException {


        System.out.print("Emitindo relatório...");
        List<Cliente> parameter = (List<Cliente>) req.getAttribute("clientes");
        List<Cliente> clientes = new ArrayList<>();
        if(parameter!=null){
            clientes = new ArrayList<>(parameter);

        }

        Document documento = new Document();
        try {
            resp.setContentType("application/pdf");
            resp.addHeader("Content-Disposition", "inline;filename=" + "cliente.pdf");
            //criar o documento

            PdfWriter.getInstance(documento, resp.getOutputStream());
            //abrir o documento e gerar o conteúdo
            documento.open();
            documento.add(new Paragraph("                Lista de Clientes"));

            documento.add(new Paragraph(" "));


            //criar a tabela
            PdfPTable tabela = new PdfPTable(2);

            PdfPCell col1 = new PdfPCell(new Paragraph("codigo"));
            PdfPCell col2 = new PdfPCell(new Paragraph("nome"));


            tabela.addCell(col1);
            tabela.addCell(col2);



            for(Cliente c: clientes){
                tabela.addCell(String.valueOf(c.getCodigo()));
                tabela.addCell(c.getNome());

            }

            documento.add(tabela);

            documento.close();

        } catch (Exception e) {
            System.out.print(e);
            documento.close();
            throw new RuntimeException(e);
        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-clientesapi.jsp");
        dispatcher.forward(req, resp);

    }
}

