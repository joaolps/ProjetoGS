package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.conexoes.ConexaoFactory;

public class EmpresaParceiraDAO {

	private Connection minhaConexao;

	public EmpresaParceiraDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(EmpresaParceira empresaParceira) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"INSERT INTO tbl_empresa_parceira (nome, email, telefone, cnpj, endereco, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setString(1, empresaParceira.getNome());
		stmt.setString(2, empresaParceira.getEmail());
		stmt.setString(3, empresaParceira.getTelefone());
		stmt.setString(4, empresaParceira.getCnpj());
		stmt.setString(5, empresaParceira.getEndereco());
		stmt.setObject(6, empresaParceira.getDataCadastro());
		stmt.execute();
		stmt.close();
		return "Empresa Parceira cadastrada com sucesso!";
	}

	// Delete
	public String deletar(int idParceiro) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("DELETE FROM tbl_empresa_parceira WHERE id_parceiro = ?");
		stmt.setInt(1, idParceiro);
		stmt.execute();
		stmt.close();
		return "Empresa Parceira deletada com sucesso!";
	}

	// Update
	public String atualizar(EmpresaParceira empresaParceira) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"UPDATE tbl_empresa_parceira SET nome = ?, email = ?, telefone = ?, cnpj = ?, endereco = ?, data_cadastro = ? WHERE id_parceiro = ?");
		stmt.setString(1, empresaParceira.getNome());
		stmt.setString(2, empresaParceira.getEmail());
		stmt.setString(3, empresaParceira.getTelefone());
		stmt.setString(4, empresaParceira.getCnpj());
		stmt.setString(5, empresaParceira.getEndereco());
		stmt.setObject(6, empresaParceira.getDataCadastro());
		stmt.setInt(7, empresaParceira.getIdParceiro());
		stmt.executeUpdate();
		stmt.close();
		return "Empresa Parceira atualizada com sucesso!";
	}

	// Select
	public List<EmpresaParceira> selecionar() throws SQLException {
		List<EmpresaParceira> listaEmpresaParceira = new ArrayList<EmpresaParceira>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tbl_empresa_parceira");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			EmpresaParceira empresaParceira = new EmpresaParceira();
			empresaParceira.setIdParceiro(rs.getInt("id_parceiro"));
			empresaParceira.setNome(rs.getString("nome"));
			empresaParceira.setEmail(rs.getString("email"));
			empresaParceira.setTelefone(rs.getString("telefone"));
			empresaParceira.setCnpj(rs.getString("cnpj"));
			empresaParceira.setEndereco(rs.getString("endereco"));
			empresaParceira.setDataCadastro(rs.getObject("data_cadastro", LocalDateTime.class));
			listaEmpresaParceira.add(empresaParceira);
		}
		stmt.close();
		rs.close();
		return listaEmpresaParceira;
	}

	// Select by ID
	public EmpresaParceira selecionarPorId(int idParceiro) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("SELECT * FROM tbl_empresa_parceira WHERE id_parceiro = ?");
		stmt.setInt(1, idParceiro);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			EmpresaParceira empresaParceira = new EmpresaParceira();
			empresaParceira.setIdParceiro(rs.getInt("id_parceiro"));
			empresaParceira.setNome(rs.getString("nome"));
			empresaParceira.setEmail(rs.getString("email"));
			empresaParceira.setTelefone(rs.getString("telefone"));
			empresaParceira.setCnpj(rs.getString("cnpj"));
			empresaParceira.setEndereco(rs.getString("endereco"));
			empresaParceira.setDataCadastro(rs.getObject("data_cadastro", LocalDateTime.class));
			stmt.close();
			rs.close();
			return empresaParceira;
		}

		stmt.close();
		rs.close();
		return null;
	}
}
