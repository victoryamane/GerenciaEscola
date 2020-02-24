package model;

/**
 * Classe modelo para professor
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Professor {
	private String[] materia;
	
	public Professor() {
		
	}

	public Professor(String[] materia) {
		super();
		this.materia = materia;
	}

	public String[] getMateria() {
		return materia;
	}

	public void setMateria(String[] materia) {
		this.materia = materia;
	}

	
}
