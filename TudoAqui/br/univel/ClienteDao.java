package br.univel;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/*
 5.Classe que implementa a interface abaixo e usa a classe anterior 
 (extends SqlGen). Essa classe tem o T como objeto que irá manipular (Cliente por exemplo) e K como sua chave primária (Integer ou Long por exemplo). A interface deve ser genérica mas classe não precisa, ex: class x implements Dao<Cliente, Integer>.

publicinterface Dao<T, K> {
publicvoid salvar(T t);
public T buscar(K k);
publicvoid atualizar(T t);
publicvoid excluir(K k);
public List<T> listarTodos();
}
 */
public abstract class ClienteDao<T, K> implements Dao<T, K>{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection con = ConexaoComBanco.ConectaDB().abrir();
	private Start st = new Start();
	private List<Cliente> list = null;
	
	@Override
	public void salvar(T t) {
		try {
            ps = st.getSqlInsert(con, t);
            ps.executeUpdate();
            ps.close();

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public T buscar(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(K k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}



}
