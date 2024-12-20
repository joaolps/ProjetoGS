package br.com.fiap.beans;

import java.time.LocalDateTime;

public class EmpresaParceira {
	private int idParceiro;
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private String endereco;
	private LocalDateTime dataCadastro;

	public EmpresaParceira() {
		super();
	}

	public EmpresaParceira(int idParceiro, String nome, String email, String telefone, String cnpj, String endereco,
			LocalDateTime dataCadastro) {
		super();
		this.idParceiro = idParceiro;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.dataCadastro = dataCadastro;
	}

	public int getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "{idParceiro=" + idParceiro + ",\n  nome='" + nome + '\'' + ",\n  email='" + email + '\''
				+ ",\n  telefone='" + telefone + '\'' + ",\n  cnpj='" + cnpj + '\'' + ",\n  endereco='" + endereco
				+ '\'' + ",\n  dataCadastro=" + dataCadastro + "}";
	}
}
