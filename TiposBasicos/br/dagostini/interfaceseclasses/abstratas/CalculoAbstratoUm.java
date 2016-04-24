package br.dagostini.interfaceseclasses.abstratas;

import br.dagostini.interfaceseclasses.Calculo;

/**
 * Classes abstratas podem declarar que implementam alguma interface mas n�o
 * necessariamente devendo implementar seus m�todos, deixando essa
 * responsabilidade para as subclasses da classe abstrata.
 *
 * Uma classe abstrata difere de uma interface com m�todos default porque ela
 * pode ter um construtor e atributos de classe. Ela tamb�m n�o pode ser
 * instanciada, devendo haver assim uma subclasse, mesmo que an�nima.
 *
 * @author fernandod
 *
 */
public abstract class CalculoAbstratoUm implements Calculo {

	private int i;

	public CalculoAbstratoUm() {
		this.i = 0;
	}

	public void incrementaContador() {
		this.i++;
	}

	public int quantasVezes() {
		return this.i;
	}

}
