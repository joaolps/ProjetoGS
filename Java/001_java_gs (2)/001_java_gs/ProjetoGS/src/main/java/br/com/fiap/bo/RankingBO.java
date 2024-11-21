package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Ranking;
import br.com.fiap.dao.RankingDAO;

public class RankingBO {

	RankingDAO rankingDao;

	// Selecionar
	public ArrayList<Ranking> selecionarBo() throws ClassNotFoundException, SQLException {
		rankingDao = new RankingDAO();

		// Regra de negócios

		return (ArrayList<Ranking>) rankingDao.selecionar();
	}

	// Inserir
	public void inserirBo(Ranking ranking) throws ClassNotFoundException, SQLException {
		rankingDao = new RankingDAO();

		// Regra de negócios

		rankingDao.inserir(ranking);
	}

	// Atualizar
	public void atualizarBo(Ranking ranking) throws ClassNotFoundException, SQLException {
		rankingDao = new RankingDAO();

		// Regra de negócios

		rankingDao.atualizar(ranking);
	}

	// Deletar
	public void deletarBo(int idUsuario) throws ClassNotFoundException, SQLException {
		rankingDao = new RankingDAO();

		// Regra de negócios

		rankingDao.deletar(idUsuario);
	}
}
