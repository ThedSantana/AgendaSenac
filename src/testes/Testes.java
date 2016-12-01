package testes;

import static java.lang.System.in;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import banco.AcoesBanco;
import banco.ConexaoBanco;
import cliente.Cliente;
import menu.*;
public class Testes {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean  continuar = true;
		Scanner lt = new Scanner(in);
		Cliente c = new Cliente();
		Menu menu = new Menu();
		AcoesBanco acoes = new AcoesBanco();

		
/*		while(continuar){			
			c.setNome();
			c.setTelefone();		
			
			
			acoes.InserirRegistro(c);
			
			System.out.println("Você deseja inserir outro Usuário: ");
			
			continuar = lt.nextBoolean();
		}*/
		
		//funcionando alterar nome de registro
		//acoes.updateRegistroNome(5, "Teddy Rukspi");
		
		//nao funcionando
		//acoes.updateRegistroCompleto(4, c.alteraNomeBanco(), c.alteraTelefoneBanco());
		
		
		//Deletando pelo numero do fone		FUncionando
		//c.DeletaNumeroFone();
		
	
		//c.AlteraPeloTelefone();
		//acoes.AlteraPorTelefone(c);
		
		
		//testes menu
		menu.BoasVindas();
	}
}
