package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EstadoController;

public class EstadoView {
	// Variaveis
	private JFrame janela;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JTextField campoCidade;
	private JTextField campoEstado;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JPanel painelDaJanela;

	public void iniciaGui() {
		// instacia
		janela = new JFrame();
		lblCidade = new JLabel();
		lblEstado = new JLabel();
		campoCidade = new JTextField();
		campoEstado = new JTextField();
		botaoSalvar = new JButton("Salvar");
		botaoCancelar = new JButton("Cancelar");

		painelDaJanela = (JPanel) janela.getContentPane();

		// Configuração da label cidade
		lblCidade.setText("Cidade");
		lblCidade.setBounds(10, 10, 95, 20);

		// Configuração da label estado
		lblEstado.setText("Estado");
		lblEstado.setBounds(10, 50, 95, 20);

		// Configuração da campo cidade
		campoCidade.setBounds(10, 30, 190, 20);

		// Configuração da campo estado
		campoEstado.setBounds(10, 70, 190, 20);

		// Configuração do botão salvar
		botaoSalvar.setBounds(10, 110, 90, 20);
		botaoSalvar.addActionListener(new SalvarListenerEstado());

		// Configuração do botão cancelar
		botaoCancelar.setBounds(110, 110, 90, 20);
		botaoCancelar.addActionListener(new CancelaListener());

		// Configuração do painel da janela
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(campoCidade);
		painelDaJanela.add(campoEstado);
		painelDaJanela.add(botaoSalvar);
		painelDaJanela.add(botaoCancelar);

		// Configuração da janela
		janela.setTitle("Cadastro de Estado");
		janela.setSize(300, 200);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

	}

	// Função do botão salvar
	public class SalvarListenerEstado implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EstadoController ec = new EstadoController();
			ec.verificaSelecionadoEstado(campoCidade.getText());
			ec.verificaSelecionadoEstado(campoEstado.getText());
			campoEstado.setText(" ");
		}
	}

	// Função do botão cancelar
	public class CancelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}