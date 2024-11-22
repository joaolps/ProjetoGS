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

public class TesteCadastro {

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
		String[] opcoes = { "Cadastrar Usuario", "Cadastrar Material", "Cadastrar Empresa Parceira",
				"Cadastrar Envio Material", "Cadastrar Ranking", "Sair" };
		return JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean continuar = true;

		while (continuar) {
			int opcao = exibirMenu(); // Exibe o menu e captura a opção escolhida

			switch (opcao) {
			case 0: // Cadastrar Usuario
				Usuario objUsuario = new Usuario();
				UsuarioDAO usuarioDao = new UsuarioDAO();

				objUsuario.setNome(texto("Nome"));
				objUsuario.setCpf(texto("CPF"));
				objUsuario.setEmail(texto("Email"));
				objUsuario.setTelefone(texto("Telefone"));

				System.out.println(usuarioDao.inserir(objUsuario));
				break;

			case 1: // Cadastrar Material
				Material objMaterial = new Material();
				MaterialDAO materialDao = new MaterialDAO();

				objMaterial.setNome(texto("Nome do Material"));
				objMaterial.setDescricao(texto("Descrição"));
				objMaterial.setDataCadastro(java.time.LocalDateTime.now());

				System.out.println(materialDao.inserir(objMaterial));
				break;

			case 2: // Cadastrar Empresa Parceira
				EmpresaParceira objEmpresaParceira = new EmpresaParceira();
				EmpresaParceiraDAO empresaParceiraDao = new EmpresaParceiraDAO();

				objEmpresaParceira.setNome(texto("Nome da Empresa"));
				objEmpresaParceira.setEmail(texto("Email"));
				objEmpresaParceira.setTelefone(texto("Telefone"));
				objEmpresaParceira.setCnpj(texto("CNPJ"));
				objEmpresaParceira.setEndereco(texto("Endereço"));
				objEmpresaParceira.setDataCadastro(java.time.LocalDateTime.now());

				System.out.println(empresaParceiraDao.inserir(objEmpresaParceira));
				break;

			case 3: // Cadastrar Envio Material
				EnvioMaterial objEnvioMaterial = new EnvioMaterial();
				EnvioMaterialDAO envioMaterialDao = new EnvioMaterialDAO();

				objEnvioMaterial.setIdUsuario(inteiro("ID do Usuario"));
				objEnvioMaterial.setIdMaterial(inteiro("ID do Material"));
				objEnvioMaterial.setIdParceiro(inteiro("ID do Parceiro"));
				objEnvioMaterial.setQuantidade(inteiro("Quantidade"));
				objEnvioMaterial.setDataEnvio(java.time.LocalDateTime.now());

				System.out.println(envioMaterialDao.inserir(objEnvioMaterial));
				break;

			case 4: // Cadastrar Ranking
				Ranking objRanking = new Ranking();
				RankingDAO rankingDao = new RankingDAO();

				objRanking.setIdUsuario(inteiro("ID Usuario"));
				objRanking.setPontos(inteiro("Pontos"));
				objRanking.setUltimaAtualizacao(java.time.LocalDateTime.now());

				System.out.println(rankingDao.inserir(objRanking));
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
