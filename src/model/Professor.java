package model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Funcionario {
	private List<String> materia = new ArrayList<String>();

	public Professor() {
	
	}

	public Professor(List<String> materia) {
		super();
		this.materia = materia;
	}

	public List<String> getMateria() {
		return materia;
	}



}