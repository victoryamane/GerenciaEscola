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

import model.Secretaria;

public class SecretariaController {

	public void verificarSelecionado(String nome, String rg, String cpf, String telefone, String dataDeNascimento,
			String logradouro, String numero, String complemento, String bairro, String cep, String estado,
			String cidade, String ramal, String salario) {

		boolean validaData = true;

		int ValiNome = nome.length();
		int ValiRamal = ramal.length();
		int ValiRg = rg.length();
		int ValiCpf = cpf.length();
		int ValiTelefone = telefone.length();
		int ValiDataDeNascimento = dataDeNascimento.length();
		int ValiSalario = salario.length();
		int ValiLogradouro = logradouro.length();
		int ValiNumero = numero.length();
		int ValiComplemento = complemento.length();
		int ValiBairro = bairro.length();
		int ValiCep = cep.length();
		int ValiEstado = estado.length();
		int ValiCidade = cidade.length();

		if (ValiCep != 0 && ValiBairro != 0 && ValiComplemento != 0 && ValiNumero != 0 && ValiLogradouro != 0
				&& ValiDataDeNascimento != 0 && ValiNome != 0 && ValiTelefone != 0 && ValiCpf != 0 && ValiRg != 0
				&& ValiSalario != 0 && ValiRamal != 0) {

			String[] dataquebrada = dataDeNascimento.split("/");
			int dia = Integer.parseInt(dataquebrada[0]);
			int mes = Integer.parseInt(dataquebrada[1]);
			int ano = Integer.parseInt(dataquebrada[2]);

			if (dia > 31 && dia < 1 && mes < 1 && mes > 12 && ano > 2020 && ano < 1800) {
				validaData = false;
			}
			if (mes == 2 && dia > 28) {
				validaData = false;
			}

			if (validaData) {

				int n = 0;

				n = Integer.parseInt(numero);

				int ramalTrans = Integer.parseInt(ramal);

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
				endereco.setEstado(estado1);
				endereco.setCidade(cidade1);
				endereco.setComplemento(complemento);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(n);

				Secretaria sl = new Secretaria();
				sl.setSalario(salario);
				sl.setCpf(cpf);
				sl.setData(data);
				sl.setEndereco(endereco);
				sl.setNome(nome);
				sl.setRg(rg);
				sl.setTelefone(telefone);
				sl.setRamal(ramalTrans);
				inserirSecretaria(sl);

			} else {
				JOptionPane.showMessageDialog(null, "data de nascimento incorreta");

			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite todos os campos");
		}
	}

	// receber informaçoes do aluno e salvar no arquivo
	public void inserirSecretaria(Secretaria secretaria) {

		File arquivo = new File("secretaria.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print(secretaria.getSalario());
			gravador.print(";");
			gravador.print(secretaria.getNome());
			gravador.print(";");
			gravador.print(secretaria.getData().toString());
			gravador.print(";");
			gravador.print(secretaria.getRamal());
			gravador.print(";");
			gravador.print(secretaria.getCpf());
			gravador.print(";");
			gravador.print(secretaria.getRg());
			gravador.print(";");
			gravador.print(secretaria.getTelefone());
			gravador.print(";");
			gravador.print(secretaria.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(secretaria.getEndereco().getCep());
			gravador.print(";");
			gravador.print(secretaria.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(secretaria.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(secretaria.getEndereco().getNumero());
			gravador.print("");
			gravador.print(secretaria.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(secretaria.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.println(secretaria.getEndereco().getEstado().getUf());

			gravador.close();
			arquiOutput.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public List<Secretaria> listarTodos() {
		List<Secretaria> array = new ArrayList<Secretaria>();

		InputStream is;
		try {
			is = new FileInputStream("secretaria.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				Secretaria secretaria = new Secretaria();
				String[] dado3 = texto.split(";");

				String[] dataL = dado3[2].split("/");
				int dia = Integer.parseInt(dataL[0]);
				int mes = Integer.parseInt(dataL[1]);
				int ano = Integer.parseInt(dataL[2]);

				Data d1 = new Data(dia, mes, ano);

				secretaria.setNome(dado3[1]);
				secretaria.setData(d1);
				secretaria.setTelefone(dado3[6]);
				array.add(secretaria);

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
