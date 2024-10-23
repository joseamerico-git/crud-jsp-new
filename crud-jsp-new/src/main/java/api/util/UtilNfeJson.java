package api.util;

import com.google.gson.Gson;
import model.Nfe;
import model.veiculo.Veiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilNfeJson {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        veiculo.setNumeroMotor("1234");

        //ConvertFromJson.converteObjetoFromJson(veiculo,"nfE.json");


    }


    public static String convertJsonFromObject(Nfe nfe,String path){


            Gson gson = new Gson();

            // Convertendo um objeto Java para JSON e retorna uma String JSON
            // formatada
            String json = gson.toJson(nfe);

            try {

                FileWriter fileWriter = new FileWriter("nfE.json");
                fileWriter.write(json);
                fileWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println(json);
            return json;

        }




    public static String converteArrayNfeEmJson(ArrayList<Nfe> listNfe, String nameFile) {
        Gson gson = new Gson();
        String jsonteste = new Gson().toJson(listNfe);
        System.out.println("meu json teste === > "+jsonteste);

        salvarArquivo(nameFile,jsonteste);
        return jsonteste;
    }

    public  static void salvarArquivo(String path, String jsonInput){
        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter(path);
            writer.write(jsonInput);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Nfe converteObjetoFromJson(Nfe nfe, String path) {

        Gson gson = new Gson();
        try {

            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(path));

            //converte o json para objeto java
            nfe = gson.fromJson(bufferedReader, Nfe.class);

          //  System.out.println(nfe.toString());

        } catch (IOException e) {
            e.printStackTrace();

        }

        return nfe;
    }
    }