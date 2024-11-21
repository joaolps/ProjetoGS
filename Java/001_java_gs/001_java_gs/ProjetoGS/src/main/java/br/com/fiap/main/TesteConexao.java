package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.excecoes.Excecao;

public class TesteConexao {

	public static void main(String[] args) throws Excecao, ClassNotFoundException, SQLException {

		Connection c = null;

		try {
			c = new ConexaoFactory().conexao();
			System.out.println("Conectado com o Banco de Dados");
		} catch (Exception e) {
			throw new Excecao(e);
		} finally {

		}
		c.close();

	}

}
