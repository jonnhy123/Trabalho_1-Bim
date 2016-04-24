package br.dagostini.interfaceseclasses;

public class ExecuteTestesInterfaces2 {

	public ExecuteTestesInterfaces2() {

		// � poss�vel referenciar uma classe definida internatente
		// em outro arquivo.
		Calculo c1 = new Menor();
		System.out.println(c1.calcular(1, 2));

		// Criando uma classe an�nima implementando uma extens�o de Calculo
		// definida internamente em outra classe.
		Calculo c2 = new ExecuteTestesInterfaces.Maior() {
			@Override
			public double calcular(double a, double b) {
				return a > b ? a : b;
			}
		};
		System.out.println(c2.calcular(1, 2));

	}

	public static void main(String[] args) {
		new ExecuteTestesInterfaces();

	}

}