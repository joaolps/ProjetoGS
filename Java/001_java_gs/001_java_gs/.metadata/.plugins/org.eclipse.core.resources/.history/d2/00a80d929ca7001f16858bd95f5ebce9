package br.com.fiap.excecoes;

public class Excecao extends Exception {

	public Excecao() {
		super();
	}

	public Excecao(Exception e) {
		super();
		if (e.getClass().toString().equals("class java.lang.ClassNotFoundException")) {
			System.out.println("Falha no Driver");
			e.printStackTrace();
		} else if (e.getClass().toString().equals("class java.sql.SQLException")) {
			System.out.println("Falha nas informações de comunicação com o Banco de Dados");
			e.printStackTrace();
		} else {
			System.out.println("Falha Desconhecida");
			e.printStackTrace();
		}
	}

}
