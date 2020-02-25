package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView {

	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menu01;
	private JMenu menu02;
	private JMenuItem itemMenu1;
	private JMenuItem itemMenu2;
	private JMenuItem itemMenu3;
	private JMenuItem itemMenu4;
	private JMenuItem itemMenu5;
	private JMenuItem itemMenu6;
	private JPanel painelDaJanela;

	public void iniciaGui() {
		// criar instacias
		janela = new JFrame("Menu");
		barraMenu = new JMenuBar();
		menu01 = new JMenu("Cadastro");
		menu02 = new JMenu("Registro");
		itemMenu1 = new JMenuItem("Aluno");
		itemMenu2 = new JMenuItem("Funcionario");
		itemMenu3 = new JMenuItem("Estado");
		itemMenu4 = new JMenuItem("Cidade");
		itemMenu5 = new JMenuItem("Aluno");
		itemMenu6 = new JMenuItem("Funcionario");
		painelDaJanela = (JPanel) janela.getContentPane();

		// Acrescentar menus na barra de menut
		barraMenu.add(menu01);
		barraMenu.add(menu02);

		// Acrescerntar itens de menu nos menus
		menu01.add(itemMenu1);
		menu01.add(itemMenu2);
		menu01.add(itemMenu3);
		menu01.add(itemMenu4);
		menu02.add(itemMenu5);
		menu02.add(itemMenu6);

		// Configurando ação do item de menu 1
		itemMenu1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new AlunoView().iniciaGui();

			}
		});
		// Configurando ação do item de menu 2
		itemMenu2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new FuncionarioView().iniciaGui();

			}
		});
		
		// Configurando ação do item de menu 3
		itemMenu3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new EstadoView().iniciaGui();

			}
		});
		
		// Configurando ação do item de menu 4
		itemMenu4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new CidadeView().iniciaGui();

			}
		});
		
		// Configurando ação do item de menu 5
		itemMenu5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new RelatorioAlunoView().iniciaGui();

			}
		});


		// Configurações do painel da tela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(barraMenu);

		// Configurações da tela
		janela.setJMenuBar(barraMenu);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(300, 300);
		janela.setVisible(true);

	} // fim metodo

}
