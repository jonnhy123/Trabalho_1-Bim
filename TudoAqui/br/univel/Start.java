package br.univel;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Start extends SqlGen{

	
	
	@Override
	protected String getCreateTable(Connection con, Object obj) {
		// TODO Auto-generated method stub
	    try {
		String nomeDaTabela;
		Class<?> classe1 = obj.getClass();
		
		StringBuilder sb = new StringBuilder();
		
		//Se anotação esta presente na Class Tabela
		if(classe1.isAnnotationPresent(Tabela.class)){
			//comAnotacao recebe a anotação da Class Tabela
			Tabela comAnotacao = classe1.getAnnotation(Tabela.class);
			//nomeDaTabela recebe o valor da anotação
			nomeDaTabela = comAnotacao.value();
		}else{
			nomeDaTabela = classe1.getSimpleName().toUpperCase();
		}
		sb.append("CREATE TABLE").append(nomeDaTabela).append(" (");
		
		Field[] atributosDeclarados = classe1.getDeclaredFields();
		
		for (int i = 0; i < atributosDeclarados.length; i++) {
			Field field = atributosDeclarados[i];
			String nomeDaColuna, TipoDaColuna = null;
			
			if(field.isAnnotationPresent(Coluna.class)){
				Coluna anotacaoNaColuna = field.getAnnotation(Coluna.class);
				if(anotacaoNaColuna.nome().isEmpty()){
					nomeDaColuna = field.getName().toUpperCase();
				}else{
					nomeDaColuna = anotacaoNaColuna.nome();
				}
			}else{
				nomeDaColuna = field.getName().toUpperCase();
			}
			
			Class<?> parametros = field.getType();
			
			if(parametros.equals(String.class)){
				if(field.getAnnotation(Coluna.class).tamanho() > -1){
					TipoDaColuna = "VARCHAR(" + field.getAnnotation(Coluna.class).tamanho() + ")";
				}else{
					TipoDaColuna = "VARCHAR(100)";
				}
			}else if(parametros.equals(int.class)){
				if(field.getAnnotation(Coluna.class).pk() == true){
					TipoDaColuna = "INT NOT NULL";
				}else{
					TipoDaColuna = "INT";
				}
			}else if(parametros.isEnum()){
				TipoDaColuna = "INT";
			}
			if(i > 0){
				sb.append(",");
			}
		}
		
		sb.append(", PRIMARY KEY(");
		for (int i = 0; i < atributosDeclarados.length; i++) {
			int vlr = 0;
			Field fields = atributosDeclarados[i];
			
			if(fields.isAnnotationPresent(Coluna.class)){
				Coluna anotacaoNaColuna = fields.getAnnotation(Coluna.class);
				if(anotacaoNaColuna.pk()){
					if (vlr > 0) {
						sb.append(", ");
					}
					if(anotacaoNaColuna.nome().isEmpty()){
						sb.append(fields.getName());
					}
					vlr++;
				}
			}
			if(i == atributosDeclarados.length - 1){
				sb.append(")");
			}
		}
		sb.append(");\n");
		
		String criando = sb.toString();
		System.out.println(criando);
		Statement executa = con.createStatement();
		executa.executeUpdate(criando);
		
		return criando;
		
	 } catch (SecurityException e) {
         throw new RuntimeException(e);
     } catch (SQLException e) {
         e.printStackTrace();
         return null;
     }
		
	}

	@Override
	protected String getDropTable(Connection con, Object obj) {
		// TODO Auto-generated method stub
		try{
		String nomeDaTabela;
		StringBuilder sb = new StringBuilder();
		
		Class<?> classe1 = obj.getClass();
		
		if(classe1.isAnnotationPresent(Tabela.class)){
			Tabela tabela = classe1.getAnnotation(Tabela.class);
			nomeDaTabela = tabela.value();
		}else{
			nomeDaTabela = classe1.getSimpleName().toUpperCase();
		}
		
		sb.append("DROP TABLE ").append(nomeDaTabela).append(";");
		String apaga = sb.toString();
		
		System.out.println(apaga);
		Statement executa = con.createStatement();
		executa.executeUpdate(apaga);
		return apaga;
	 } catch (SQLException e) {
         e.printStackTrace();
         return null;
     }
 }

	@Override
	protected PreparedStatement getSqlInsert(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlSelectAll(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlSelectById(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlUpdateById(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement getSqlDeleteById(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
