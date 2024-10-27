package model;

import java.util.Objects;

public class Usuario {

	private Integer id;

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				'}';
	}

	public Usuario() {
	}

	public Usuario(String login, String password, String role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String login;
	private String password;
	private String role;

}


