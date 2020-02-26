package controller;

import java.io.BufferedReader;

/**
 * Classe para cadastrar cidade
 * 
 * @author vyamane
 * @since 18/02/2020
 * @version 0.1
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

public class CidadeController {
	public void verificaSelecionadoCidade(String cidade) {
		Cidade cidade1 = new Cidade();
		cidade1.setNome(cidade);
		inserirCidade(cidade1);
	}

	// Recebe informações de cadastro da cidade e salva no arquivo txt
	public void inserirCidade(Cidade cidade) {
		File arquivo = new File("cidade.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print("\n");
			gravador.print(cidade.getNome());
			gravador.close();

			JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	// exibe lista de cidade
	public List<Cidade> listarTodos() {
		List<Cidade> arrayList = new ArrayList<Cidade>();
		InputStream is;
		try {
			is = new FileInputStream("cidade.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String cidade = leitor.readLine();
			while (cidade != null) {

				if (cidade.length() > 0) {

					arrayList.add(new Cidade(cidade));
				}
				cidade = leitor.readLine();
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
