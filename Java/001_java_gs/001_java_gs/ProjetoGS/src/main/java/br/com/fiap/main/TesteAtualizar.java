package br.com.fiap.main;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Material;
import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.beans.Ranking;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.MaterialDAO;
import br.com.fiap.dao.EmpresaParceiraDAO;
import br.com.fiap.dao.EnvioMaterialDAO;
import br.com.fiap.dao.RankingDAO;

public class TesteAtualizar {

	// Método para capturar texto
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	// Método para capturar inteiro
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	// Método para capturar número real
	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	// Exibe o menu para o usuário
	static int exibirMenu() {
		String[] opcoes = { "Atualizar Usuario", "Atualizar Material", "Atualizar Empresa Parceira",
				"Atualizar Envio Material", "Atualizar Ranking", "Sair" };
		return JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu Atualizar", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean continuar = true;

		while (continuar) {
			int opcao = exibirMenu(); // Exibe o menu e captura a opção escolhida

			switch (opcao) {
			case 0: // Atualizar Usuario
				Usuario objUsuario = new Usuario();
				UsuarioDAO usuarioDao = new UsuarioDAO();

				objUsuario.setId_usuario(inteiro("ID do Usuario a ser atualizado"));
				objUsuario.setNome(texto("Novo Nome"));
				objUsuario.setCpf(texto("Novo CPF"));
				objUsuario.setEmail(texto("Novo Email"));
				objUsuario.setTelefone(texto("Novo Telefone"));

				System.out.println(usuarioDao.atualizar(objUsuario));
				break;

			case 1: // Atualizar Material
				Material objMaterial = new Material();
				MaterialDAO materialDao = new MaterialDAO();

				objMaterial.setIdMaterial(inteiro("ID do Material a ser atualizado"));
				objMaterial.setNome(texto("Novo Nome do Material"));
				objMaterial.setDescricao(texto("Nova Descrição"));

				System.out.println(materialDao.atualizar(objMaterial));
				break;

			case 2: // Atualizar Empresa Parceira
				EmpresaParceira objEmpresaParceira = new EmpresaParceira();
				EmpresaParceiraDAO empresaParceiraDao = new EmpresaParceiraDAO();

				objEmpresaParceira.setIdParceiro(inteiro("ID da Empresa Parceira a ser atualizada"));
				objEmpresaParceira.setNome(texto("Novo Nome"));
				objEmpresaParceira.setEmail(texto("Novo Email"));
				objEmpresaParceira.setTelefone(texto("Novo Telefone"));
				objEmpresaParceira.setCnpj(texto("Novo CNPJ"));
				objEmpresaParceira.setEndereco(texto("Novo Endereço"));

				System.out.println(empresaParceiraDao.atualizar(objEmpresaParceira));
				break;

			case 3: // Atualizar Envio Material
				EnvioMaterial objEnvioMaterial = new EnvioMaterial();
				EnvioMaterialDAO envioMaterialDao = new EnvioMaterialDAO();

				objEnvioMaterial.setIdEnvio(inteiro("ID do Envio a ser atualizado"));
				objEnvioMaterial.setIdUsuario(inteiro("Novo ID do Usuario"));
				objEnvioMaterial.setIdMaterial(inteiro("Novo ID do Material"));
				objEnvioMaterial.setIdParceiro(inteiro("Novo ID do Parceiro"));
				objEnvioMaterial.setQuantidade(inteiro("Nova Quantidade"));

				System.out.println(envioMaterialDao.atualizar(objEnvioMaterial));
				break;

			case 4: // Atualizar Ranking
				Ranking objRanking = new Ranking();
				RankingDAO rankingDao = new RankingDAO();

				objRanking.setIdUsuario(inteiro("ID do Usuario a ser atualizado"));
				objRanking.setPontos(inteiro("Novos Pontos"));
				objRanking.setUltimaAtualizacao(java.time.LocalDateTime.now());

				System.out.println(rankingDao.atualizar(objRanking));
				break;

			case 5: // Sair
				continuar = false;
				JOptionPane.showMessageDialog(null, "Programa encerrado!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}
}
