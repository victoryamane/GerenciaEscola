package view;

/**
 * Classe tela cadastra aluno
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AlunoController;
import model.Aluno;
import model.Data;

public class AlunoView {
	// Declarar os componentes da tela
	private static JFrame janela;
	private static JButton botaoSalvar;
	private static JButton botaoCancelar;
	private static JTextField campoMatricula;
	private static JTextField campoNome;
	private static JTextField campoDataNascimento;
	private static JTextField campoSexo;
	private static JLabel lblSexo;
	private static JLabel lblMatricula;
	private static JLabel lblNome;
	private static JLabel lblDataNascimento;

	public AlunoView() {
		iniciaGui();
	}

	public void iniciaGui() {

		// Cria a janela
		janela = new JFrame();
		janela.setTitle("Cadastro de Aluno");
		janela.setSize(500, 300);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);

		// Cria o botão Salvar
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(150, 135, 100, 20);
		botaoSalvar.addActionListener(new SalvarListener());
		// Cria o botão Cancelar
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(260, 135, 100, 20);

		// Definir o componente JLabel de rotulo
		lblMatricula = new JLabel();
		lblMatricula.setText("Matricula:");
		lblMatricula.setBounds(10, 15, 95, 20);
		lblNome = new JLabel();
		lblNome.setText("Nome:");
		lblNome.setBounds(10, 45, 95, 20);
		lblDataNascimento = new JLabel();
		lblDataNascimento.setText("Dt. nascimento:");
		lblDataNascimento.setBounds(10, 75, 95, 20);
		lblSexo = new JLabel();
		lblSexo.setText("Sexo:");
		lblSexo.setBounds(10, 105, 95, 20);

		// Cria um campo para digitar texto
		campoMatricula = new JTextField();
		campoMatricula.setBounds(110, 15, 350, 20);
		campoNome = new JTextField();
		campoNome.setBounds(110, 45, 350, 20);
		campoDataNascimento = new JTextField();
		campoDataNascimento.setBounds(110, 75, 350, 20);
		campoSexo = new JTextField();
		campoSexo.setBounds(110, 105, 350, 20);

		// Adicionar os componentes na tela
		janela.getContentPane().add(botaoSalvar);
		janela.getContentPane().add(botaoCancelar);
		janela.getContentPane().add(campoMatricula);
		janela.getContentPane().add(campoNome);
		janela.getContentPane().add(campoDataNascimento);
		janela.getContentPane().add(campoSexo);
		janela.getContentPane().add(lblMatricula);
		janela.getContentPane().add(lblNome);
		janela.getContentPane().add(lblDataNascimento);
		janela.getContentPane().add(lblSexo);
		janela.setVisible(true);

	}

	// Salva o aluno
	public class SalvarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AlunoController aluno = new AlunoController();
			String[] data = campoDataNascimento.getText().split("/");
			try {
				// Tratando data
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				Data dataNascimento = new Data(dia, mes, ano);
				// Tratando char
				String converte = campoSexo.getText();
				char converteSexo = converte.charAt(0);

				if (converteSexo == 'M' || converteSexo == 'F') {

					aluno.inserirAluno(campoMatricula.getText(), campoNome.getText(), dataNascimento, converteSexo);
					JOptionPane.showMessageDialog (null, "Cadastro efetuado com sucesso!");
					
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Favor digitar numeros para datas");
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Favor digitar a data no formato dd/mm/aaaa");
			} catch (java.lang.StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Favor digitar o sexo M ou F");
			}
		}

	}

}
