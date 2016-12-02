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
		System.out.println("****************************************************\n");
		System.out.println("--------------------- Bom dia ----------------------\n");
		System.out.println("****************************************************\n");
		ChamaMenuFuncoes();
	}

	public void ChamaMenuFuncoes() throws ClassNotFoundException, SQLException{
		
		int qualAcao;
		AcoesBanco acoesBanco = new AcoesBanco();
		Cliente novoCliente = new Cliente();
		Scanner lt = new Scanner(in);	
		
		System.out.println("Escolha a opção desejada\n\n1-Para registrar Novo contato\n"
				+ "\n2-Para buscar um contato\n"
				+ "\n3-Para deletar um contato\n"
				+ "\n4-Para alterar os dados de um contato existente.\n"
				+ "\n5-Para listar todos os contatos.\n"
				+ "\n6-Sair do programa\n");
		System.out.println("****************************************************\n");
		qualAcao = lt.nextInt();
		
		switch (qualAcao) {
		case 1:
			novoCliente.setNome();
			novoCliente.setTelefone();
			acoesBanco.InserirRegistro(novoCliente);			
			break;
		case 2:
			String nomeBuscado = novoCliente.pedeNomeParaBusca();
			acoesBanco.ListaContatoEspecifico(nomeBuscado);
			break;
		case 3:
			novoCliente.DeletaNumeroFone();
		case 4:
			novoCliente.AlteraPeloTelefone();
			//String qualTelefone = novoCliente.pedeTelefoneParaBusca();
			acoesBanco.AlteraPorTelefone(novoCliente);
			break;
		case 5:
			acoesBanco.ListaTodosContatos();
			break;
		case 6:
			System.out.println("Programa Finalizado.");
			System.out.println("****************************************************\n");
			System.out.println("--------------------- Até breve --------------------\n");
			System.out.println("****************************************************\n");
			break;
		default:
			break;
		}
	}

}
