package br.univel;

import java.sql.Connection;

public class ConexaoComBanco {

	private Connection con;
	private static ConexaoComBanco conDB;
	private String url = "jdbc:h2:~/test";
	private String driver = "org.h2.Driver";
	private String senha = "sa";
	private String usuario = "sa";
	
	
	
}
