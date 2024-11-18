package model.api;

import java.util.Objects;



public class Image {

	private Long id;
	private String nome;
	

	private String urlImage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, urlImage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(urlImage, other.urlImage);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	

}
