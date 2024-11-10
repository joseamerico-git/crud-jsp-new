package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/upload")
public class Upload extends HttpServlet {
    public Upload(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("Rota do get");
        String path = req.getServletContext().getRealPath("imagens")+ File.separator;
        File files = new File(path);
        resp.setContentType("image/jpeg");

        for(String file : files.list()){
            File f = new File(path + file);
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = resp.getOutputStream();
            ImageIO.write(bi,"jpg",out);

            out.close();

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("Rota do post");
        if(ServletFileUpload.isMultipartContent(req)){
            try{

                List<FileItem> multiparts = new ServletFileUpload((new DiskFileItemFactory())).parseRequest(req);

                for(FileItem item: multiparts){
                    if(!item.isFormField()){
                        item.write(new File(req.getServletContext().getRealPath("imagens")+File.separator+"uploadfile"));
                    }
                }
                req.setAttribute("mensagem","Arquivo carregado com sucesso!");

            }catch (Exception ex){
                req.setAttribute("message","Upload do arquivo falhou!");
            }
        }
        req.getRequestDispatcher("/upload.jsp").forward(req,resp);
    }
}
