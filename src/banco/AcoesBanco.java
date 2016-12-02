package banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import cliente.Cliente;
import menu.Menu;
public class AcoesBanco {

	private Connection connection;	//para tentar utilizar com o PreparedStatement
	private Menu menu;
	
	public AcoesBanco()
	{
		this.connection = new ConexaoBanco().GetConection();
		this.menu = new Menu();
	}
	
	public void InserirRegistro(Cliente c)  throws ClassNotFoundException, SQLException{
		
		String sql;
		ConexaoBanco conn = new ConexaoBanco();			
		
		sql = "INSERT INTO contato (nome,telefone) " +
				"VALUES ('"+c.getNome()+"','"+c.getTelefone()+"')";				
		conn.ConectarBanco(sql, 1);		
		conn.FechaConexao();
		System.out.println("Registro inserido com sucesso.\n\n");
		menu.BoasVindas();
	}
	
		
	//3-deleta pelo numero de telefone	Funcionando	
	public void DeletaFone(String numeroFOne) throws ClassNotFoundException, SQLException{
		String sql;
		ConexaoBanco conn = new ConexaoBanco();		
		
		sql = "DELETE FROM contato "
				+ "WHERE telefone = '"+numeroFOne+"'";			
		conn.ConectarBanco(sql, 1);		
		conn.FechaConexao();
		
		System.out.println("Contato deletado com sucesso.\n\n");
		menu.BoasVindas();
	}


	// 4- altera por um numero de telefone		funcionando
	public void AlteraPorTelefone(Cliente c) throws ClassNotFoundException{
		
		String sql = "UPDATE contato set nome=?, telefone=?"
				+"WHERE telefone=?";
		try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.QualTelefone());
			
			stmt.execute();
			stmt.close();
			System.out.println("Registro alterado com sucesso.\n\n");
			menu.BoasVindas();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}


	//2-Lista um contato especifico 
	public void ListaContatoEspecifico(String nomeBuscado) throws ClassNotFoundException{
		
		try{			
			PreparedStatement stmt = (PreparedStatement) this.connection.
					prepareStatement("select nome, telefone from contato WHERE nome="+nomeBuscado);
			
			ResultSet rs = stmt.executeQuery();
			
			//if verificando se existe valor encontrado
			if (!rs.isBeforeFirst() ) {    
			    System.out.println("Não foram encontrados registro como "+nomeBuscado +""); 
			    menu.BoasVindas();
			}else{
				while (rs.next()) {				
					  String nome = rs.getString("nome");
					  String telefone = rs.getString("telefone");			  
					  System.out.println(nome + " :: " + telefone);
					}
				rs.close();		
				stmt.close();
				
				menu.BoasVindas();
			}
			
		}catch (SQLException e){
	         throw new RuntimeException(e);
	     }		
	}
	
	//Lista todos os contatos do banco.
	public void ListaTodosContatos() throws ClassNotFoundException
	{
		String sql = "SELECT * FROM contato";		
		try
		{
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");				  
				System.out.println(nome + " :: " + telefone);
			}
			
			System.out.println("\nListagem completa.\n\n");
			rs.close();		
			stmt.close();			
			menu.BoasVindas();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
