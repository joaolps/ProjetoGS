package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.dao.EmpresaParceiraDAO;

public class EmpresaParceiraBO {

	EmpresaParceiraDAO empresaParceiraDao;

	// Selecionar
	public ArrayList<EmpresaParceira> selecionarBo() throws ClassNotFoundException, SQLException {
		empresaParceiraDao = new EmpresaParceiraDAO();

		// Regra de negócios

		return (ArrayList<EmpresaParceira>) empresaParceiraDao.selecionar();
	}

	// Inserir
	public void inserirBo(EmpresaParceira empresaParceira) throws ClassNotFoundException, SQLException {
		empresaParceiraDao = new EmpresaParceiraDAO();

		// Regra de negócios

		empresaParceiraDao.inserir(empresaParceira);
	}

	// Atualizar
	public void atualizarBo(EmpresaParceira empresaParceira) throws ClassNotFoundException, SQLException {
		empresaParceiraDao = new EmpresaParceiraDAO();

		// Regra de negócios

		empresaParceiraDao.atualizar(empresaParceira);
	}

	// Deletar
	public void deletarBo(int idParceiro) throws ClassNotFoundException, SQLException {
		empresaParceiraDao = new EmpresaParceiraDAO();

		// Regra de negócios

		empresaParceiraDao.deletar(idParceiro);
	}
}
