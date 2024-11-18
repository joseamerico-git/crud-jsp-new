package model.veiculo;

public class Pis {
	public String cst;
	public BaseCalculo baseCalculo;
	public int aliquota;
	public int valor;

	public Pis(String cst, BaseCalculo baseCalculo, int aliquota, int valor) {
		this.cst = cst;
		this.baseCalculo = baseCalculo;
		this.aliquota = aliquota;
		this.valor = valor;
	}

	public Pis(String cst) {
		this.cst = cst;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	public BaseCalculo getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(BaseCalculo baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public int getAliquota() {
		return aliquota;
	}

	public void setAliquota(int aliquota) {
		this.aliquota = aliquota;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
