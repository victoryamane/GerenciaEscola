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
import model.Faxineira;
import model.Secretaria;
   public class FaxineiraController {

	public void verificarSelecionado(String nome,  String rg, String cpf, String telefone,
			String dataDeNascimento, String logradouro, String numero, String complemento, String bairro,
			String cep, String estado, String cidade,String turno,String salario) {
		
		
		boolean validaData = true;
	
		try{
			int ValiNome = nome.length();  
		int ValiTurno= turno.length(); 
		
		
		int ValiRg = rg.length(); 
		int ValiCpf = cpf.length(); 
		int ValiTelefone = telefone.length(); 
		int ValiDataDeNascimento = dataDeNascimento.length(); 
		int ValiSalario =salario.length(); 
		int ValiLogradouro = logradouro.length(); 
		int ValiNumero =numero.length(); 
		int ValiComplemento = complemento.length(); 
		int ValiBairro = bairro.length(); 
		int ValiCep = cep.length(); 
		int ValiEstado = estado.length(); 
		int ValiCidade = cidade.length();  
		
		if(ValiCidade != 0 ||ValiEstado != 0 ||ValiCep != 0 ||ValiBairro != 0 ||ValiComplemento != 0 ||
				ValiNumero != 0 ||ValiLogradouro != 0 ||ValiDataDeNascimento != 0 ||ValiNome != 0 ||
				ValiTelefone != 0 ||ValiCpf != 0 ||ValiRg != 0 ||ValiSalario != 0 ||ValiTurno != 0 ){
		   
			
			
			
			
			String[] dataquebrada = dataDeNascimento.split("/");
			int dia = Integer.parseInt(dataquebrada[0]);
			int mes = Integer.parseInt(dataquebrada[1]);
			int ano = Integer.parseInt(dataquebrada[2]);
			
	      if(dia > 31 || dia< 1|| mes <1 || mes>12 || ano > 2020 || ano < 1800){
	    	  validaData = false;
	      }
	      if(mes == 2 && dia > 28){
	    	  validaData = false;
	      }
	      
	      if(validaData){
		
		int n = 0;
		
		n = Integer.parseInt(numero);
		
		

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

		Faxineira fl = new Faxineira();
		fl.setSalario(salario);
		fl.setCpf(cpf);
		fl.setData(data);
		fl.setEndereco(endereco);
	    fl.setNome(nome);
		fl.setRg(rg);
		fl.setTelefone(telefone);
		fl.setTurno(turno);
		inserirFaxineira(fl);

	      }else{
	    	  JOptionPane.showMessageDialog(null,"data de nascimento incorreta");
	    	  
	      }}else{
	    	  JOptionPane.showMessageDialog(null,"Digite todos os campos");
	      }}catch(java.lang.NumberFormatException e){
	    	  JOptionPane.showMessageDialog(null,"Digite todos os campos");
	      }
	}
	// receber informaçoes do aluno e salvar no arquivo
	public void inserirFaxineira(Faxineira faxineira) {

		File arquivo = new File("faxineira.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print(faxineira.getSalario());
			gravador.print(";");
			gravador.print(faxineira.getNome());
			gravador.print(";");
			gravador.print(faxineira.getData().toString());
			gravador.print(";");
			gravador.print(faxineira.getTurno());
			gravador.print(";");
			gravador.print(faxineira.getCpf());
			gravador.print(";");
			gravador.print(faxineira.getRg());
			gravador.print(";");
			gravador.print(faxineira.getTelefone());
			gravador.print(";");
			gravador.print(faxineira.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(faxineira.getEndereco().getCep());
			gravador.print(";");
			gravador.print(faxineira.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(faxineira.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(faxineira.getEndereco().getNumero());
			gravador.print("");
			gravador.print(faxineira.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(faxineira.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.println(faxineira.getEndereco().getEstado().getUf());

			gravador.close();
			arquiOutput.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	
	}
	
	public List<Faxineira> listarTodos() {
		List<Faxineira> array = new ArrayList<Faxineira>();

		InputStream is;
		try {
			is = new FileInputStream("faxineira.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				Faxineira faxineira = new Faxineira();
				String[] dado = texto.split(";");

				String[] data = dado[2].split("/");
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);

				Data d1 = new Data(dia, mes, ano);

				faxineira.setNome(dado[1]);
				faxineira.setData(d1);
				faxineira.setTelefone(dado[6]);
				array.add(faxineira);

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