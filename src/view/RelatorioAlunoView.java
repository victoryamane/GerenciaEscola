package view;

import java.util.List;

/**
 * Classe da tela do relatorio do aluno
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.AlunoController;

public class RelatorioAlunoView {
	private JFrame janela;
	private JList list;
	private JLabel label;
	private JPanel painelDaJanela;
	private JScrollPane scroll;
	
	AlunoController ac = new AlunoController();
	private List<String> listarTodos = ac.listarTodos();

	public void iniciaGui() {
		// instancia
		janela = new JFrame("Relatorio do Aluno");
		painelDaJanela = (JPanel) janela.getContentPane();
		list = new JList(listarTodos.toArray());
		label = new JLabel();
		scroll = new JScrollPane(list);

		// configura Parametro da lista
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {

				label.setText((String) list.getSelectedValue());

			}
		});

		// configuraçoes do scroll
		scroll.setBounds(10, 60, 300, 90);

		// atributos da label
		label.setOpaque(true);
		label.setBounds(10, 10, 300, 30);

		// configutações do painel
		painelDaJanela.setLayout(null);
		painelDaJanela.add(label);
		painelDaJanela.add(scroll);

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);

	}
	
}