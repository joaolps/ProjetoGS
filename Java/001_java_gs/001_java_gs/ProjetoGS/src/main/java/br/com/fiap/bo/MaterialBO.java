package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Material;
import br.com.fiap.dao.MaterialDAO;

public class MaterialBO {

	MaterialDAO materialDao;

	// Selecionar
	public ArrayList<Material> selecionarBo() throws ClassNotFoundException, SQLException {
		materialDao = new MaterialDAO();

		// Regra de negócios

		return (ArrayList<Material>) materialDao.selecionar();
	}

	// Inserir
	public void inserirBo(Material material) throws ClassNotFoundException, SQLException {
		materialDao = new MaterialDAO();

		// Regra de negócios

		materialDao.inserir(material);
	}

	// Atualizar
	public void atualizarBo(Material material) throws ClassNotFoundException, SQLException {
		materialDao = new MaterialDAO();

		// Regra de negócios

		materialDao.atualizar(material);
	}

	// Deletar
	public void deletarBo(int idMaterial) throws ClassNotFoundException, SQLException {
		materialDao = new MaterialDAO();

		// Regra de negócios

		materialDao.deletar(idMaterial);
	}
}
