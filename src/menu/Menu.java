package menu;

import banco.AcoesBanco;
import cliente.Cliente;

import java.util.Scanner;
import static java.lang.System.in;

import java.sql.SQLException;

public class Menu {

	/*
	 * registra busca por nome deleta por telefone altera nome e numero pelo
	 * numero de telefone
	 */

	public void BoasVindas() throws ClassNotFoundException, SQLException {
		System.out.println("Nós da Focus3d lhes deseja um bom dia");
		ChamaMenuFuncoes();
	}

	public void ChamaMenuFuncoes() throws ClassNotFoundException, SQLException{
		
		int qualAcao;
		AcoesBanco acoesBanco = new AcoesBanco();
		Cliente novoCliente = new Cliente();
		Scanner lt = new Scanner(in);	
		
		System.out.println("Escolhe a opção desejada\n1-Registrar Novo contato"
				+ "\n2-Para buscar um contato e seus dados pelo seu nome"
				+ "\n3-Para deletar um contato"
				+ "\n4-Para alterar os dados de um contato existente."
				+ "\n5-Sair do programa\n\n");
		qualAcao = lt.nextInt();
		
		switch (qualAcao) {
		case 1:
			novoCliente.setNome();
			novoCliente.setTelefone();
			acoesBanco.InserirRegistro(novoCliente);			
			break;
		case 2:
			break;
		case 3:
			novoCliente.DeletaNumeroFone();
		case 4:
			novoCliente.AlteraPeloTelefone();
			acoesBanco.AlteraPorTelefone(novoCliente);
			break;

		default:
			break;
		}
	}

}
