package model;

/**
 * Classe modelo para cadastrar aluno
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

public class Aluno {
	private String matricula;
	private String nome;
	private Data dataNascimento;
	private char sexo;

	public Aluno() {

	}

	public Aluno(String matricula, String nome, Data dataNascimento, char sexo) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
