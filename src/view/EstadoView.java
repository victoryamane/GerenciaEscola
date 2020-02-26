package view;

/**
 * Classe da tela de estado
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

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
	private JLabel lblEstado;
	private JLabel lblUf;
	private JTextField campoEstado;
	private JTextField campoUf;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JPanel painelDaJanela;

	public void iniciaGui() {
		// instacia
		janela = new JFrame();
		lblEstado = new JLabel();
		lblUf = new JLabel();
		campoEstado = new JTextField();
		campoUf = new JTextField();
		botaoSalvar = new JButton("Salvar");
		botaoCancelar = new JButton("Cancelar");

		painelDaJanela = (JPanel) janela.getContentPane();

		// Configura��o da label estado
		lblEstado.setText("Estado");
		lblEstado.setBounds(10, 10, 95, 20);

		// Configura��o da label uf
		lblUf.setText("UF");
		lblUf.setBounds(10, 50, 95, 20);

		// Configura��o da campo estado
		campoEstado.setBounds(10, 30, 190, 20);

		// Configura��o da campo uf
		campoUf.setBounds(10, 70, 190, 20);

		// Configura��o do bot�o salvar
		botaoSalvar.setBounds(10, 110, 90, 20);
		botaoSalvar.addActionListener(new SalvarListenerEstado());

		// Configura��o do bot�o cancelar
		botaoCancelar.setBounds(110, 110, 90, 20);
		botaoCancelar.addActionListener(new CancelaListener());

		// Configura��o do painel da janela
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(lblUf);
		painelDaJanela.add(campoEstado);
		painelDaJanela.add(campoUf);
		painelDaJanela.add(botaoSalvar);
		painelDaJanela.add(botaoCancelar);

		// Configura��o da janela
		janela.setTitle("Cadastro de Estado");
		janela.setSize(300, 200);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

	}

	// Fun��o do bot�o salvar
	public class SalvarListenerEstado implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EstadoController ec = new EstadoController();
			ec.verificaSelecionadoEstado(campoEstado.getText(), campoUf.getText());
			campoEstado.setText("");
			campoUf.setText("");
		}
	}

	// Fun��o do bot�o cancelar
	public class CancelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			janela.dispose();
		}
	}

}