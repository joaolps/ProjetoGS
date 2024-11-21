package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {

	UsuarioDAO usuarioDao;

	// Selecionar
	public ArrayList<Usuario> selecionarBo() throws ClassNotFoundException, SQLException {
		usuarioDao = new UsuarioDAO();

		// Regra de negócios

		return (ArrayList<Usuario>) usuarioDao.selecionar();
	}

	// Inserir
	public void inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		usuarioDao = new UsuarioDAO();

		// Regra de negócios

		usuarioDao.inserir(usuario);
	}

	// Atualizar
	public void atualizarBo(Usuario usuario) throws ClassNotFoundException, SQLException {
		usuarioDao = new UsuarioDAO();

		// Regra de negócios

		usuarioDao.atualizar(usuario);
	}

	// Deletar
	public void deletarBo(int idUsuario) throws ClassNotFoundException, SQLException {
		usuarioDao = new UsuarioDAO();

		// Regra de negócios

		usuarioDao.deletar(idUsuario);
	}
}
