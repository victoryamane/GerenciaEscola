package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CidadeController;

public class CidadeView {
	// Variaveis
	private JFrame janela;
	private JLabel lblCidade;
	private JTextField campoCidade;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JPanel painelDaJanela;

	public void iniciaGui() {
		// instacia
		janela = new JFrame();
		lblCidade = new JLabel();
		campoCidade = new JTextField();
		botaoSalvar = new JButton("Salvar");
		botaoCancelar = new JButton("Cancelar");
		painelDaJanela = (JPanel) janela.getContentPane();

		// Configuração da label cidade
		lblCidade.setText("Cidade");
		lblCidade.setBounds(10, 10, 95, 20);

		// Configuração da campo cidade
		campoCidade.setBounds(10, 30, 190, 20);

		// Configuração do botão salvar
		botaoSalvar.setBounds(10, 70, 90, 20);
		botaoSalvar.addActionListener(new SalvarListener());

		// Configuração do botão cancelar
		botaoCancelar.setBounds(110, 70, 90, 20);
		botaoCancelar.addActionListener(new CancelaListener());

		// Configuração do painel da janela
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(campoCidade);
		painelDaJanela.add(botaoSalvar);
		painelDaJanela.add(botaoCancelar);

		// Configuração da janela
		janela.setTitle("Cadastro de Cidade");
		janela.setSize(300, 150);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

	}

	// Função do botão salvar
	public class SalvarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CidadeController cc = new CidadeController();
			cc.verificaSelecionadoCidade(campoCidade.getText());
		}
	}

	// Função do botão cancelar
	public class CancelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
