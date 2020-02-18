package controller;

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
import model.Data;

public class AlunoController {

	public void inserirAluno(String matricula, String nome, Data data, char sexo) {
		Data d1 = new Data();
		Aluno a1 = new Aluno();
		a1.setMatricula(matricula);
		a1.setNome(nome);
		a1.setDataNascimento(data);
		a1.setSexo(sexo);

//		Aluno a2 = new Aluno();
//		Data data2 = new Data(02, 01, 1995);
//		a2.setMatricula("17101243");
//		a2.setNome("Isabela Souza");
//		a2.setDataNascimento(data2);
//		a2.setSexo('F');
//
//		Aluno a3 = new Aluno();
//		Data data3 = new Data(26, 11, 1991);
//		a3.setMatricula("17101141");
//		a3.setNome("João Paulo");
//		a3.setDataNascimento(data3);
//		a3.setSexo('M');
//
//		Aluno a4 = new Aluno();
//		Data data4 = new Data(9, 06, 1992);
//		a4.setMatricula("17101328");
//		a4.setNome("Rafael Guerreiro");
//		a4.setDataNascimento(data4);
//		a4.setSexo('M');
//
//		Aluno a5 = new Aluno();
//		Data data5 = new Data(01, 04, 1992);
//		a5.setMatricula("17101150");
//		a5.setNome("Rafel Perrucci");
//		a5.setDataNascimento(data5);
//		a5.setSexo('M');

		File arquivo = new File("aluno.txt");
		try {
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			gravador.print("Matricula: " + a1.getMatricula());
			gravador.print(";");
			gravador.print("Nome: " + a1.getNome());
			gravador.print(";");
			gravador.print("Data de nascimento: " + a1.getDataNascimento().toString());
			gravador.print(";");
			gravador.println("Sexo: " + a1.getSexo());

//			gravador.print("Matricula: " + a2.getMatricula());
//			gravador.print(";");
//			gravador.print("Nome: " + a2.getNome());
//			gravador.print(";");
//			gravador.print("Data de nascimento: " + a2.getDataNascimento().toString());
//			gravador.print(";");
//			gravador.println("Sexo: " + a2.getSexo());
//
//			gravador.print("Matricula: " + a3.getMatricula());
//			gravador.print(";");
//			gravador.print("Nome: " + a3.getNome());
//			gravador.print(";");
//			gravador.print("Data de nascimento: " + a3.getDataNascimento().toString());
//			gravador.print(";");
//			gravador.println("Sexo: " + a3.getSexo());
//
//			gravador.print("Matricula: " + a4.getMatricula());
//			gravador.print(";");
//			gravador.print("Nome: " + a4.getNome());
//			gravador.print(";");
//			gravador.print("Data de nascimento: " + a4.getDataNascimento().toString());
//			gravador.print(";");
//			gravador.println("Sexo: " + a4.getSexo());
//
//			gravador.print("Matricula: " + a5.getMatricula());
//			gravador.print(";");
//			gravador.print("Nome: " + a5.getNome());
//			gravador.print(";");
//			gravador.print("Data de nascimento: " + a5.getDataNascimento().toString());
//			gravador.print(";");
//			gravador.println("Sexo: " + a5.getSexo());

			gravador.close();
			arquivoOutput.close();

			System.out.println("Gravação efetuada com sucesso!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listarTodos() {
		try {
			InputStream is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				String dados[] = texto.split(";");

				System.out.println("Matricula do aluno: " + dados[0]);
				System.out.println("Nome do aluno.....: " + dados[1]);
				System.out.println("Data Nasc do aluno: " + dados[2]);
				System.out.println("Sexo do aluno.....: " + dados[3] + "\n");
				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listaAniversariantes(int mes) {
		try {
			InputStream is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {
				String[] dados = texto.split(";");
				String data[] = dados[2].split("/");
				int mesNiver = Integer.parseInt(data[1]);

				if (mesNiver == mes) {
					System.out.println(dados[0]);
					System.out.println(dados[1]);
					System.out.println(dados[2]);
					System.out.println(dados[3]);
				}
				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
