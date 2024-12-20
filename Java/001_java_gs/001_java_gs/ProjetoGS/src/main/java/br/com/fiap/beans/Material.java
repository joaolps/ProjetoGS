package br.com.fiap.beans;

import java.time.LocalDateTime;

public class Material {
	private int idMaterial;
	private String nome;
	private String descricao;
	private LocalDateTime dataCadastro;

	public Material() {
		super();
	}

	public Material(int idMaterial, String nome, String descricao, LocalDateTime dataCadastro) {
		super();
		this.idMaterial = idMaterial;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
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

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "{idMaterial=" + idMaterial + ",\n  nome='" + nome + '\'' + ",\n  descricao='" + descricao + '\''
				+ ",\n  dataCadastro=" + dataCadastro + "}";
	}

}
