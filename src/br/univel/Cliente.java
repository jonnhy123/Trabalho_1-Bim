package br.univel;

@Tabela("CADASTRO_CLIENTE")//anotação tabela
public class Cliente {

	public Cliente(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Coluna(pk = true)
	private int id;
	
	@Coluna(nome = "NOME", tamanho = 15)
	private String nome;
	
	@Coluna(nome = "ESTADO_CIVIL", tamanho = 15)
	private EstadoCivil estadoCivil;
	
	@Coluna(nome = "TELEFONE", tamanho = 12)
	private int telefone;
	
	@Coluna(nome = "IDADE", tamanho = 3)
	private int idade;
	
	@Coluna(nome = "ENDERECO", tamanho = 20)
	private String endereco;
	
}
