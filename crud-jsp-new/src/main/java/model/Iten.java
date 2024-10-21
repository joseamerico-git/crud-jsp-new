package model;

import model.veiculo.Veiculo;

public class Iten {
	private String codigo;
	private String descricao;
	private String ncm;
	private String cest;
	private String cfop;
	private ValorUnitario valorUnitario;
	private double valor;
	private Tributos tributos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getCest() {
		return cest;
	}

	public void setCest(String cest) {
		this.cest = cest;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public ValorUnitario getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(ValorUnitario valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Tributos getTributos() {
		return tributos;
	}

	public void setTributos(Tributos tributos) {
		this.tributos = tributos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	private Veiculo veiculo;



}
