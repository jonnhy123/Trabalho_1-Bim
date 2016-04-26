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
	
	public Connection abrir() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void fexar() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConexaoComBanco ConectaDB() {
		
		if(conDB == null){
			return conDB;
		}
		return conDB;
	}
	
}
