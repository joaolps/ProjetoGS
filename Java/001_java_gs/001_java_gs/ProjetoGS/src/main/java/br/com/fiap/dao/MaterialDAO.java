package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Material;
import br.com.fiap.conexoes.ConexaoFactory;

public class MaterialDAO {

	public Connection minhaConexao;

	public MaterialDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(Material material) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("INSERT INTO tbl_material (nome, descricao, data_cadastro) VALUES (?, ?, ?)");
		stmt.setString(1, material.getNome());
		stmt.setString(2, material.getDescricao());
		stmt.setObject(3, material.getDataCadastro());
		stmt.execute();
		stmt.close();
		return "Material cadastrado com sucesso!";
	}

	// Delete
	public String deletar(int idMaterial) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM tbl_material WHERE id_material = ?");
		stmt.setInt(1, idMaterial);
		stmt.execute();
		stmt.close();
		return "Material deletado com sucesso!";
	}

	// Update
	public String atualizar(Material material) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"UPDATE tbl_material SET nome = ?, descricao = ?, data_cadastro = ? WHERE id_material = ?");
		stmt.setString(1, material.getNome());
		stmt.setString(2, material.getDescricao());
		stmt.setObject(3, material.getDataCadastro());
		stmt.setInt(4, material.getIdMaterial());
		stmt.executeUpdate();
		stmt.close();
		return "Material atualizado com sucesso!";
	}

	// Select
	public List<Material> selecionar() throws SQLException {
		List<Material> listaMaterial = new ArrayList<Material>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tbl_material");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Material material = new Material();
			material.setIdMaterial(rs.getInt("id_material"));
			material.setNome(rs.getString("nome"));
			material.setDescricao(rs.getString("descricao"));
			material.setDataCadastro(rs.getObject("data_cadastro", LocalDateTime.class));
			listaMaterial.add(material);
		}
		stmt.close();
		rs.close();
		return listaMaterial;
	}
}
