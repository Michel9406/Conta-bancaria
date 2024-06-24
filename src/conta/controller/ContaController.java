package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaConta = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void proucurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA conta numero: " + numero + " Não foi encontrada!");
	}

	@Override
	public void listaTodas() {
		for (var conta : listaConta) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaConta.add(conta);
		System.out.println("\nA Conta numero: " + conta.getNumero() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());

		if (buscarConta != null) {
			listaConta.set(listaConta.indexOf(buscarConta), conta);
			System.out.println("\nA Conta Numero " + conta.getNumero() + "foi atualizada com sucesso ! !");

		} else
			System.out.println("\nA Conta Numero " + conta.getNumero() + "não foi encontrada ! ");

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaConta.remove(conta) == true)
				System.out.println("\nA conta:" + numero + " não foi encontrada ! ");
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {

			if (conta.sacar(valor) == true)
				System.out.println("\nO saque na conta numero: " + numero + " foi efetuado com sucesso !");

		} else
			System.out.println("\nA conta numero: " + numero + " não foi encontrada !");

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			if (conta.sacar(valor) == true)
				System.out.println("\nO Deposito na conta numero: " + numero + " foi efetuado com sucesso !");

		} else
			System.out.println("\nA conta numero: " + numero
					+ " não foi encontrada ou a conta destino não é uma conta corrente !");

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {

			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\n Transferencia foi efetuada com sucesso !");
			}

		} else
			System.out.println("\n A conta de Origem ou destino não foi encontrada !");
	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaConta) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}
}
