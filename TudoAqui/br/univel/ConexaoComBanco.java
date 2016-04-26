package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBanco {

	private Connection con;
	private static ConexaoComBanco conDB;
	private String url = "jdbc:h2:~/test";
	private String driver = "org.h2.Driver";
	private String senha = "sa";
	private String usuario = "sa"; 
	
	public ConexaoComBanco(){};//Construtor
	
	public Connection abrir() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url, usuario, senha);
		return con;
	}
	
	public void fexar() throws SQLException{
		con.close();
	}
	
	public static ConexaoComBanco ConectaDB() {
		
		if(conDB == null){
			return conDB;
		}
		return conDB;
	}
	
}
