package model.api;



import java.util.Objects;




public class Categoria {

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome);
	}


	private Long codigo;


	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
