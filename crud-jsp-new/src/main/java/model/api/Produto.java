package model.api;


import java.util.Objects;




public class Produto {

	private Long codigo;


	private String nome;
	private String descricao;

	private Categoria categoria;

	@Override
	public int hashCode() {
		return Objects.hash(categoria, codigo, descricao, estoque, nome, preco, urlImage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(estoque, other.estoque)
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco)
				&& Objects.equals(urlImage, other.urlImage);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	private double preco;
	private Integer estoque;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	private String urlImage;

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}


}
