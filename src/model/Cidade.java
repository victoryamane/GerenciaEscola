package model;

/**
 * Classe modelo cidade
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Cidade {

	private String nome;

	public Cidade() {

	}

	public Cidade(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
