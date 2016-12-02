package banco;

import java.sql.*;
import java.sql.Connection;
public class ConexaoBanco {

	 Connection conn = null;
	 Statement stmt = null;
	 
	public void ConectarBanco(String sql, int tipoExecucao) throws ClassNotFoundException, SQLException
	{
		int qualQuery = tipoExecucao;
		
		//nome do driver e endereço do banco
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/AgendaSenac";
		
		//3° usuário e senha do banco
		final String USER = "root";
		final String PASS = "Well#28081984";			//"Well#28081984";
				
		Class.forName("com.mysql.jdbc.Driver");
		
			//abrir a conexão
			//exige throws SQLException
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();	
			
			if(tipoExecucao == 1)	//insert, update, remove
				stmt.executeUpdate(sql);
			else					//busca, select
				stmt.executeQuery(sql);
	}
	
	//classe de conexao pura para usar com o Prepared statement
	public Connection GetConection(){
		try
		{
			return  DriverManager.getConnection("jdbc:mysql://localhost/AgendaSenac?"
					+ "autoReconeect=true&useSSL=false", "root","Well#28081984"); //"Well#28081984";
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	public void FechaConexao() throws SQLException
	{
		conn.close();
		//System.out.println("Conexão fechada");
	}
	
	
}
