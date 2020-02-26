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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;

public class AlunoController {

	public void verificarSelecionado(String nome, String matricula, String sexo, String rg, String cpf, String telefone,
			String dataDeNascimento, String senha, String logradouro, String numero, String complemento, String bairro,
			String cep, Estado estado, Cidade cidade) {
		int n = 0;
		char sexoTrans = sexo.charAt(0);
		n = Integer.parseInt(numero);
		String[] dataquebrada = dataDeNascimento.split("/");
		int dia = Integer.parseInt(dataquebrada[0]);
		int mes = Integer.parseInt(dataquebrada[1]);
		int ano = Integer.parseInt(dataquebrada[2]);

		Data data = new Data(dia, mes, ano);

		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
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

			gravador.print("\n");
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
			gravador.print(aluno.getTelefone());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCep());			
			gravador.print(";");
			gravador.print(aluno.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getLogradouro());			
			gravador.print(";");
			gravador.print(aluno.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getNumero());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCidade().getNome());
			gravador.print(";");			
			gravador.print(aluno.getEndereco().getEstado().getUf());	

			gravador.close();
			
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} 
	}

	// exibe relatorio de alunos
	public List<String> listarTodos() {
		List<String> arrayList = new ArrayList<String>();
		InputStream is;
		try {
			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				String[] dado = texto.split(";");
				
				if(dado.length >= 4) {
					String aluno = "";
					aluno += "Matricula: " + dado[0] + ", ";
					aluno += "Nome: " + dado[1] + ", ";
					aluno += "Data de Nascimento: " + dado[2] + ", ";
					aluno += "Sexo: " + dado[3];										
					arrayList.add(aluno);					
				}
				texto = leitor.readLine();
			}
			leitor.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquio não encotrado");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arrayList;
	}
}