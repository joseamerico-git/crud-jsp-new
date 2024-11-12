package action.services;

import impressao.Impressora;
import model.Etiqueta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class Impressao {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //new Impressao().doPost(req,resp);
        System.out.println("IMPRIMINDO...");
        StringBuilder saida = new StringBuilder();
        BufferedReader leitor;
        ProcessBuilder processos;

        String data = req.getParameter("data");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setLivro(req.getParameter("livro"));
        etiqueta.setFolha(req.getParameter("folha"));
        etiqueta.setCidade(req.getParameter("cidade"));
        etiqueta.setFuncionario(req.getParameter("funcionario"));
        etiqueta.setFuncao(req.getParameter("funcao"));
        etiqueta.setMotivo(req.getParameter("motivo"));

        etiqueta.setData(req.getParameter("data"));
        System.out.println("\"texto\"");


        String et = "                                   CANCELAMENTO DO TERMO                                   "
                + "CERTIFICO QUE FICA SEM EFEITOS A PÁGINA DO LIVRO N. " + etiqueta.getLivro() + " FOLHA N. "
                + etiqueta.getFolha() + ": MOTIVO:  " + etiqueta.getMotivo() + ". " + " EU " + etiqueta.getFuncionario() + ", " + etiqueta.getFuncao()
                + "(a) CONFERI E ASSINO." + etiqueta.getCidade() + " " + data;
        System.out.println(etiqueta);

        Process processo;
        //String comandos ="java -jar C:\\Users\\jose.junior\\Desktop\\Exec\\bin3.jar \""+texto+"\"" ;
        String comandos = "java -jar bin3.jar \"" + et + "\"";

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

    }}


