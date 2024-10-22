package model;

public class Icms {
	public String origem;
	public String cst;
	public BaseCalculo baseCalculo;
	public int aliquota;
	public double valor;

	public Icms(String origem, String cst, BaseCalculo baseCalculo, int aliquota, double valor) {
		this.origem = origem;
		this.cst = cst;
		this.baseCalculo = baseCalculo;
		this.aliquota = aliquota;
		this.valor = valor;
	}



	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
