package api.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConvertFromJson {
    public static void main(String[] args) {

        Gson gson = new Gson();

        try {

            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("/home/geekzone/product.json"));

            //converte o json para objeto java
            Product product = gson.fromJson(bufferedReader, Product.class);

            System.out.println(product);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void converteObjetoFromJson(Object object, String path){
        try {

            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("/home/geekzone/product.json"));

            //converte o json para objeto java
            object = gson.fromJson(bufferedReader, Object.class);

            System.out.println(object);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}