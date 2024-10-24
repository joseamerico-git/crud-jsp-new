package model;

public class ResponsavelTecnico {
	public String cpfCnpj;
	public String nome;
	public String email;
	public Telefone telefone;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public ResponsavelTecnico(String cpfCnpj, String nome, String email, Telefone telefone) {
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
}
