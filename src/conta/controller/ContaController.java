package conta.controller;
import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private ArrayList<Conta> listaConta = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void proucurarPorNumero(int numero) {
		
		
	}

	@Override
	public void listaTodas() {
	
		
	}

	@Override
	public void cadastrar(Conta conta) {
		
		
	}

	@Override
	public void atualizar(Conta conta) {
	
		
	}

	@Override
	public void deletar(int numero) {
		
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		
	}

}
