package model.veiculo;

import java.io.Serializable;
import java.util.List;

public class Nfe implements Serializable {

	private static final long serialVersionUID = 1L;
	public String idIntegracao;
	public String presencial;
	public boolean consumidorFinal;
	public Destinatario destinatario;
	public List<Iten> itens;
	public List<Pagamento> pagamentos;
	public ResponsavelTecnico responsavelTecnico;
	public String natureza;
	public Emitente emitente;

	public List<Iten> getItens() {
		return itens;
	}

	public String getIdIntegracao() {
		return idIntegracao;
	}

	public void setIdIntegracao(String idIntegracao) {
		this.idIntegracao = idIntegracao;
	}

	public String getPresencial() {
		return presencial;
	}

	public void setPresencial(String presencial) {
		this.presencial = presencial;
	}

	public boolean isConsumidorFinal() {
		return consumidorFinal;
	}

	public void setConsumidorFinal(boolean consumidorFinal) {
		this.consumidorFinal = consumidorFinal;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public Emitente getEmitente() {
		return emitente;
	}

	public void setEmitente(Emitente emitente) {
		this.emitente = emitente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public void setItens(List<Iten> itens) {
		this.itens = itens;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public ResponsavelTecnico getResponsavelTecnico() {
		return responsavelTecnico;
	}

	public void setResponsavelTecnico(ResponsavelTecnico responsavelTecnico) {
		this.responsavelTecnico = responsavelTecnico;
	}

	@Override
	public String toString() {
		return "Nfe{" + "idIntegracao='" + idIntegracao + '\'' + ", presencial='" + presencial + '\''
				+ ", consumidorFinal=" + consumidorFinal + ", natureza='" + natureza + '\'' + ", emitente=" + emitente
				+ ", destinatario=" + destinatario + ", itens=" + itens + ", pagamentos=" + pagamentos
				+ ", responsavelTecnico=" + responsavelTecnico + '}';
	}

}
