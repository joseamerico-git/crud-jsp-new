package action;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import dao.UsuarioDao;
import model.Role;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class RelatorioUsuario {
    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         System.out.print("Emitindo relatório...");

        Document documento = new Document();
        try {
            resp.setContentType("application/pdf");
            resp.addHeader("Content-Disposition", "inline;filename=" + "usuario.pdf");
            //criar o documento

            PdfWriter.getInstance(documento, resp.getOutputStream());
            //abrir o documento e gerar o conteúdo
            documento.open();
            documento.add(new Paragraph("                Lista de Usuários"));

            documento.add(new Paragraph(" "));


            //criar a tabela
            PdfPTable tabela = new PdfPTable(3);

            PdfPCell col1 = new PdfPCell(new Paragraph("Id"));
            PdfPCell col2 = new PdfPCell(new Paragraph("login"));
            PdfPCell col3 = new PdfPCell(new Paragraph("role"));

            tabela.addCell(col1);
            tabela.addCell(col2);
            tabela.addCell(col3);

            List<Usuario> usuarioList = new UsuarioDao().getUsuarios();

            for(Usuario u: usuarioList){
                tabela.addCell(String.valueOf(u.getId()));
                tabela.addCell(u.getLogin());
                tabela.addCell(u.getRole());
            }

            documento.add(tabela);

            documento.close();

        } catch (Exception e) {
            System.out.print(e);
            documento.close();
            throw new RuntimeException(e);
        }



       // RequestDispatcher dispatcher = req.getRequestDispatcher("/controladora?acao=ListaUsuarios");
       // dispatcher.forward(req, resp);

    }
}
