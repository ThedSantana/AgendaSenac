package banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import cliente.Cliente;
public class AcoesBanco {

	private Connection connection;	//para tentar utilizar com o PreparedStatement
	public AcoesBanco()
	{
		this.connection = new ConexaoBanco().GetConection();
	}
	
	public void InserirRegistro(Cliente c)  throws ClassNotFoundException, SQLException{
		
		String sql;
		ConexaoBanco conn = new ConexaoBanco();			
		
		sql = "INSERT INTO contato (nome,telefone) " +
				"VALUES ('"+c.getNome()+"','"+c.getTelefone()+"')";				
		conn.ConectarBanco(sql, 1);		
		conn.FechaConexao();
		System.out.println("Registro inserido com sucesso.\n\n");
	}
	
	
	public void BuscarCliente(Connection conn) throws SQLException{
		
		Statement stmt = null;
		String sql ="SELECT nome,telefone FROM contato ORDER BY nome ASC";
		
		stmt = (Statement) conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
		
		
		while(rs.next())
		{
			//Retrieve by column name
			String nome_temp = rs.getString("nome");
			String tel_temp = rs.getString("telefone");
			//Display values
			System.out.print("nome: " + nome_temp+" ");
			System.out.print(", tel: " + tel_temp);
			System.out.println();
		}
		rs.close();		
	}
	
	
	//altera apenas nome	Funcionando
	public void updateRegistroNome(int id, String novoNome) throws ClassNotFoundException, SQLException{
		String sql;
		ConexaoBanco conn = new ConexaoBanco();		
			
		sql = "UPDATE contato SET nome='"+novoNome+"' WHERE id='"+id+"'";
		System.out.println("registro alterado com sucesso.");
		conn.ConectarBanco(sql, 1);		
		conn.FechaConexao();
			
	}
	
	
	//deleta pelo numero de telefone	Funcionando	
	public void DeletaFone(String numeroFOne) throws ClassNotFoundException, SQLException{
		
		String sql;
		ConexaoBanco conn = new ConexaoBanco();		
		
		sql = "DELETE FROM contato "
				+ "WHERE telefone = '"+numeroFOne+"'";			
		conn.ConectarBanco(sql, 1);		
		conn.FechaConexao();
	}


	// 4- altera por um numero de telefone		funcionando
	public void AlteraPorTelefone(Cliente c){
		
		String sql = "UPDATE contato set nome=?, telefone=?"
				+"WHERE telefone=?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.QualTelefone());
			
			stmt.execute();
			stmt.close();
			System.out.println("Registro alterado com sucesso.");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void ListaContato(String nomeBuscado){
		
		try{			
			PreparedStatement stmt = (PreparedStatement) this.connection.
					prepareStatement("select nome, telefone from contato WHERE nome="+nomeBuscado);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				//Retrieve by column name
				String nome_temp = rs.getString("nome");
				String tel_temp = rs.getString("telefone");
				//Display values
				System.out.print("nome: " + nome_temp+" ");
				System.out.print(", tel: " + tel_temp);
				System.out.println();
			}
			rs.close();		
			stmt.close();
		}catch (SQLException e){
	         throw new RuntimeException(e);
	     }		
	}
}
