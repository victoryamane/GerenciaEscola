package model;

/**
 * Classe modelo para funcionario
 * 
 * @author vyamane
 * @since 18/02/2020
 * @version 0.1
 */

public class Funcionario {
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String telefone;
	private String endereco;
	private double salario;

	Funcionario() {

	}

	public Funcionario(int id, String nome, String cpf, String rg, String dataNascimento, String telefone,
			String endereco, double salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

//	public void exibe() {
//		System.out.println("Nome do funcionario: " + nome);
//		System.out.println("CPF do funcionario: " + cpf);
//		System.out.println("Salario do funcionario: " + salario);
//	}
}
