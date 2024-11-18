package model.veiculo;

public class Cofins {
	private String cst;
	private BaseCalculo baseCalculo;
	private int aliquota;
	private int valor;

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

	public Cofins(String cst, BaseCalculo baseCalculo, int aliquota, int valor) {
		this.cst = cst;
		this.baseCalculo = baseCalculo;
		this.aliquota = aliquota;
		this.valor = valor;
	}

	public Cofins(String cst, BaseCalculo baseCalculo) {
		this.cst = cst;
		this.baseCalculo = baseCalculo;
	}
}
