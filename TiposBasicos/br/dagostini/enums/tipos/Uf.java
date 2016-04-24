package br.dagostini.enums.tipos;

import java.math.BigDecimal;

public enum Uf {

	PR("Paran�", "Sul") {
		@Override
		public BigDecimal getValorImposto(BigDecimal valor) {
			return valor.multiply(new BigDecimal(2.2f));
		}
	},

	SP("S�o Paulo", "Sudeste") {
		@Override
		public BigDecimal getValorImposto(BigDecimal valor) {
			return valor.multiply(new BigDecimal(2.3f));
		}
	},

	MT("Mato Grosso", "Centro-Oeste") {
		@Override
		public BigDecimal getValorImposto(BigDecimal valor) {
			return valor.multiply(new BigDecimal(1.2f));
		}
	};

	private final String nome;
	private final String regiao;

	private Uf(String nome, String regiao) {
		this.nome = nome;
		this.regiao = regiao;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public static final Uf getPorNome(String nome) {
		for (Uf uf : values()) {
			if (uf.getNome().equals(nome)) {
				return uf;
			}
		}
		throw new RuntimeException("Nome n�o encontrado: " + nome);
	}

	public abstract BigDecimal getValorImposto(BigDecimal valor);

}
