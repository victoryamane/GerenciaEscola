package model;

/**
 * Classe modelo para faxineira
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Faxineira extends Funcionario {
	private String turno;
	
	public Faxineira() {
		
	}

	public Faxineira(String nome, String cpf, String rg, String dataNascimento, String telefone,
			String endereco, double salario, String turno) {
		super(3, nome, cpf, rg, dataNascimento, telefone, endereco, salario);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}