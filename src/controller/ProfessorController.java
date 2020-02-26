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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;
import model.Professor;

public class ProfessorController {

	public void verificarSelecionado(String nome, String rg, String cpf,
			String telefone, String dataDeNascimento, String logradouro,
			String numero, String complemento, String bairro, String cep,
			String estado, String cidade, String materia, String salario) {
 
		String no = nome.trim();
		String log = logradouro.trim();
		String num = numero.trim();
		String com = complemento.trim();
		String bair = bairro.trim();

		boolean validaData = true;

		int ValiNome = no.length();
		// int ValiMateria= materia.length();

		int ValiRg = rg.length();
		int ValiCpf = cpf.length();
		int ValiTelefone = telefone.length();
		int ValiDataDeNascimento = dataDeNascimento.length();
		int ValiSalario = salario.length();
		int ValiLogradouro = log.length();
		int ValiNumero = num.length();
		int ValiComplemento = com.length();
		int ValiBairro = bair.length();
		int ValiCep = cep.length();
		int ValiEstado = estado.length();
		int ValiCidade = cidade.length();


		if (ValiCidade != 0 && ValiEstado != 0 && ValiCep != 0
				&& ValiBairro != 0 && ValiComplemento != 0 && ValiNumero != 0
				&& ValiLogradouro != 0 && ValiDataDeNascimento != 0
				&& ValiNome != 0 && ValiTelefone != 0 && ValiCpf != 0
				&& ValiRg != 0  ) {

			String[] dataquebrada = dataDeNascimento.split("/");
			int dia = Integer.parseInt(dataquebrada[0]);
			int mes = Integer.parseInt(dataquebrada[1]);
			int ano = Integer.parseInt(dataquebrada[2]);

			if (dia > 31 || dia < 1 || mes < 1 || mes > 12 || ano > 2020
					|| ano < 1800) {
				validaData = false;
			}
			if (mes == 2 && dia > 28) {
				validaData = false;
			}

			if (validaData) {
				System.out.println(numero);
				int n = Integer.parseInt(num);
				

				Data data = new Data(dia, mes, ano);

				Cidade cidade1 = new Cidade();
				cidade1.setNome(cidade);

				Estado estado1 = new Estado();
				String[] estadoQuebrado = estado.split("-");

				estado1.setNome(estadoQuebrado[0]);
			    estado1.setUf(estadoQuebrado[1]);

				Endereco endereco = new Endereco();
				endereco.setBairro(bairro);
				endereco.setCep(cep);
				endereco.setCidade(cidade1);
				endereco.setEstado(estado1);
				endereco.setComplemento(complemento);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(n);

				Professor pl = new Professor();
				pl.setSalario(salario);
				pl.setCpf(cpf);
				pl.setData(data);
				pl.getMateria().add(materia);
				pl.setEndereco(endereco);
				pl.setNome(nome);
				pl.setRg(rg);
				pl.setTelefone(telefone);
				inserirProfessor(pl);

			} else {
				JOptionPane.showMessageDialog(null,
						"data de nascimento incorreta");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Digite todos os campos");
		}
	}

	// receber informaçoes do aluno e salvar no arquivo
	public void inserirProfessor(Professor professor) {

		File arquivo = new File("professor.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print(professor.getSalario());
			gravador.print(";");
			gravador.print(professor.getNome());
			gravador.print(";");
			gravador.print(professor.getData().toString());
			gravador.print(";");
			gravador.print(professor.getMateria());
			gravador.print(";");
			gravador.print(professor.getCpf());
			gravador.print(";");
			gravador.print(professor.getRg());
			gravador.print(";");
			gravador.print(professor.getTelefone());
			gravador.print(";");
			gravador.print(professor.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(professor.getEndereco().getCep());
			gravador.print(";");
			gravador.print(professor.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(professor.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(professor.getEndereco().getNumero());
			gravador.print("");
			gravador.print(professor.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(professor.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.println(professor.getEndereco().getEstado().getUf());

			gravador.close();
			arquiOutput.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public List<Professor> listarTodos() {
		List<Professor> array = new ArrayList<Professor>();

		InputStream is;
		try {
			is = new FileInputStream("professor.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				Professor professor = new Professor();
				String[] dado = texto.split(";");

				String[] data = dado[2].split("/");
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);

				Data d1 = new Data(dia, mes, ano);

				professor.setNome(dado[1]);
				professor.setData(d1);
				professor.setTelefone(dado[6]);
				array.add(professor);

				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("arquivo de entrada nao encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;
	}

}


