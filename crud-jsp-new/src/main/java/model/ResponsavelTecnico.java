package model;

public class ResponsavelTecnico {
	public String cpfCnpj;
	public String nome;
	public String email;
	public Telefone telefone;

	public ResponsavelTecnico(String cpfCnpj, String nome, String email, Telefone telefone) {
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
}
