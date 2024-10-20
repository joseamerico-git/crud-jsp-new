package model;

public class TesteMain {

	public static void main(String[] args) {
		StringBuilder json = new StringBuilder("{\r\n" + "    \"idIntegracao\": \"XXXYY99999\",\r\n"
				+ "    \"presencial\": \"1\",\r\n" + "    \"consumidorFinal\": true,\r\n"
				+ "    \"natureza\": \"OPERAÇÃO INTERNA\",\r\n" + "    \"emitente\": {\r\n"
				+ "        \"cpfCnpj\": \"08187168000160\"\r\n" + "    },\r\n" + "    \"destinatario\": {\r\n"
				+ "        \"cpfCnpj\": \"08114280956\",\r\n"
				+ "        \"razaoSocial\": \"NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL\",\r\n"
				+ "        \"email\": \"contato@tecnospeed.com.br\",\r\n" + "        \"endereco\": {\r\n"
				+ "            \"tipoLogradouro\": \"Avenida\",\r\n"
				+ "            \"logradouro\": \"AVENIDA DUQUE DE CAXIAS\",\r\n"
				+ "            \"numero\": \"882\",\r\n" + "            \"bairro\": \"CENTRO\",\r\n"
				+ "            \"codigoCidade\": \"4115200\",\r\n" + "            \"descricaoCidade\": \"MARINGA\",\r\n"
				+ "            \"estado\": \"PR\",\r\n" + "            \"cep\": \"87020025\"\r\n" + "        }\r\n"
				+ "    },\r\n" + "    \"itens\": [\r\n" + "        {\r\n" + "            \"codigo\": \"1\",\r\n"
				+ "            \"descricao\": \"NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL\",\r\n"
				+ "            \"ncm\": \"06029090\",\r\n" + "            \"cest\": \"0123456\",\r\n"
				+ "            \"cfop\": \"5101\",\r\n" + "            \"valorUnitario\": {\r\n"
				+ "                \"comercial\": 4.6,\r\n" + "                \"tributavel\": 4.6\r\n" + "\r\n"
				+ "            },\r\n" + "            \"valor\": 4.6,\r\n" + "            \"tributos\": {\r\n"
				+ "                \"icms\": {\r\n" + "                    \"origem\": \"0\",\r\n"
				+ "                    \"cst\": \"00\",\r\n" + "                    \"baseCalculo\": {\r\n"
				+ "                        \"modalidadeDeterminacao\": 0,\r\n"
				+ "                        \"valor\": 0\r\n" + "                    },\r\n"
				+ "                    \"aliquota\": 0,\r\n" + "                    \"valor\": 0\r\n"
				+ "                },\r\n" + "                \"pis\": {\r\n"
				+ "                    \"cst\": \"99\",\r\n" + "                    \"baseCalculo\": {\r\n"
				+ "                        \"valor\": 0,\r\n" + "                        \"quantidade\": 0\r\n"
				+ "                    },\r\n" + "                    \"aliquota\": 0,\r\n"
				+ "                    \"valor\": 0\r\n" + "                },\r\n"
				+ "                \"cofins\": {\r\n" + "                    \"cst\": \"07\",\r\n"
				+ "                    \"baseCalculo\": { \"valor\": 0 },\r\n"
				+ "                    \"aliquota\": 0,\r\n" + "                    \"valor\": 0\r\n"
				+ "                }\r\n" + "\r\n" + "            }\r\n" + "        }\r\n" + "    ],\r\n"
				+ "    \"pagamentos\": [\r\n" + "        {\r\n" + "            \"aVista\": true,\r\n"
				+ "            \"meio\": \"01\",\r\n" + "            \"valor\": 4.6\r\n" + "        }\r\n"
				+ "    ],\r\n" + "    \"responsavelTecnico\": {\r\n" + "        \"cpfCnpj\": \"08187168000160\",\r\n"
				+ "        \"nome\": \"Tecnospeed\",\r\n" + "        \"email\": \"contato@tecnospeed.com.br\",\r\n"
				+ "        \"telefone\": {\r\n" + "            \"ddd\": \"44\",\r\n"
				+ "            \"numero\": \"30379500\"\r\n" + "        }\r\n" + "    }\r\n" + "}");


		System.out.println(json);
	}


}
