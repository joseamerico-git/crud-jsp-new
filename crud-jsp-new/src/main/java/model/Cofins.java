package model;

public class Cofins {
	private String cst;
	private BaseCalculo baseCalculo;
	private int aliquota;
	private int valor;

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
