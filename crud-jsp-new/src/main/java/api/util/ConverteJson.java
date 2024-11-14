package api.util;

import model.Usuario;

import java.lang.reflect.Method;

public class ConverteJson {
    public static <T> T converter(Object objeto, Class<T> classeDestino) {
        try {
            T instancia = classeDestino.getDeclaredConstructor().newInstance();
            Method[] metodos = classeDestino.getMethods();

            for (Method metodo : metodos) {
                if (metodo.getName().startsWith("set")) {
                    String nomeAtributo = metodo.getName().substring(3);
                    Method metodoGet = objeto.getClass().getMethod("get" + nomeAtributo);
                    Object valor = metodoGet.invoke(objeto);
                    metodo.invoke(instancia, valor);
                }
            }


            return instancia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public static void main(String[] args) {
            // Exemplo de uso
            Usuario origem = new Usuario();
            origem.setLogin("Exemplo");
            origem.setRole("1");

            Usuario destino = converter(origem, Usuario.class);
            System.out.println(destino.getLogin());
            System.out.println(destino.getRole());
        }
    }

