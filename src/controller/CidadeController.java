package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import model.Cidade;

/**
 * Classe para cadastrar cidade
 * 
 * @author vyamane
 * @since 18/02/2020
 * @version 0.1
 */

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

			gravador.print(cidade.getNome());
			gravador.print(";");
			gravador.close();
			arquiOutput.close();
			JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
