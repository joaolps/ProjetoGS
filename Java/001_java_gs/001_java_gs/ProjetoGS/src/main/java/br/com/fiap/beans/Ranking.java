package br.com.fiap.beans;

import java.time.LocalDateTime;

public class Ranking {
	private int idUsuario; // Apenas idUsuario como chave primária
	private int pontos;
	private LocalDateTime ultimaAtualizacao;

	public Ranking() {
		super();
	}

	public Ranking(int idUsuario, int pontos, LocalDateTime ultimaAtualizacao) {
		super();
		this.idUsuario = idUsuario;
		this.pontos = pontos;
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public LocalDateTime getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	@Override
	public String toString() {
		return "{idUsuario=" + idUsuario + ",\n  pontos=" + pontos + ",\n  ultimaAtualizacao=" + ultimaAtualizacao
				+ "}";
	}
}
