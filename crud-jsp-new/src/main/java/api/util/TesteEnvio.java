package api.util;

import java.util.ArrayList;
import java.util.List;

import model.BaseCalculo;
import model.Cofins;
import model.Destinatario;
import model.Emitente;
import model.Endereco;
import model.Icms;
import model.Iten;
import model.Nfe;
import model.Pagamento;
import model.Pis;
import model.ResponsavelTecnico;
import model.Telefone;
import model.Tributos;
import model.ValorUnitario;
import model.certificado.Certificado;
import model.veiculo.CodigoCorDenatran;
import model.veiculo.Tipo;
import model.veiculo.TipoCombustivel;
import model.veiculo.TipoOperacao;
import model.veiculo.Veiculo;

public class TesteEnvio {

	public static void main(String[] args) {

		Certificado certificado = new Certificado();
		certificado.setId("5b855b0926ddb251e0f0ef42");
		certificado.setNome(
				"CN=TECNOSPEED S A:08187168000160, OU=Certificado PJ A1, OU=AC SOLUTI Multipla, OU=AC SOLUTI, OU=Autoridade Certificadora Raiz Brasileira v2, O=ICP-Brasil, C=BR, SE=26 41 18 05 02 40 D6 8A");
		certificado.setHash("8b86eef6ac2282c7dd4c2dc0ab09af3e");
		certificado.setVencimento("03/05/2019 00:00:00");
		certificado.setCnpj("8187168000160");
		certificado.setEmail("");

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
		item.setValorUnitario(new ValorUnitario(4.6, 4.6));
		item.setValor(4.6);

		item.setTributos(new Tributos(new Icms("0", "00", new BaseCalculo(0, 0.0), 0, 0),
				new Pis("99", new BaseCalculo(0.0, 0), 0, 0), new Cofins("07", new BaseCalculo(0.0))));
		item.setCfop("5101");

		item.setVeiculo(veiculo);
		itens.add(item);

		Pagamento pagamento = new Pagamento(true, "01", 4.6);
		List<Pagamento> pagamentos = new ArrayList<>();
		pagamentos.add(pagamento);

		// buscar cep
		model.Endereco endereco = new Endereco();
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
		nfE.setIdIntegracao("XXXYY999998817");
		nfE.setPresencial("1");
		nfE.setConsumidorFinal(true);
		nfE.setNatureza("OPERAÇÃO INTERNA");
		nfE.setEmitente(emitente);
		nfE.setDestinatario(destinatario);
		nfE.setItens(itens);
		nfE.setPagamentos(pagamentos);
		nfE.setResponsavelTecnico(new ResponsavelTecnico("08187168000160", "Tecnospeed", "contato@tecnospeed.com.br",
				new Telefone("44", "30379500")));

		System.out.println("***************");

		ArrayList<Nfe> listNfe = new ArrayList<Nfe>();
		listNfe.add(nfE);
		// listNfe.add(nfE);
		// listNfe.add(nfE);

		// Salva meu array de nfe em um arquivo formato json
		String jsonteste = UtilNfeJson.converteArrayNfeEmJson(listNfe, "meujson.json");
		// Efetua a requisição post em sandobox:
		// https://api.sandbox.plugnotas.com.br/nfe
		HttpUtil.postNfe(jsonteste);

		// Salva um unico objeto nfe em um arquivo json.
		// Nfe nfeFromjson = UtilNfeJson.converteObjetoFromJson(nfE,"nfE.json");

	}

}

// System.out.println("TipoOperação: " + veiculo.getTipoOperacao());

// for (TipoOperacao t : TipoOperacao.values()) {
// System.out.println(t.getDescricao() + " - " + t.name());

// }

// System.out.println("Veiculo: " + veiculo.toString());

// System.out.println(" *********************");

// System.out.println(" objeto para json");

// Gson gson = new Gson();

// String json = gson.toJson(nfE);
// try {

// FileWriter fileWriter = new FileWriter("nfE.json");
// fileWriter.write(json);
// fileWriter.close();

// } catch (Exception e) {
// e.printStackTrace();
// }

// System.out.println(json);
// System.out.println(" *********************");

// System.out.println(" ********* Converte o json em objeto e arquivo
// ************");
// Nfe nfeConvertida = UtilNfeJson.converteObjetoFromJson(nfE, "nfE.json");

// String jsonInputString = gson.toJson(nfE);

// HttpUtil.postNfe("[ " + jsonInputString + "]");
