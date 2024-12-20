package br.com.fiap.beans;

import java.time.LocalDateTime;

public class EnvioMaterial {
	private int idEnvio;
	private int idUsuario;
	private int idMaterial;
	private int idParceiro;
	private int quantidade;
	private LocalDateTime dataEnvio;

	public EnvioMaterial() {
		super();
	}

	public EnvioMaterial(int idEnvio, int idUsuario, int idMaterial, int idParceiro, int quantidade,
			LocalDateTime dataEnvio) {
		super();
		this.idEnvio = idEnvio;
		this.idUsuario = idUsuario;
		this.idMaterial = idMaterial;
		this.idParceiro = idParceiro;
		this.quantidade = quantidade;
		this.dataEnvio = dataEnvio;
	}

	public int getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public int getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	@Override
	public String toString() {
		return "{idEnvio=" + idEnvio + ",\n  idUsuario=" + idUsuario + ",\n  idMaterial=" + idMaterial
				+ ",\n  idParceiro=" + idParceiro + ",\n  quantidade=" + quantidade + ",\n  dataEnvio=" + dataEnvio
				+ "}";
	}
}
