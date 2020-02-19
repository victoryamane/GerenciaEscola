package controller;

/**
 * Classe para testar professor
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import model.Professor;

public class ProfessorController {

	public void testaProfessor() {
		Professor p1 = new Professor();
		p1.setNome("Diego");
		p1.setCpf("401.519.008/75");
		p1.setSalario(150000);
		p1.setMateria("Java");
		p1.exibe();

	}

}
