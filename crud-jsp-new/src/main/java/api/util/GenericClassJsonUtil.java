package api.util;

import action.auth.Token;
import com.google.gson.Gson;
import model.Usuario;
import model.veiculo.CodigoCorDenatran;
import model.veiculo.Veiculo;

import java.lang.reflect.Type;

public class GenericClassJsonUtil {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static <T> String convertObjetoEmJson(T Object) {

        Gson gson = new Gson();
        String json = gson.toJson(Object);
        java.lang.String json1 = json;

        return json1;

    }

    public static <T>Object convertJsonEmObjeto(String json,Object minhaClasse) {

        Gson gson = new Gson();
        Object objetct = gson.fromJson(json, (Type) minhaClasse.getClass());

        return objetct;


    }

    public static void main(String[] args) {
        // Usando o método genérico com diferentes tipos de dados
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);  // Funciona com Integer
        printArray(stringArray);  // Funciona com String
        Usuario usuario = new Usuario("teste","123","1");

       System.out.println("convertendo " + convertObjetoEmJson(usuario));

        Veiculo veiculo = new Veiculo();
        veiculo.setAnoFabricacao(1997);
        veiculo.setCodigoCor(CodigoCorDenatran.AZUL.getDescricao());
        veiculo.setPesoBruto(2000.00);
        veiculo.setPesoLiquido(1000.00);
        veiculo.setCapacidadeTracao(111);


        System.out.println("convertendo " + convertObjetoEmJson(veiculo));

        String jsonInputString = "{\n" +
                "  \"chassi\":\"zetxxx@teste1\",\n" +
                "  \"password\":\"1\",\n" +
                "  \"role\":\"ADMIN\"\n" +
                "  \n" +
                "}";

        Veiculo veiculo1 =  new Veiculo();
        veiculo1 = (Veiculo) convertJsonEmObjeto(jsonInputString,veiculo1);
        System.out.println("convertendo json em objeto " +veiculo1.getChassi());
    }
}
