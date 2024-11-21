package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.beans.Material;
import br.com.fiap.beans.Ranking;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.EmpresaParceiraDAO;
import br.com.fiap.dao.EnvioMaterialDAO;
import br.com.fiap.dao.MaterialDAO;
import br.com.fiap.dao.RankingDAO;
import br.com.fiap.dao.UsuarioDAO;

public class TesteAtualizar {

	// Método para capturar inteiro
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	// Método para capturar texto
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	// Método para capturar um valor real
	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
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
		String[] options = { "Atualizar Usuario", "Atualizar Material", "Atualizar Empresa Parceira",
				"Atualizar Envio Material", "Atualizar Ranking", "Atualizar Aluno" };

		// Exibe o menu
		int escolha = JOptionPane.showOptionDialog(null, "Escolha a opção de atualizar:", "Menu Atualizar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		switch (escolha) {
		case 0: // Atualizar Usuario
			UsuarioDAO daoUsuario = new UsuarioDAO();
			List<Usuario> usuarios = daoUsuario.selecionar();
			String usuariosList = exibirRegistros(usuarios);
			if (usuariosList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há usuários para atualizar.");
				return;
			}
			int idUsuario = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID do Usuario a ser atualizado:\n" + usuariosList));
			Usuario usuario = daoUsuario.buscarPorId(idUsuario);
			if (usuario != null) {
				usuario.setNome(texto("Novo Nome:"));
				usuario.setEmail(texto("Novo Email:"));
				daoUsuario.atualizar(usuario);
				JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
			}
			break;

		case 1: // Atualizar Material
			MaterialDAO daoMaterial = new MaterialDAO();
			List<Material> materiais = daoMaterial.selecionar();
			String materiaisList = exibirRegistros(materiais);
			if (materiaisList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há materiais para atualizar.");
				return;
			}
			int idMaterial = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID do Material a ser atualizado:\n" + materiaisList));
			Material material = daoMaterial.buscarPorId(idMaterial);
			if (material != null) {
				material.setNome(texto("Novo Nome do Material:"));
				material.setQuantidade(inteiro("Nova Quantidade:"));
				daoMaterial.atualizar(material);
				JOptionPane.showMessageDialog(null, "Material atualizado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Material não encontrado.");
			}
			break;

		case 2: // Atualizar Empresa Parceira
			EmpresaParceiraDAO daoEmpresa = new EmpresaParceiraDAO();
			List<EmpresaParceira> empresas = daoEmpresa.selecionar();
			String empresasList = exibirRegistros(empresas);
			if (empresasList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há empresas parceiras para atualizar.");
				return;
			}
			int idParceiro = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID da Empresa Parceira a ser atualizada:\n" + empresasList));
			EmpresaParceira empresaParceira = daoEmpresa.buscarPorId(idParceiro);
			if (empresaParceira != null) {
				empresaParceira.setNome(texto("Novo Nome da Empresa:"));
				empresaParceira.setCnpj(texto("Novo CNPJ:"));
				daoEmpresa.atualizar(empresaParceira);
				JOptionPane.showMessageDialog(null, "Empresa Parceira atualizada com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Empresa Parceira não encontrada.");
			}
			break;

		case 3: // Atualizar Envio Material
			EnvioMaterialDAO daoEnvio = new EnvioMaterialDAO();
			List<EnvioMaterial> envios = daoEnvio.selecionar();
			String enviosList = exibirRegistros(envios);
			if (enviosList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há envios de material para atualizar.");
				return;
			}
			int idEnvio = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID do Envio Material a ser atualizado:\n" + enviosList));
			EnvioMaterial envioMaterial = daoEnvio.buscarPorId(idEnvio);
			if (envioMaterial != null) {
				envioMaterial.setData_envio(texto("Nova Data de Envio:"));
				daoEnvio.atualizar(envioMaterial);
				JOptionPane.showMessageDialog(null, "Envio de Material atualizado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Envio de Material não encontrado.");
			}
			break;

		case 4: // Atualizar Ranking
			RankingDAO daoRanking = new RankingDAO();
			List<Ranking> rankings = daoRanking.selecionar();
			String rankingsList = exibirRegistros(rankings);
			if (rankingsList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há rankings para atualizar.");
				return;
			}
			int idRanking = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha o ID do Ranking a ser atualizado:\n" + rankingsList));
			Ranking ranking = daoRanking.buscarPorId(idRanking);
			if (ranking != null) {
				ranking.setUltima_atualizacao(texto("Nova Data de Atualização:"));
				daoRanking.atualizar(ranking);
				JOptionPane.showMessageDialog(null, "Ranking atualizado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Ranking não encontrado.");
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
		}
	}
}
