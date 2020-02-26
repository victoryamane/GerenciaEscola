package model;

/**
 * Classe modelo para professor
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Professor extends Funcionario {
	private String[] materia;
	
	public Professor() {
		
	}

	public Professor(String nome, String cpf, String rg, String dataNascimento, String telefone,
			String endereco, double salario, String[] materia) {
		super(1, nome, cpf, rg, dataNascimento, telefone, endereco, salario);
		this.materia = materia;
	}

	public String[] getMateria() {
		return materia;
	}

	public void setMateria(String[] materia) {
		this.materia = materia;
	}

	
}
