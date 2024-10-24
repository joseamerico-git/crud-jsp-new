package model;

public class Pagamento {
	public boolean aVista;
	public String meio;
	public double valor;

	public Pagamento(boolean aVista, String meio, double valor) {
		this.aVista = aVista;
		this.meio = meio;
		this.valor = valor;
	}

	public boolean isaVista() {
		return aVista;
	}

	public void setaVista(boolean aVista) {
		this.aVista = aVista;
	}

	public String getMeio() {
		return meio;
	}

	public void setMeio(String meio) {
		this.meio = meio;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
