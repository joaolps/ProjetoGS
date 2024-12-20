package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.beans.Material;
import br.com.fiap.beans.Ranking;
import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.EmpresaParceiraBO;
import br.com.fiap.bo.EnvioMaterialBO;
import br.com.fiap.bo.MaterialBO;
import br.com.fiap.bo.RankingBO;
import br.com.fiap.bo.UsuarioBO;

public class TesteSelecionar {

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
		String[] options = { "Listar Usuarios", "Listar Materiais", "Listar Empresas Parceiras",
				"Listar Envios de Materiais", "Listar Rankings" };

		// Exibe o menu
		int escolha = JOptionPane.showOptionDialog(null, "Escolha a opção de listar:", "Menu Listar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		switch (escolha) {
		case 0: // Listar Usuario
			UsuarioBO usuarioBO = new UsuarioBO();
			List<Usuario> usuarios = usuarioBO.selecionarBo();
			String usuariosList = exibirRegistros(usuarios);
			if (usuariosList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há usuários para listar.");
			} else {
				JOptionPane.showMessageDialog(null, "Usuários:\n" + usuariosList);
			}
			break;

		case 1: // Listar Material
			MaterialBO materialBO = new MaterialBO();
			List<Material> materiais = materialBO.selecionarBo();
			String materiaisList = exibirRegistros(materiais);
			if (materiaisList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há materiais para listar.");
			} else {
				JOptionPane.showMessageDialog(null, "Materiais:\n" + materiaisList);
			}
			break;

		case 2: // Listar Empresa Parceira
			EmpresaParceiraBO empresaParceiraBO = new EmpresaParceiraBO();
			List<EmpresaParceira> empresas = empresaParceiraBO.selecionarBo();
			String empresasList = exibirRegistros(empresas);
			if (empresasList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há empresas parceiras para listar.");
			} else {
				JOptionPane.showMessageDialog(null, "Empresas Parceiras:\n" + empresasList);
			}
			break;

		case 3: // Listar Envio Material
			EnvioMaterialBO envioMaterialBO = new EnvioMaterialBO();
			List<EnvioMaterial> envios = envioMaterialBO.selecionarBo();
			String enviosList = exibirRegistros(envios);
			if (enviosList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há envios de material para listar.");
			} else {
				JOptionPane.showMessageDialog(null, "Envios de Materiais:\n" + enviosList);
			}
			break;

		case 4: // Listar Ranking
			RankingBO rankingBO = new RankingBO();
			List<Ranking> rankings = rankingBO.selecionarBo();
			String rankingsList = exibirRegistros(rankings);
			if (rankingsList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há rankings para listar.");
			} else {
				JOptionPane.showMessageDialog(null, "Rankings:\n" + rankingsList);
			}
			break;

		default:
			System.out.println("Opção inválida!");
		}
	}
}
