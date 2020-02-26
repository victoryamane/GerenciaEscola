package model;

/**
 * Classe modelo para secretaria
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Secretaria extends Funcionario  {
	private int ramal;
	
	public Secretaria() {
		
	}

	public Secretaria(String nome, String cpf, String rg, String dataNascimento, String telefone,
			String endereco, double salario, int ramal) {
		super(2, nome, cpf, rg, dataNascimento, telefone, endereco, salario);
		this.ramal = ramal;
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}	
	
	
	
}
