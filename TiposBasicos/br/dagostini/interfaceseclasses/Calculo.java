package br.dagostini.interfaceseclasses;

/**
 * Um interface especifica "o qu�" mas n�o especifica "como".
 *
 * @author fernandod
 */
public interface Calculo {

	// Interfaces podem ter constantes mas nunca vari�veis.
	static final double PI = 3.14d;

	double calcular(double a, double b);

	/**
	 * Interfaces podem ter implementa��o padr�o para os m�todos. Quando um
	 * m�todo tem uma implementa��o padr�o como abaixo sua implementa��o na
	 * classe se torna opcional.
	 *
	 * @return
	 */
	default String getNomeImplementacao() {
		return "N�o especificado";
	}

}
