package view;

/**
 * Classe tela para cadastrar aluno
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AlunoController;
import model.Data;

public class AlunoView {
	// Declarar os componentes da tela
	private JFrame janela;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JTextField campoMatricula;
	private JTextField campoNome;
	private JTextField campoDataNascimento;
	private JTextField campoSexo;
	private JLabel lblSexo;
	private JLabel lblMatricula;
	private JLabel lblNome;
	private JLabel lblDataNascimento;

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
		botaoCancelar.addActionListener(new CancelaListener());

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
		public void actionPerformed(ActionEvent arg0) {

			AlunoController aluno = new AlunoController();
			boolean validacao = true;

			try {

				// Tratando espaços vazios
				String espacoVazioMatricula = campoMatricula.getText();
				String espacoVazioNome = campoNome.getText();
				String espacoVazioSexo = campoSexo.getText();

				espacoVazioMatricula = espacoVazioMatricula.replace(" ", "");
				espacoVazioNome = espacoVazioNome.replace(" ", "");
				espacoVazioSexo = espacoVazioSexo.replace(" ", "");
				
				int contCampoMatricula = espacoVazioMatricula.length();
				int contCampoNome = espacoVazioNome.length();
				int contCampoSexo = espacoVazioSexo.length();

				// Tratando data
				String[] data = campoDataNascimento.getText().split("/");
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				Data dataNascimento = new Data(dia, mes, ano);
				int anoAtual = Integer.parseInt(
						new java.text.SimpleDateFormat("yyyy").format(new java.util.Date(System.currentTimeMillis())));

				// Tratando char
				String converte = campoSexo.getText().toUpperCase();
				char converteSexo = converte.charAt(0);

				//Verifica espaços vazios
				
				if (contCampoMatricula != 0) {
					validacao = false;
				}
				
				if (contCampoNome != 0) {
					validacao = false;
				}
				
				if (contCampoSexo == 1) {
					validacao = true;
				}				
				
				// Verifica mes de fevereiro
				if ((mes == 2) && (dia > 28)) {
					validacao = false;
				}
				// Verifica data
				if ((dia > 31) || (dia < 1) || (mes < 1) || (mes > 12) || (ano > anoAtual) || (ano < 1800)) {
					validacao = false;
				}

				// Verifica sexo
				if (converteSexo != 'M' && converteSexo != 'F') {
					validacao = false;
				}

				// Validação
				if (validacao) {
					aluno.inserirAluno(campoMatricula.getText(), campoNome.getText(), dataNascimento, converteSexo);
					JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Favor verificar se todos os campos foram preechidos corretamente", "", 0);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Favor digitar uma data valida", "", 0);
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Favor digitar a data no formato dd/mm/aaaa", "", 0);
			} catch (java.lang.StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Favor digitar o sexo M ou F", "", 0);
			}

			// Limpa campos
			campoMatricula.setText("");
			campoNome.setText("");
			campoDataNascimento.setText("");
			campoSexo.setText("");
		}

	}

	// Função do botão cancelar
	public class CancelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			janela.setVisible(false);
		}
	}
}
