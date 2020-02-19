package model;

/**
 * Classe modelo para professor
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Professor extends Funcionario {
	private String materia;

	public Professor() {
		System.out.println("Professor criado!");

	}

	public Professor(String materia) {
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public void exibe() {
		super.exibe();
		System.out.println("Materia do professor: " + materia);
	}

}
