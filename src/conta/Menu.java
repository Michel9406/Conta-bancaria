package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestinto;
		String titular;
		float saldo, limite, valor;

		int opc = 0;

		while (true) {

			System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO M7 Do BRASIL                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("          Entre com a opção desejada:                ");
			System.out.println("                                                     ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opc = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opc = 0;
			}

			if (opc == 9) {
				System.out.println("\nBanco M7 Do Brasil - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			int numeroDestino;
			switch (opc) {
			case 1:
				System.out.println(Cores.TEXT_GREEN + "\n Criar Conta");
				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

				}
				case 2 -> {
					System.out.println("Digite o Aniverssario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}
				keyPress();
				break;
			case 2:
				System.out.println("\n Listar todas as Contas");
				contas.listaTodas();
				keyPress();
				break;
			case 3:
				System.out.println("\nConsulatr dados da Conta por número");

				System.out.println("Digite o numero da Conta:");
				numero = leia.nextInt();

				contas.proucurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("\n Atualizar dados da Conta");

				System.out.println("Digite o numero da conta");
				numero = leia.nextInt();

				var buscarConta = contas.buscarNaCollection(numero);

				if (buscarConta != null) {

					tipo = buscarConta.getTipo();

					System.out.println(" Digite o numero da agência");
					agencia = leia.nextInt();
					System.out.println("Digite nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de Credito (R$): ");
						limite = leia.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));

					}
					case 2 -> {
						System.out.println("Digite o aniversario da conta: ");
						aniversario = leia.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));

					}
					default -> {
						System.out.println(Cores.TEXT_RED + "Tipo de conta INVALIDO !! ");
					}

					}

				} else {
					System.out.println(Cores.TEXT_RED + "A conta não foi encontrada !");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_RED + "\n Apagar Conta");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
				
			case 6:
				System.out.println("\n Saque");
				
				System.out.println("\n Digite o numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				
				}while(valor <= 0);
				
				contas.sacar(numero, valor);
				

				keyPress();
				break;
				
			case 7:
				System.out.println("\n Depositar");

				System.out.println("\n Digite o numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do deposito (R$): ");
					valor = leia.nextFloat();
				
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
				
			case 8:
				System.out.println("\n Transferir");
				System.out.println("\n Digite o numero da conta de origem: ");
				numero = leia.nextInt();				
				System.out.println("\n Digite o numero da conta destino: ");
				numeroDestino = leia.nextInt();
					
				
				do {
					System.out.println("Digite o valor da transferencia (R$): ");
					valor = leia.nextFloat();
				
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
				
			default:
				System.out.println(Cores.TEXT_RED + "\nOpção Inválida" + Cores.TEXT_RESET);

				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN + "\n*********************************************************");
		System.out.println("Projeto Desenvolvido por Michel Gonçalves : ");
		System.out.println("MICHEL GONÇALVES - MICHEL9406@HOTMAIL.COM ");
		System.out.println("github.com/michel9406 ");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println(Cores.TEXT_RED + "Você pressionou uma tecla diferente de enter!");

		}
	}
}