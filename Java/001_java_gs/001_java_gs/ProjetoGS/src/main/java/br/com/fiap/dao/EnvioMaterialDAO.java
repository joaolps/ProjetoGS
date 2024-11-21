package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.conexoes.ConexaoFactory;

public class EnvioMaterialDAO {

	public Connection minhaConexao;

	public EnvioMaterialDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(EnvioMaterial envioMaterial) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"INSERT INTO tbl_envio_material (id_usuario, id_material, id_parceiro, quantidade, data_envio) VALUES (?, ?, ?, ?, ?)");
		stmt.setInt(1, envioMaterial.getIdUsuario());
		stmt.setInt(2, envioMaterial.getIdMaterial());
		stmt.setInt(3, envioMaterial.getIdParceiro());
		stmt.setInt(4, envioMaterial.getQuantidade());
		stmt.setObject(5, envioMaterial.getDataEnvio());
		stmt.execute();
		stmt.close();
		return "Envio de material registrado com sucesso!";
	}

	// Delete
	public String deletar(int idEnvio) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM tbl_envio_material WHERE id_envio = ?");
		stmt.setInt(1, idEnvio);
		stmt.execute();
		stmt.close();
		return "Envio de material deletado com sucesso!";
	}

	// Update
	public String atualizar(EnvioMaterial envioMaterial) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"UPDATE tbl_envio_material SET id_usuario = ?, id_material = ?, id_parceiro = ?, quantidade = ?, data_envio = ? WHERE id_envio = ?");
		stmt.setInt(1, envioMaterial.getIdUsuario());
		stmt.setInt(2, envioMaterial.getIdMaterial());
		stmt.setInt(3, envioMaterial.getIdParceiro());
		stmt.setInt(4, envioMaterial.getQuantidade());
		stmt.setObject(5, envioMaterial.getDataEnvio());
		stmt.setInt(6, envioMaterial.getIdEnvio());
		stmt.executeUpdate();
		stmt.close();
		return "Envio de material atualizado com sucesso!";
	}

	// Select
	public List<EnvioMaterial> selecionar() throws SQLException {
		List<EnvioMaterial> listaEnvioMaterial = new ArrayList<EnvioMaterial>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tbl_envio_material");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			EnvioMaterial envioMaterial = new EnvioMaterial();
			envioMaterial.setIdEnvio(rs.getInt("id_envio"));
			envioMaterial.setIdUsuario(rs.getInt("id_usuario"));
			envioMaterial.setIdMaterial(rs.getInt("id_material"));
			envioMaterial.setIdParceiro(rs.getInt("id_parceiro"));
			envioMaterial.setQuantidade(rs.getInt("quantidade"));
			envioMaterial.setDataEnvio(rs.getObject("data_envio", LocalDateTime.class));
			listaEnvioMaterial.add(envioMaterial);
		}
		stmt.close();
		rs.close();
		return listaEnvioMaterial;
	}
}
