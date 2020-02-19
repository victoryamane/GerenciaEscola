package model;

/**
 * Classe modelo para funcionario
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Funcionario {
	private String nome;
	private String cpf;
	private double salario;

	public Funcionario() {
		System.out.println("Funcionario criado!");

	}

	public Funcionario(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void exibe() {
		System.out.println("Nome do funcionario: " + nome);
		System.out.println("CPF do funcionario: " + cpf);
		System.out.println("Salario do funcionario: " + salario);
	}
}

