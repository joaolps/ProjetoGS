package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

public class UsuarioDAO {

	public Connection minhaConexao;

	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(Usuario usuario) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("INSERT INTO tbl_usuario (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getTelefone());
		stmt.execute();
		stmt.close();
		return "Usuário cadastrado com sucesso!";
	}

	// Delete
	public String deletar(int idUsuario) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM tbl_usuario WHERE id_usuario = ?");
		stmt.setInt(1, idUsuario);
		stmt.execute();
		stmt.close();
		return "Usuário deletado com sucesso!";
	}

	// Update
	public String atualizar(Usuario usuario) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"UPDATE tbl_usuario SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE id_usuario = ?");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getTelefone());
		stmt.setInt(5, usuario.getId_usuario());
		stmt.executeUpdate();
		stmt.close();
		return "Usuário atualizado com sucesso!";
	}

	// Select
	public List<Usuario> selecionar() throws SQLException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM tbl_usuario");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId_usuario(rs.getInt("id_usuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTelefone(rs.getString("telefone"));
			listaUsuarios.add(usuario);
		}
		stmt.close();
		rs.close();
		return listaUsuarios;
	}
}
