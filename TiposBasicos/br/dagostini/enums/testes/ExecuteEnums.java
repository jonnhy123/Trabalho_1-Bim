package br.dagostini.enums.testes;

import java.math.BigDecimal;
import java.text.NumberFormat;

import br.dagostini.enums.tipos.EstadoCivil;
import br.dagostini.enums.tipos.Mes;
import br.dagostini.enums.tipos.Uf;

public class ExecuteEnums {

	public static void main(String[] args) {

		// Enum simples.
		{
			EstadoCivil estadoCivil = EstadoCivil.CASADO;

			// Dessa forma se obt�m o nome do valor.
			System.out.println(estadoCivil.name());

			// Assim se obt�m o n�mero da ordem de declara��o, geralmente
			// utilizado para gravar no banco.
			System.out.println(estadoCivil.ordinal());
		}

		// Enum com atributos.
		{
			Mes mes = Mes.JANEIRO;

			switch (mes) {

			case JANEIRO:
			case FEVEREIRO:
			case MARCO:
			case ABRIL:
			case MAIO:
			case JUNHO:
				System.out.println("1o semestre");
				break;

			case JULHO:
			case AGOSTO:
			case SETEMBRO:
			case OUTUBRO:
			case NOVEMBRO:
			case DEZEMBRO:
				System.out.println("2o semestre");
				break;

			}

			System.out.println("O m�s de " + mes.getNome() + " possui " + mes.getDias() + " dias.");
		}

		// Enum com atributos, m�todos est�tico e abstrato.
		{
			// Usando o m�todo est�tico.
			Uf uf = Uf.getPorNome("Paran�");

			// Usando o m�todo abstrado implementado pelo item da enum
			BigDecimal valor = new BigDecimal(100);
			BigDecimal valorImposto = uf.getValorImposto(valor);

			NumberFormat nf = NumberFormat.getCurrencyInstance();

			System.out.println("O valor " + nf.format(valor) + " no estado do " + uf.getNome() + " fica "
					+ nf.format(valorImposto) + " com o imposto.");
		}
	}
}
