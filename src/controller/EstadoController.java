package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import model.Estado;

public class EstadoController {
	public void verificaSelecionadoEstado(String estado) {
		Estado estado1 = new Estado();
		estado1.setNome(estado);
		estado1.setUf(estado);
		inserirEstado(estado1);
	}

	// Recebe informações de cadastro do estado e salva no arquivo txt
	public void inserirEstado(Estado estado) {
		File arquivo = new File("estado.txt");

		try {
			FileOutputStream arquiOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquiOutput);

			gravador.print(estado.getUf().toUpperCase());
			gravador.print(";");
			gravador.close();
			arquiOutput.close();
			JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
