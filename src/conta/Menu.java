package conta;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1, 123, 1, "Geovanna", 1000.0f);
		c1.visualizar();
		c1.sacar(1200.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		Scanner ler = new Scanner(System.in);

		int opc;

		while (true) {

			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND
           + "****************************************************************************");

			System.out.println("****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                          BANCO M7 BRASIL                                   ");
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
			System.out.println("                 Entre Com a Opção Desejada:                                ");
			System.out.println("                                                                            ");

			opc = ler.nextInt();

			if (opc == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nBanco M7 Brasil -  A inovação começa aqui !");
				sobre();
				ler.close();
				System.exit(0);

				switch (opc) {
				case 1:
					System.out.println("Criar Conta\n\n");
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Listar Todas As Contas\n\n");
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Consultar Dados Da Conta\n\n");
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar Dados Da Conta\n\n");
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Apagar A Conta\n\n");
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Saque\n\n");
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Deposito\n\n");
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD +"Transferencia Entre Contas\n\n");
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD +"\nOpção Invalida\n");
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