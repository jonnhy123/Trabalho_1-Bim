package br.dagostini.classesgenericas;

/**
 * Essa classe gen�rica implementa uma interface gen�rica.
 *
 */
public class PilhaImpl<T> implements Pilha<T> {

	// N�o podemos ter vetores de tipos gen�ricos.
	// Um tipo gen�rico (T) n�o pode ser primitivo.
	private Object[] vetor = new Object[100];

	private int idx = 0;

	@Override
	public void guardar(T t) {
		vetor[idx++] = t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removerUltimo() {
		return (T) vetor[--idx];
	}

	@Override
	public void mostrarTodos() {
		for (int i = 0; i < idx; i++) {
			System.out.println("> " + vetor[i]);
		}
	}
}
