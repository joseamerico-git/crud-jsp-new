package api.util;

import com.google.gson.Gson;
import model.Nfe;
import model.veiculo.Veiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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



    public static Nfe converteObjetoFromJson(Nfe nfe, String path) {

        Gson gson = new Gson();
        try {

            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(path));

            //converte o json para objeto java
            nfe = gson.fromJson(bufferedReader, Nfe.class);

            System.out.println(nfe.toString());

        } catch (IOException e) {
            e.printStackTrace();

        }

        return nfe;
    }
    }