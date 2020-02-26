package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Faxineira;
import model.Professor;
import model.Secretaria;
import controller.FaxineiraController;
import controller.ProfessorController;
import controller.SecretariaController;

public class RelatorioFuncionarioView {
	// declaração das variaveis

	private JFrame janela;
	private JTabbedPane painelComAbas;
	private JPanel painelDaJanela;
	private JPanel primeiraAba;
	private JPanel segundaAba;
	private JPanel terceiraAba;

	private JTable tabela;
	private String[] colunas = new String[] { "Nome", "DT.Nascimento", "Telefone" };
	private String[][] dados = new String[][] {};

	private JLabel lblAlunos;

	private JScrollPane painelDeScroll;

	private JTable tabelaFaxineiras;

	private String[][] dadosFaxineiras = new String[][] {};
	private String[][] dadosSecretaria = new String[][] {};

	private JLabel lblFaxineiras;

	private JScrollPane painelDeScrollFaxineiras;

	private JTable tabelaSecretaria;

	private JLabel lblSecretaria;

	private JScrollPane painelDeScrollSecretaria;

	// instancias
	public void iniciaGui() {
		janela = new JFrame("relatorio dos funcionarios");
		painelDaJanela = (JPanel) janela.getContentPane();
		painelComAbas = new JTabbedPane();
		primeiraAba = new JPanel();
		segundaAba = new JPanel();
		terceiraAba = new JPanel();

		painelComAbas.addTab("Professor", primeiraAba);
		painelComAbas.addTab("Faxineiras", segundaAba);
		painelComAbas.addTab("Secretária", terceiraAba);
		painelComAbas.setBounds(20, 10, 345, 330);
		lblAlunos = new JLabel("RELATORIOS DOS PROFESSORES");
		lblFaxineiras = new JLabel("RELATORIO DAS FAXINEIRAS");
		lblSecretaria = new JLabel("RELATORIO DAS SECRETÁRIAS");
		painelDaJanela = (JPanel) janela.getContentPane();

		// criar tabela, ao inves de passar os atributos diretos,
		// iremos colocar em um modelo de dados

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

		tabela = new JTable(modelo);

		tabela.setEnabled(true);

		// instaciando e inserido a tabela no scroll
		painelDeScroll = new JScrollPane(tabela);

		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// configurações do tamanho do componentes da tela

		lblAlunos.setBounds(90, 5, 360, 20);

		painelDeScroll.setBounds(10, 30, 320, 255);

		tabela.setBounds(10, 30, 300, 200);

		// configuraçõe do painel da janela
		adicionaTabelaProfessor();
		primeiraAba.add(lblAlunos);
		primeiraAba.add(painelDeScroll);

		// configurações da janela
		primeiraAba.setLayout(null);
		// 2 Tabela

		DefaultTableModel modelofaxineiras = new DefaultTableModel(dadosFaxineiras, colunas);

		tabelaFaxineiras = new JTable(modelofaxineiras);

		tabelaFaxineiras.setEnabled(true);

		// instaciando e inserido a tabela no scroll
		painelDeScrollFaxineiras = new JScrollPane(tabelaFaxineiras);

		painelDeScrollFaxineiras.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurações do tamanho do componentes da tela

		lblFaxineiras.setBounds(90, 5, 360, 20);

		painelDeScrollFaxineiras.setBounds(10, 30, 320, 255);

		tabelaFaxineiras.setBounds(10, 30, 300, 200);

		// configuraçõe do painel da janela
		adicionaTabelaFaxineira();
		segundaAba.add(lblFaxineiras);
		segundaAba.add(painelDeScrollFaxineiras);

		// configurações da janela
		segundaAba.setLayout(null);

		// 3 Tabela
		DefaultTableModel modeloSecretaria = new DefaultTableModel(dadosSecretaria, colunas);

		tabelaSecretaria = new JTable(modeloSecretaria);

		tabelaSecretaria.setEnabled(true);

		// instaciando e inserido a tabela no scroll
		painelDeScrollSecretaria = new JScrollPane(tabelaSecretaria);

		painelDeScrollSecretaria.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// configurações do tamanho do componentes da tela
		lblSecretaria.setBounds(90, 5, 360, 20);
		painelDeScrollSecretaria.setBounds(10, 30, 320, 255);
		tabelaSecretaria.setBounds(10, 30, 300, 200);

		adicionaTabelaSecretaria();

		terceiraAba.add(lblSecretaria);
		terceiraAba.add(painelDeScrollSecretaria);
		terceiraAba.setLayout(null);
		terceiraAba.add(new JLabel("Esta é terceira aba"));

		painelDaJanela.setLayout(null);
		painelDaJanela.add(painelComAbas);

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public void adicionaTabelaProfessor() {
		ProfessorController ac = new ProfessorController();
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		for (Professor professor : ac.listarTodos()) {
			modelo.addRow(
					new String[] { professor.getNome(), professor.getData().toString(), professor.getTelefone() });
		}
	}

	public void adicionaTabelaSecretaria() {
		SecretariaController ac = new SecretariaController();
		DefaultTableModel modeloSeretaria= (DefaultTableModel) tabelaSecretaria.getModel();
		for (Secretaria secretaria : ac.listarTodos()) {
			modeloSeretaria.addRow(
					new String[] { secretaria.getNome(), secretaria.getData().toString(), secretaria.getTelefone() });
		}
	}

	public void adicionaTabelaFaxineira() {
		FaxineiraController ac = new FaxineiraController();
		DefaultTableModel modeloFaxineira = (DefaultTableModel) tabelaFaxineiras.getModel();
		for (Faxineira faxineira : ac.listarTodos()) {
			modeloFaxineira.addRow(
					new String[] { faxineira.getNome(), faxineira.getData().toString(), faxineira.getTelefone() });
		}
	}
}
