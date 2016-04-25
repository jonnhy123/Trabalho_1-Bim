package br.univel;

@Tabela("CADASTRO_CLIENTE")//anotação tabela
public class Cliente {

	@Coluna(pk = true)
	private int id;
	
}
