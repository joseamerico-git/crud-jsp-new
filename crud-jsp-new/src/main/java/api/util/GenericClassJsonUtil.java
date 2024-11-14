package api.util;

public class GenericClassJsonUtil {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        // Usando o método genérico com diferentes tipos de dados
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);  // Funciona com Integer
        printArray(stringArray);  // Funciona com String
    }
}
