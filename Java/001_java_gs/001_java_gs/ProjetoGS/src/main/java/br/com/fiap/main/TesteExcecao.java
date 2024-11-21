package br.com.fiap.main;

public class TesteExcecao {

	public static void main(String[] args) {

		try {
			double resultado = 12 / 0;
			System.out.println(resultado);
		} catch (java.lang.ArithmeticException e) {
			System.out.println("Falha aritmetica na tentativa de dividir por zero");
			e.printStackTrace();
		} finally {
			System.out.println("ok");
		}

	}

}
