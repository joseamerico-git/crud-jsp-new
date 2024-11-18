package model.veiculo;

public class ValorUnitario {
	public double comercial;
	public double tributavel;

	public ValorUnitario(double comercial, double tributavel) {

		this.comercial = comercial;
		this.tributavel = tributavel;
	}

	public double getComercial() {
		return comercial;
	}

	public void setComercial(double comercial) {
		this.comercial = comercial;
	}

	public double getTributavel() {
		return tributavel;
	}

	public void setTributavel(double tributavel) {
		this.tributavel = tributavel;
	}

}
