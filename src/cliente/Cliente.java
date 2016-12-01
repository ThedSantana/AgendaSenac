package cliente;
import banco.AcoesBanco;
import java.util.Scanner;
import static java.lang.System.in;

import java.sql.SQLException;
public class Cliente {
	
	String nome;
	String telefone;
	
	Scanner lt = new Scanner(in);
	
	public String getNome() {
		
		return nome;
	}
	public void setNome() {
		System.out.println("Digite novo contato: ");
		this.nome = lt.nextLine();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone() {
		System.out.println("Digite Telefone: ");
		this.telefone = lt.nextLine();
	}
	
	public String alteraNomeBanco(){	
		System.out.println("Digite o novo nome: ");
		return lt.nextLine();
	}
	
	public String alteraTelefoneBanco(){
		System.out.println("Digite o novo nome: ");
		return lt.nextLine();
	}
	
	public void DeletaNumeroFone() throws ClassNotFoundException, SQLException{
		String numeroFOne;
		System.out.println("Digite numero de telefone a ser deletado: ");
		
		numeroFOne = lt.nextLine();
		AcoesBanco acao = new AcoesBanco();
		acao.DeletaFone(numeroFOne);
		
	}
	
	public String AlteraPeloTelefone(){
		setNome();
		setTelefone();
		return telefone;
	}
	
	public String QualTelefone(){
		String telefone;
		System.out.println("Digite o telefone do contato que deseja alterar: ");
		telefone = lt.nextLine();
		return telefone;
	}
}
