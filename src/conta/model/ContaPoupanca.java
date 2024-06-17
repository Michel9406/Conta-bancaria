package conta.model;

public class ContaPoupanca extends Conta {
	private int aniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {

	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversario da Conta" + this.aniversario);

	}
}
