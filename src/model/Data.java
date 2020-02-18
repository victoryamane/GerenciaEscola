package model;

/**
 * Classe teste data utilizando get e set
 * @author vyamane
 *@since 17/02/2020
 *@version 0.1
 */

public class Data {
	// Declaração das variaveis
	private int mes;
	private int dia;
	private int ano;

	// construtor sem parametro
	public Data() {
		System.out.println("data criada");

	}

	// construtor com parametro
	public Data(int dia, int mes, int ano) {
		this.mes = mes;
		this.dia = dia;
		this.ano = ano;
	}

	// Getters e Setters
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	

public String toString() {
	// TODO Auto-generated method stub
	return dia + "/" + mes + "/" + ano;
}
}
