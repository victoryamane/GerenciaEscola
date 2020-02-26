package controller;

import java.io.BufferedReader;

/**
 * Classe para cadastrar o estado
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

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
import model.Estado;

public class EstadoController {
	public void verificaSelecionadoEstado(String nome, String uf) {
		Estado estado1 = new Estado();
		estado1.setNome(nome);
		estado1.setUf(uf);
		inserirEstado(estado1);
	}

	// Recebe informações de cadastro do estado e salva no arquivo txt
	public void inserirEstado(Estado estado) {
		File arquivo = new File("estado.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print("\n");
			gravador.print(estado.getNome().toUpperCase());
			gravador.print(";");
			gravador.print(estado.getUf().toUpperCase());
			gravador.close();
			
			JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	public List<Estado> listarTodos() {
		List<Estado> arrayList = new ArrayList<Estado>();
		InputStream is;
		try {
			is = new FileInputStream("estado.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				String[] dado = texto.split(";");
				
				if(dado.length >= 2) {
					String nome = dado[0];
					String uf = dado[1];
					Estado estado = new Estado(nome, uf);
										
					arrayList.add(estado);					
				}
				texto = leitor.readLine();
			}
			leitor.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

}
