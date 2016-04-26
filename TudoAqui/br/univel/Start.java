package br.univel;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Start extends SqlGen{

	
	
	@Override
	protected String getCreateTable(Connection con, Object obj) {
		// TODO Auto-generated method stub
		String nomeDaTabela;
		Class<?> classe1 = obj.getClass();
		
		StringBuilder sb = new StringBuilder();
		
		//Se anota��o esta presente na Class Tabela
		if(classe1.isAnnotationPresent(Tabela.class)){
			//comAnotacao recebe a anota��o da Class Tabela
			Tabela comAnotacao = classe1.getAnnotation(Tabela.class);
			//nomeDaTabela recebe o valor da anota��o
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
				
			}
		}
		
		return null;
	}

	@Override
	protected String getDropTable(Connection con, Object obj) {
		// TODO Auto-generated method stub
		return null;
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
