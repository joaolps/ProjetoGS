package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.dao.EnvioMaterialDAO;

public class EnvioMaterialBO {

	EnvioMaterialDAO envioMaterialDao;

	// Selecionar
	public ArrayList<EnvioMaterial> selecionarBo() throws ClassNotFoundException, SQLException {
		envioMaterialDao = new EnvioMaterialDAO();

		// Regra de negócios

		return (ArrayList<EnvioMaterial>) envioMaterialDao.selecionar();
	}

	// Inserir
	public void inserirBo(EnvioMaterial envioMaterial) throws ClassNotFoundException, SQLException {
		envioMaterialDao = new EnvioMaterialDAO();

		// Regra de negócios

		envioMaterialDao.inserir(envioMaterial);
	}

	// Atualizar
	public void atualizarBo(EnvioMaterial envioMaterial) throws ClassNotFoundException, SQLException {
		envioMaterialDao = new EnvioMaterialDAO();

		// Regra de negócios

		envioMaterialDao.atualizar(envioMaterial);
	}

	// Deletar
	public void deletarBo(int idEnvio) throws ClassNotFoundException, SQLException {
		envioMaterialDao = new EnvioMaterialDAO();

		// Regra de negócios

		envioMaterialDao.deletar(idEnvio);
	}
}
