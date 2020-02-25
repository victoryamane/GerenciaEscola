package controller;

/**
 * Classe para cadastrar aluno
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;

public class AlunoController {

	public void verificarSelecionado(String nome, String matricula, String sexo, String rg, String cpf, String telefone,
			String dataDeNascimento, String senha, String logradouro, String numero, String complemento, String bairro,
			String cep, String estado, String cidade) {
		int n = 0;
		char sexoTrans = sexo.charAt(0);
		n = Integer.parseInt(numero);
		String[] dataquebrada = dataDeNascimento.split("/");
		int dia = Integer.parseInt(dataquebrada[0]);
		int mes = Integer.parseInt(dataquebrada[1]);
		int ano = Integer.parseInt(dataquebrada[2]);

		Data data = new Data(dia, mes, ano);

		Cidade cidade1 = new Cidade();
		cidade1.setNome(cidade);

		Estado estado1 = new Estado();
		estado1.setNome(estado);
		estado1.setUf(estado);

		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade1);
		endereco.setEstado(estado1);		
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(n);

		Aluno aluno = new Aluno();
		aluno.setCpf(cpf);
		aluno.setDataNascimento(data);
		aluno.setEndereco(endereco);
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRg(rg);
		aluno.setSenha(senha);
		aluno.setSexo(sexoTrans);
		aluno.setTelefone(telefone);

		inserirAluno(aluno);
	}

	// Recebe informações de cadastro do aluno e salva no arquivo txt
	public void inserirAluno(Aluno aluno) {

		File arquivo = new File("aluno.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print(aluno.getMatricula());
			gravador.print(";");
			gravador.print(aluno.getNome());
			gravador.print(";");
			gravador.print(aluno.getDataNascimento().toString());
			gravador.print(";");
			gravador.print(aluno.getSexo());
			gravador.print(";");
			gravador.print(aluno.getCpf());
			gravador.print(";");
			gravador.print(aluno.getRg());
			gravador.print(";");
			gravador.print(aluno.getSenha());
			gravador.print(";");
			gravador.print(aluno.getTelefone());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCep());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getNumero());
			gravador.println("");
			gravador.print(aluno.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.println(aluno.getEndereco().getEstado().getUf());

			gravador.close();
			arquiOutput.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// exibe todos os alunos
	public String listarTodos() {
		String lista = "";
		InputStream is;
		try {
			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {

				String[] dado = texto.split(";");

				lista += "matricula do aluno :" + dado[0] + "\n";
				lista += "nome do aluno :" + dado[1] + "\n";
				lista += "data de nascimento do aluno :" + dado[2] + "\n";
				lista += "Sexo do aluno :" + dado[3] + "\n";
				lista += "CPF do aluno :" + dado[4] + "\n";
				lista += "RG do aluno :" + dado[5] + "\n";
				lista += "Telefone do aluno :" + dado[7] + "\n";
				lista += "Bairro do aluno :" + dado[8] + "\n";
				lista += "CEP do aluno :" + dado[9] + "\n";
				lista += "Logradouro do aluno :" + dado[11] + "\n";
				lista += "complemento :" + dado[10] + "\n";
				lista += "Numero do aluno :" + dado[12] + "\n";
//				lista +="Nome da Cidade  do aluno :" + dado[11] + "\n";
//				lista +="Nome do Estado do aluno :" + dado[12] + "\n";
//				lista +="Sigla do Estado do aluno :" + dado[13] + "\n";

				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("arquivo de entrada nao encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public void listarAniversariantes(int mes) {
		InputStream is;
		try {
			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {

				String dados[] = texto.split(";");
				String data = dados[2];

				String dataQuebrada[] = data.split("/");
				int datac = Integer.parseInt(dataQuebrada[1]);

				if (datac == mes) {
					System.out.println("matricula do aluno :" + dados[0]);
					System.out.println("nome do aluno :" + dados[1]);
					System.out.println("data de nascimento do aluno :" + dados[2]);
					System.out.println("Sexo do aluno :" + dados[3] + "\n");

				}
				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("arquivo de entrada nao encontrado");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}