package api.util;
import java.net.*;
import java.io.*;

import java.net.URL;

public class HttpUtil {

    public static final String URL_CERTIFICADO_SANDBOX = "https://api.sandbox.plugnotas.com.br/certificado";
    public static final String URL_ENVIO_NFE = "https://api.sandbox.plugnotas.com.br/nfe";

    public static final String CERTIFICADO = "https://api.sandbox.plugnotas.com.br/certificado";
    public static final String token = "2da392a6-79d2-4304-a8b7-959572c7e44d";



    HttpUtil(){
    }

    public static void main(String[] args) {

        System.out.println("Iniciando a requisição....");
        postNfe();

    }

    public void getNfe(){


    }

    public static void postNfe(){

        try {
            URL url = new URL(URL_ENVIO_NFE);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            			con.setRequestMethod("POST");
            			con.setRequestProperty("Content-Type", "application/json");
            			con.setConnectTimeout(10000);
            			con.setReadTimeout(20000);

             //Send RequestBody Option
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty(  "x-api-key" ,token);

            //pegar o arquivo json em uma variável string





            String jsonInputString = "[{\n" +
                    "    \"idIntegracao\": \"XXXYY9999912342\",\n" +
                    "    \"presencial\": \"1\",\n" +
                    "    \"consumidorFinal\": true,\n" +
                    "    \"natureza\": \"OPERAÇÃO INTERNA\",\n" +
                    "    \"emitente\": {\n" +
                    "        \"cpfCnpj\": \"08187168000160\"\n" +
                    "    },\n" +
                    "    \"destinatario\": {\n" +
                    "        \"cpfCnpj\": \"08114280956\",\n" +
                    "        \"razaoSocial\": \"NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL\",\n" +
                    "        \"email\": \"contato@tecnospeed.com.br\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"tipoLogradouro\": \"Avenida\",\n" +
                    "            \"logradouro\": \"AVENIDA DUQUE DE CAXIAS\",\n" +
                    "            \"numero\": \"882\",\n" +
                    "            \"bairro\": \"CENTRO\",\n" +
                    "            \"codigoCidade\": \"4115200\",\n" +
                    "            \"descricaoCidade\": \"MARINGA\",\n" +
                    "            \"estado\": \"PR\",\n" +
                    "            \"cep\": \"87020025\"\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"itens\": [\n" +
                    "        {\n" +
                    "            \"codigo\": \"1\",\n" +
                    "            \"descricao\": \"NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL\",\n" +
                    "            \"ncm\": \"06029090\",\n" +
                    "            \"cest\": \"0123456\",\n" +
                    "            \"cfop\": \"5101\",\n" +
                    "            \"valorUnitario\": {\n" +
                    "                \"comercial\": 4.6,\n" +
                    "                \"tributavel\": 4.6\n" +
                    "            },\n" +
                    "            \"valor\": 4.6,\n" +
                    "            \"tributos\": {\n" +
                    "                \"icms\": {\n" +
                    "                    \"origem\": \"0\",\n" +
                    "                    \"cst\": \"00\",\n" +
                    "                    \"baseCalculo\": {\n" +
                    "                        \"modalidadeDeterminacao\": 0,\n" +
                    "                        \"valor\": 0\n" +
                    "                    },\n" +
                    "                    \"aliquota\": 0,\n" +
                    "                    \"valor\": 0\n" +
                    "                },\n" +
                    "                \"pis\": {\n" +
                    "                    \"cst\": \"99\",\n" +
                    "                    \"baseCalculo\": {\n" +
                    "                        \"valor\": 0,\n" +
                    "                        \"quantidade\": 0\n" +
                    "                    },\n" +
                    "                    \"aliquota\": 0,\n" +
                    "                    \"valor\": 0\n" +
                    "                },\n" +
                    "                \"cofins\": {\n" +
                    "                    \"cst\": \"07\",\n" +
                    "                    \"baseCalculo\": {\n" +
                    "                        \"valor\": 0\n" +
                    "                    },\n" +
                    "                    \"aliquota\": 0,\n" +
                    "                    \"valor\": 0\n" +
                    "                }\n" +
                    "            },\n" +
                    "            \"veiculo\": {\n" +
                    "                \"tipoOperacao\": 1,\n" +
                    "                \"chassi\": \"9B345678912345678\",\n" +
                    "                \"codigoCor\": \"04\",\n" +
                    "                \"descricaoCor\": \"BRANCA\",\n" +
                    "                \"potenciaMotor\": 60,\n" +
                    "                \"cilindradas\": 1000,\n" +
                    "                \"pesoLiquido\": 600,\n" +
                    "                \"pesoBruto\": 700,\n" +
                    "                \"numeroSerie\": \"123456\",\n" +
                    "                \"tipoCombustivel\": 1,\n" +
                    "                \"numeroMotor\": \"UD12345\",\n" +
                    "                \"capacidadeTracao\": 200.1111,\n" +
                    "                \"distanciaEixos\": \"1,5  metros\",\n" +
                    "                \"anoModelo\": 2004,\n" +
                    "                \"anoFabricacao\": 2004,\n" +
                    "                \"tipoPintura\": \"BRANCA\",\n" +
                    "                \"tipo\": 6\n" +
                    "            }\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"pagamentos\": [\n" +
                    "        {\n" +
                    "            \"aVista\": true,\n" +
                    "            \"meio\": \"01\",\n" +
                    "            \"valor\": 4.6\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"responsavelTecnico\": {\n" +
                    "        \"cpfCnpj\": \"08187168000160\",\n" +
                    "        \"nome\": \"Tecnospeed\",\n" +
                    "        \"email\": \"contato@tecnospeed.com.br\",\n" +
                    "        \"telefone\": {\n" +
                    "            \"ddd\": \"44\",\n" +
                    "            \"numero\": \"30379500\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}]";
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read the Response From Input Stream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();

        } catch (MalformedURLException e) {
            System.out.println("The specified URL is malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
        }
    }
    }



