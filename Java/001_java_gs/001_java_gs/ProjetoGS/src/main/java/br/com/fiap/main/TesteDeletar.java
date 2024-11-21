package br.com.fiap.main;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import br.com.fiap.beans.Material;
import br.com.fiap.dao.MaterialDAO;

import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.dao.EmpresaParceiraDAO;

import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.dao.EnvioMaterialDAO;

import br.com.fiap.beans.Ranking;
import br.com.fiap.dao.RankingDAO;

public class TesteDeletar {

	// Método para capturar inteiro
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	// Método para capturar uma lista de objetos e exibir para o usuário escolher um
	// ID
	static <T> String exibirRegistros(List<T> registros) {
		StringBuilder sb = new StringBuilder();
		for (T registro : registros) {
			sb.append(registro.toString()).append("\n"); // Assume que o método toString() está bem definido
		}
		return sb.toString();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Menu de opções
		String[] options = { "Deletar Usuario", "Deletar Material", "Deletar Empresa Parceira",
				"Deletar Envio Material", "Deletar Ranking" };

		// Exibe o menu
		int escolha = JOptionPane.showOptionDialog(null, "Escolha a opção de deletar:", "Menu Deletar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		switch (escolha) {
		case 0: // Deletar Usuario
			UsuarioDAO daoUsuario = new UsuarioDAO();
			List<Usuario> usuarios = daoUsuario.selecionar();
			String usuariosList = exibirRegistros(usuarios);
			if (usuariosList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há usuários para deletar.");
				return;
			}
			int idUsuario = Integer
					.parseInt(JOptionPane.showInputDialog("Escolha o ID do Usuario a ser deletado:\n" + usuariosList));
			System.out.println(daoUsuario.deletar(idUsuario));
			break;

		case 1: // Deletar Material
			MaterialDAO daoMaterial = new MaterialDAO();
			List<Material> materiais = daoMaterial.selecionar();
			String materiaisList = exibirRegistros(materiais);
			if (materiaisList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há materiais para deletar.");
				return;
			}
			int idMaterial = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID do Material a ser deletado:\n" + materiaisList));
			System.out.println(daoMaterial.deletar(idMaterial));
			break;

		case 2: // Deletar Empresa Parceira
			EmpresaParceiraDAO daoEmpresa = new EmpresaParceiraDAO();
			List<EmpresaParceira> empresas = daoEmpresa.selecionar();
			String empresasList = exibirRegistros(empresas);
			if (empresasList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há empresas parceiras para deletar.");
				return;
			}
			int idParceiro = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID da Empresa Parceira a ser deletado:\n" + empresasList));
			System.out.println(daoEmpresa.deletar(idParceiro));
			break;

		case 3: // Deletar Envio Material
			EnvioMaterialDAO daoEnvio = new EnvioMaterialDAO();
			List<EnvioMaterial> envios = daoEnvio.selecionar();
			String enviosList = exibirRegistros(envios);
			if (enviosList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há envios de material para deletar.");
				return;
			}
			int idEnvio = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID do Envio Material a ser deletado:\n" + enviosList));
			System.out.println(daoEnvio.deletar(idEnvio));
			break;

		case 4: // Deletar Ranking
			RankingDAO daoRanking = new RankingDAO();
			List<Ranking> rankings = daoRanking.selecionar();
			String rankingsList = exibirRegistros(rankings);
			if (rankingsList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há rankings para deletar.");
				return;
			}
			int idRanking = Integer
					.parseInt(JOptionPane.showInputDialog("Escolha o ID do Ranking a ser deletado:\n" + rankingsList));
			System.out.println(daoRanking.deletar(idRanking));
			break;

		default:
			System.out.println("Opção inválida!");
		}
	}
}
