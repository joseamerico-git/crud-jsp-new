package model;



import api.util.ConvertFromJson;
import com.google.gson.Gson;
import model.certificado.Certificado;
import model.veiculo.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



public class Teste {

	public static void main(String[] args) {
		
		//certificado Authorizations:
		//x-api-key = "token"
		//endpoint  GET sandbox:  https://api.sandbox.plugnotas.com.br/certificado ou produção: https://api.plugnotas.com.br/certificado
		
		
        Certificado certificado = new Certificado();
        certificado.setId("5b855b0926ddb251e0f0ef42");
        certificado.setNome("CN=TECNOSPEED S A:08187168000160, OU=Certificado PJ A1, OU=AC SOLUTI Multipla, OU=AC SOLUTI, OU=Autoridade Certificadora Raiz Brasileira v2, O=ICP-Brasil, C=BR, SE=26 41 18 05 02 40 D6 8A");
        certificado.setHash("8b86eef6ac2282c7dd4c2dc0ab09af3e");
        certificado.setVencimento("03/05/2019 00:00:00");
        certificado.setCnpj("8187168000160");
        certificado.setEmail("");
        
        // POST certificado: sandbox https://api.sandbox.plugnotas.com.br/certificado produção: https://api.plugnotas.com.br/certificado
         
        //Nfe 
        //endpoint POST sandobox: https://api.sandbox.plugnotas.com.br/nfe ou produção: https://api.plugnotas.com.br/nfe

		//Veiculos:

		Veiculo veiculo = new Veiculo();
		veiculo.setTipoOperacao(Integer.valueOf(TipoOperacao.VENDA_CONCECIONARIA.getDescricao()));
		veiculo.setChassi("9B345678912345678");
		veiculo.setCodigoCor(CodigoCorDenatran.BRANCA.getDescricao());
		veiculo.setDescricaoCor(CodigoCorDenatran.BRANCA.name());
		veiculo.setPotenciaMotor(60);
		veiculo.setCilindradas(1000);
		veiculo.setPesoLiquido(600);
		veiculo.setPesoBruto(700);
		veiculo.setNumeroSerie("123456");

		veiculo.setTipoCombustivel(Integer.valueOf(TipoCombustivel.ALCOOL.getDescricao()));
		veiculo.setNumeroMotor("UD12345");
		veiculo.setCapacidadeTracao(200.1111);
		veiculo.setDistanciaEixos("1,5  metros");
		veiculo.setAnoFabricacao(2004);
		veiculo.setAnoModelo(2004);
		veiculo.setTipoPintura(CodigoCorDenatran.BRANCA.name());
		veiculo.setTipo(Integer.valueOf(Tipo.AUTOMÓVEL.getDescricao()));


		// Lista de notas
		List<Iten> itens = new ArrayList<Iten>();
		Iten item = new Iten();
		item.setCodigo("1");
		item.setDescricao("NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
		item.setNcm("06029090");
		item.setCest("0123456");
		item.setCfop("5101");
		item.setVeiculo(veiculo);
		item.setValorUnitario(new ValorUnitario(4.6, 4.6));

		itens.add(item);

		// buscar cep
		Endereco endereco = new Endereco();
		endereco.setTipoLogradouro("Avenida");
		endereco.setLogradouro("AVENIDA DUQUE DE CAXIAS");
		endereco.setNumero("882");
		endereco.setBairro("CENTRO");
		endereco.setCodigoCidade("4115200");
		endereco.setDescricaoCidade("MARINGA");
		endereco.setEstado("PR");
		endereco.setCep("87020025");

		// Get destinatário
		Destinatario destinatario = new Destinatario();

		destinatario.setCpfCnpj("08114280956");
		destinatario.setRazaoSocial("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
		destinatario.setEmail("contato@tecnospeed.com.br");
		destinatario.setEndereco(endereco);

		// GET emitente
		Emitente emitente = new Emitente();
		emitente.setCpfCnpj("08187168000160");

		// Bean da nota
		Nfe nfE = new Nfe();
		nfE.setIdIntegracao("XXXYY99999");
		nfE.setPresencial("1");
		nfE.setConsumidorFinal(true);
		nfE.setNatureza("OPERAÇÃO INTERNA");
		nfE.setEmitente(emitente);
		nfE.setDestinatario(destinatario);

		nfE.setItens(itens);
		System.out.println(nfE.toString());
		
		//DELETE nfe sandbox: https://api.sandbox.plugnotas.com.br/nfse/servico/{idServico} ou produção:https://api.plugnotas.com.br/nfse/servico/{idServico}

		
		


		System.out.println("TipoOperação: "+veiculo.getTipoOperacao());
		
		for(TipoOperacao t:  TipoOperacao.values()) {
			System.out.println(t.getDescricao() + " - " + t.name());
			
		}

		System.out.println("Veiculo: "+veiculo.toString());


		System.out.println(" *********************");

		System.out.println(" objeto para json");

		Gson gson = new Gson();

		String json = gson.toJson(nfE);
		try {

			FileWriter fileWriter = new FileWriter("nfE.json");
			fileWriter.write(json);
			fileWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(json);
		System.out.println(" *********************");

		
	}



		
		
		/*
		 * try {
		 * 
		 * BufferedReader br = new BufferedReader(new FileReader("c:\\file.json"));
		 * 
		 * //Converte String JSON para objeto Java Informacoes obj = gson.fromJson(br,
		 * Informacoes.class);
		 * 
		 * System.out.println(obj);
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * 
		 * }
		 */

}