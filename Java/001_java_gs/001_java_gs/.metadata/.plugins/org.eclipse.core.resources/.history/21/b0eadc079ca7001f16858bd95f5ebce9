package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Ranking;
import br.com.fiap.conexoes.ConexaoFactory;

public class RankingDAO {

	public Connection minhaConexao;

	public RankingDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(Ranking ranking) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("INSERT INTO tbl_ranking (id_usuario, pontos, ultima_atualizacao) VALUES (?, ?, ?)");
		stmt.setInt(1, ranking.getIdUsuario());
		stmt.setInt(2, ranking.getPontos());
		stmt.setObject(3, ranking.getUltimaAtualizacao());
		stmt.execute();
		stmt.close();
		return "Ranking cadastrado com sucesso!";
	}

	// Delete
	public String deletar(int idUsuario) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM tbl_ranking WHERE id_usuario = ?");
		stmt.setInt(1, idUsuario);
		stmt.execute();
		stmt.close();
		return "Ranking deletado com sucesso!";
	}

	// Update
	public String atualizar(Ranking ranking) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("UPDATE tbl_ranking SET pontos = ?, ultima_atualizacao = ? WHERE id_usuario = ?");
		stmt.setInt(1, ranking.getPontos());
		stmt.setObject(2, ranking.getUltimaAtualizacao());
		stmt.setInt(3, ranking.getIdUsuario());
		stmt.executeUpdate();
		stmt.close();
		return "Ranking atualizado com sucesso!";
	}

	// Select
	public List<Ranking> selecionar() throws SQLException {
		List<Ranking> listaRanking = new ArrayList<Ranking>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tbl_ranking");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Ranking ranking = new Ranking();
			ranking.setIdUsuario(rs.getInt("id_usuario"));
			ranking.setPontos(rs.getInt("pontos"));
			ranking.setUltimaAtualizacao(rs.getObject("ultima_atualizacao", LocalDateTime.class));
			listaRanking.add(ranking);
		}
		stmt.close();
		rs.close();
		return listaRanking;
	}
}
