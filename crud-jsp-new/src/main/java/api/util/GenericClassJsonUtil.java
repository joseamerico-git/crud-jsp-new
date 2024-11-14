package api.util;

import com.google.gson.Gson;
import model.Usuario;
import model.veiculo.CodigoCorDenatran;
import model.veiculo.Veiculo;

public class GenericClassJsonUtil {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static <T> String convertJson(T Object) {

        Gson gson = new Gson();
        String json = gson.toJson(Object);
        java.lang.String json1 = json;

        return json1;

    }

    public static <T> String convertClassEmJson(T Objetct) {

        Gson gson = new Gson();
        String json = gson.toJson(Objetct);
        java.lang.String json1 = json;
        System.out.print(json1);
        return json1;

    }

    public static void main(String[] args) {
        // Usando o método genérico com diferentes tipos de dados
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);  // Funciona com Integer
        printArray(stringArray);  // Funciona com String
        Usuario usuario = new Usuario("teste","123","1");

       System.out.println("convertendo " + convertJson(usuario));

        Veiculo veiculo = new Veiculo();
        veiculo.setAnoFabricacao(1997);
        veiculo.setCodigoCor(CodigoCorDenatran.AZUL.getDescricao());
        veiculo.setPesoBruto(2000.00);
        veiculo.setPesoLiquido(1000.00);
        veiculo.setCapacidadeTracao(111);
       

        System.out.println("convertendo " + convertJson(veiculo));


    }
}
