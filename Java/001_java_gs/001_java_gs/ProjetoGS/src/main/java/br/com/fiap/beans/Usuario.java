package br.com.fiap.beans;

public class Usuario {
	private int id_usuario;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	public Usuario() {
		super();
	}

	public Usuario(int id_usuario, String nome, String cpf, String email, String telefone) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "{id_usuario=" + id_usuario + ",\n  nome='" + nome + '\'' + ",\n  cpf='" + cpf + '\'' + ",\n  email='"
				+ email + '\'' + ",\n  telefone='" + telefone + '\'' + "}";
	}
}