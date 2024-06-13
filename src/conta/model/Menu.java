package conta.model;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opc;

		while (true) {
			
		
			System.out.println("****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                          BANCO M7 BRASIL                                ");
			System.out.println("****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                       1 - Criar Conta                                      ");
			System.out.println("                       2 - Listar Todas As Contas                           ");
			System.out.println("                       3 - Buscar Contas por Numeros                        ");
			System.out.println("                       4 - Atualizar Dados da Conta                         ");
			System.out.println("                       5 - Apagar Conta                                     ");
			System.out.println("                       6 - Sacar                                            ");
			System.out.println("                       7 - Depositar                                        ");
			System.out.println("                       8 Transferencia                                      ");
			System.out.println("                       9 - Sair                                             ");
			System.out.println("****************************************************************************");
			System.out.println("  Entre Com a Opção Desejada:                                               ");
			System.out.println("                                                                            ");

			opc = ler.nextInt();

			if (opc == 9) {
				System.out.println("\nBanco M7 Brasil -  A inovação começa aqui !");
				sobre();
				ler.close();
				System.exit(0);

				switch (opc) {
				case 1:
					System.out.println("Criar Conta\n\n");
					break;
				case 2:
					System.out.println("Listar Todas As Contas\n\n");
					break;
				case 3:
					System.out.println("Consultar Dados Da Conta\n\n");
					break;
				case 4:
					System.out.println("Atualizar Dados Da Conta\n\n");
					break;
				case 5:
					System.out.println("Apagar A Conta\n\n");
					break;
				case 6:
					System.out.println("Saque\n\n");
					break;
				case 7:
					System.out.println("Deposito\n\n");
					break;
				case 8:
					System.out.println("Transferencia Entre Contas\n\n");
					break;
				case 9:
					System.out.println("Opção Invalida\n\n");
					break;
				}

			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por Michel Gonçalves : ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

}