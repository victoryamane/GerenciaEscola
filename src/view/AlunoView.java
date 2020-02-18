package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AlunoView {
	// Declarar os componentes da tela
	private JFrame janela;
	private JButton botao1;
	private JButton botao2;
	private JTextField campo1;
	private JTextField campo2;
	private JTextField campo3;
	private JTextField campo4;	
	
	public AlunoView() {
		
	}
	public void iniciaGui() {
		// Cria a janela
		janela = new JFrame();
		// Cria o botão 1
		botao1 = new JButton("Salvar");
		botao1.setBounds(10, 10, 100, 20);
		// Cria o botão 2
		botao2 = new JButton("Cancelar");
		botao2.setBounds(10, 10, 100, 20);
		
		// Definir o componente JLabel de rotulo
		JLabel lblMatricula = new JLabel();
		lblMatricula.setText("Matricula: ");
		lblMatricula.setBounds(10, 40, 40, 20);
		JLabel lblNome = new JLabel();
		lblNome.setText("Nome: ");
		lblNome.setBounds(10, 40, 40, 20);
		JLabel lblDataNascimento = new JLabel();
		lblDataNascimento.setText("Data de nascimento: ");
		lblDataNascimento.setBounds(10, 40, 40, 20);
		JLabel lblSexo = new JLabel();
		lblSexo.setText("Data de nascimento: ");
		lblSexo.setBounds(10, 40, 40, 20);		
		
		
		
		// Cria um campo para digitar texto
		campo1 = new JTextField();
		campo2 = new JTextField();
		campo3 = new JTextField();
		campo4 = new JTextField();
		
		




		
	}
	
	
	
	public class SalvarListener implements ActionListener{

		
		
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	
	

}
