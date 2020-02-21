package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.AlunoView.SalvarListener;

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
		
		// Cria o bot�o Salvar
		botaoSalvar.setBounds(170, 430, 100, 40);
		//botaoSalvar.addActionListener(new SalvarListener());
		
		// Configura��o da label cidade
		lblCidade.setText("Cidade");
		lblCidade.setBounds(10, 10, 95, 20);
		
		// Configura��o da campo cidade		
		campoCidade.setBounds(10, 30, 190, 20);
		
		// Configura��o do bot�o salvar
		botaoSalvar.setBounds(10, 70, 90, 20);
		
		// Configura��o do bot�o cancelar
		botaoCancelar.setBounds(110, 70, 90, 20);
		
		// Configura��o do painel da janela
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(campoCidade);
		painelDaJanela.add(botaoSalvar);
		painelDaJanela.add(botaoCancelar);	
		
		
		
		// Configura��o da janela		
		janela.setTitle("Cadastro de Cidade");
		janela.setSize(300, 150);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		
	}
	

}
