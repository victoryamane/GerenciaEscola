package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.CidadeController;
import controller.EstadoController;
import controller.FaxineiraController;
import controller.ProfessorController;
import controller.SecretariaController;
import model.Cidade;
import model.Estado;

public class FuncionarioView {
	private JFrame janela;

	private JLabel lblNome;
	private JLabel lblDataNascimento;
	private JLabel lblRg;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblSenha;
	private JLabel lblSexo;
	private JLabel lblRamal;
	private JLabel lblTurno;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblSalario;
	private JLabel lblProfissao;
	private JLabel lblMateria;

	private JTextField campoLogradouro;
	private JTextField campoNumero;
	private JTextField campoComplemento;
	private JTextField campoBairro;
	private JTextField campoCep;

	private JButton btnSalvarProfissao;
	private JButton btnSalvar;
	private JButton btnCancelar;

	private JTextField campoTelefone;
	private JTextField campoNome;

	private JTextField campoDataNascimento;
	private JTextField campoRg;
	private JTextField campoCpf;
	private JTextField campoSalario;
	private JTextField campoRamal;

	private JComboBox cboxEstado;
	private JComboBox cboxCidade;
	private JComboBox Profissao;

	// Tabela
	private JTable tabela;
	private JTextField jtfMateria;
	private JButton botaoIncluir;
	private JButton botaoExcluir;
	private JScrollPane painelDeScroll;
	private String[] colunas = new String[] { "Materia" };

	private String[] dados = new String[] { " " };
	private String[] ProfissaoBox = { "Professor", "Faxineira", "Secretaria" };

	private JRadioButton rbtTarde;
	private JRadioButton rbtNoturno;
	private ButtonGroup grpRadio;

	private JPanel painelDadosFuncionario;
	private JPanel painelLogradouro;
	private JPanel painelDaJanela;

	public void iniciaGui() {
		janela = new JFrame("Cadastro Do Funcionario");

		rbtTarde = new JRadioButton();
		rbtNoturno = new JRadioButton();
		grpRadio = new ButtonGroup();

		btnCancelar = new JButton();
		btnSalvar = new JButton();
		btnSalvarProfissao = new JButton("Escolher");

		lblTurno = new JLabel();
		lblMateria = new JLabel();
		lblSalario = new JLabel();
		lblNome = new JLabel();

		lblSexo = new JLabel();
		lblRg = new JLabel();
		lblCpf = new JLabel();
		lblTelefone = new JLabel();
		lblDataNascimento = new JLabel();
		lblProfissao = new JLabel();
		lblRamal = new JLabel();
		lblSenha = new JLabel();
		lblLogradouro = new JLabel();
		lblNumero = new JLabel();
		lblComplemento = new JLabel();
		lblBairro = new JLabel();
		lblCep = new JLabel();
		lblEstado = new JLabel();
		lblCidade = new JLabel();

		campoSalario = new JTextField();
		campoCep = new JTextField();
		campoBairro = new JTextField();
		campoComplemento = new JTextField();
		campoNumero = new JTextField();
		campoRamal = new JTextField();

		campoTelefone = new JTextField();
		campoNome = new JTextField();

		campoRg = new JTextField();
		campoCpf = new JTextField();
		campoDataNascimento = new JTextField();
		campoLogradouro = new JTextField();
		painelDadosFuncionario = new JPanel();
		painelLogradouro = new JPanel();
		painelDaJanela = (JPanel) janela.getContentPane();

		EstadoController estadoController = new EstadoController();
		List<Estado> listaEstado = estadoController.listarTodos();
		cboxEstado = new JComboBox(listaEstado.toArray());

		CidadeController cidadeController = new CidadeController();
		List<Cidade> listaCidade = cidadeController.listarTodos();
		cboxCidade = new JComboBox(listaCidade.toArray());

		Profissao = new JComboBox(ProfissaoBox);

		lblMateria.setVisible(false);

		// add no grupo de botoes os radio buton's
		grpRadio.add(rbtNoturno);
		grpRadio.add(rbtTarde);

		// configura botoes na tela
		rbtNoturno.setText("Noturno");
		rbtNoturno.setBounds(570, 69, 100, 24);

		// Configuração do botão casado
		rbtTarde.setText("Matutino");
		rbtTarde.setBounds(570, 94, 100, 24);

		// cria tabela

		jtfMateria = new JTextField();
		botaoIncluir = new JButton("Incluir");
		botaoExcluir = new JButton("Excluir");

		DefaultTableModel modelo = new DefaultTableModel(dados, 0);
		tabela = new JTable(modelo);

		tabela.setEnabled(true);

		// instaciando e inserido a tabela no scroll
		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// configuração painel do funcionario
		painelDadosFuncionario.setBounds(5, 5, 755, 200);
		painelDadosFuncionario.setLayout(new GridLayout(1, 0, 0, 0));
		painelDadosFuncionario.setBorder(new TitledBorder("Dados do Funcionario"));
		
		// Configuração do painel do Logradouro
		painelLogradouro.setBounds(5, 210, 755, 150);
		painelLogradouro.setLayout(new GridLayout(1, 0, 0, 0));
		painelLogradouro.setBorder(new TitledBorder("Dados do Logradouro"));

		// configurações do tamanho do componentes da tabela
		painelDeScroll.setBounds(565, 65, 120, 70);

		tabela.setBounds(750, 30, 110, 38);
		botaoIncluir.setBounds(565, 144, 74, 20);
		botaoExcluir.setBounds(645, 144, 74, 20);

		jtfMateria.setBounds(570, 44, 120, 20);
		campoRamal.setBounds(570, 44, 120, 20);

		// escondendo campos e label
		lblTurno.setVisible(false);
		rbtNoturno.setVisible(false);
		rbtTarde.setVisible(false);

		campoRamal.setVisible(false);
		lblRamal.setVisible(false);
		jtfMateria.setVisible(false);
		tabela.setVisible(false);
		painelDeScroll.setVisible(false);
		botaoIncluir.setVisible(false);
		botaoExcluir.setVisible(false);

		// adiciona ação no botao
		botaoIncluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				adicionaLinha();
			}
		});

		botaoExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				excluirLinha();

			}

		});

		// configuraçõe do painel da janela
		painelDaJanela.setLayout(null);

		// configuraçoes da label escolha
		lblCidade.setText("Cidade :");
		lblCidade.setBounds(500, 280, 90, 24);

		lblEstado.setText("Estado :");
		lblEstado.setBounds(500, 250, 90, 24);

		lblBairro.setText("Bairro :");
		lblBairro.setBounds(280, 310, 90, 24);

		lblCep.setText("Cep :");
		lblCep.setBounds(280, 285, 90, 24);

		lblComplemento.setText("Complemento:");
		lblComplemento.setBounds(10, 285, 90, 24);

		lblNumero.setText("Numero :");
		lblNumero.setBounds(10, 310, 80, 24);

		lblDataNascimento.setText("Dt.nascimento :");
		lblDataNascimento.setBounds(10, 119, 100, 24);

		lblLogradouro.setText("Logradouro :");
		lblLogradouro.setBounds(10, 250, 80, 24);

		lblProfissao.setText("Profissão :");
		lblProfissao.setBounds(280, 119, 90, 24);

		lblMateria.setText("Materia :");
		lblMateria.setBounds(500, 44, 90, 24);

		lblTurno.setText("Escolha se turno :");
		lblTurno.setBounds(570, 44, 120, 24);

		lblRamal.setText("Ramal :");
		lblRamal.setBounds(500, 44, 90, 24);

		lblSalario.setText("Salario :");
		lblSalario.setBounds(10, 94, 150, 20);

		lblNome.setText("Nome :");
		lblNome.setBounds(10, 44, 90, 24);

		lblRg.setText("RG :");
		lblRg.setBounds(10, 69, 90, 24);

		lblCpf.setText("CPF :");
		lblCpf.setBounds(280, 69, 50, 24);

		lblSexo.setText("sexo:");
		lblSexo.setBounds(7, 94, 90, 24);

		lblTelefone.setText("Tel.:");
		lblTelefone.setBounds(280, 94, 90, 24);

		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String estadoS = cboxEstado.getSelectedItem().toString();

				String cidadeS = cboxCidade.getSelectedItem().toString();

				if (Profissao.getSelectedItem().equals("Professor")) {
					ProfessorController ac = new ProfessorController();

					ac.verificarSelecionado(campoNome.getText(), campoRg.getText(), campoCpf.getText(),
							campoTelefone.getText(), campoDataNascimento.getText(), campoLogradouro.getText(),
							campoNumero.getText(), campoComplemento.getText(), campoBairro.getText(),
							campoCep.getText(), estadoS, cidadeS, tabela.getName(), campoSalario.getText());

					campoBairro.setText(" ");
					campoCep.setText(" ");
					campoComplemento.setText(" ");
					campoCpf.setText(" ");
					campoDataNascimento.setText(" ");
					campoLogradouro.setText(" ");
					jtfMateria.setText(" ");
					campoSalario.setText(" ");

					campoNome.setText(" ");
					campoNumero.setText(" ");
					campoRg.setText(" ");

					campoTelefone.setText(" ");
				} else if (Profissao.getSelectedItem().equals("Secretaria")) {
					SecretariaController ac = new SecretariaController();

					ac.verificarSelecionado(campoNome.getText(), campoRg.getText(), campoCpf.getText(),
							campoTelefone.getText(), campoDataNascimento.getText(), campoLogradouro.getText(),
							campoNumero.getText(), campoComplemento.getText(), campoBairro.getText(),
							campoCep.getText(), estadoS, cidadeS, campoRamal.getText(), campoSalario.getText());

					campoBairro.setText("");
					campoCep.setText("");
					campoComplemento.setText("");
					campoCpf.setText("");
					campoDataNascimento.setText("");
					campoLogradouro.setText("");
					campoSalario.setText("");
					campoNome.setText("");
					campoNumero.setText("");
					campoRg.setText("");
					campoRamal.setText("");
					campoTelefone.setText("");
				} else if (Profissao.getSelectedItem().equals("Faxineira")) {
					String turno = " ";

					if (rbtNoturno.isSelected()) {
						turno = "Turno noturno ";
					}

					if (rbtTarde.isSelected()) {
						turno = "Turno matutino";
					}

					FaxineiraController ac = new FaxineiraController();

					ac.verificarSelecionado(campoNome.getText(), campoRg.getText(), campoCpf.getText(),
							campoTelefone.getText(), campoDataNascimento.getText(), campoLogradouro.getText(),
							campoNumero.getText(), campoComplemento.getText(), campoBairro.getText(),
							campoCep.getText(), estadoS, cidadeS, turno, campoSalario.getText());

					campoBairro.setText("");
					campoCep.setText("");
					campoComplemento.setText("");
					campoCpf.setText("");
					campoDataNascimento.setText("");
					campoLogradouro.setText("");
					campoSalario.setText("");
					campoNome.setText("");
					campoNumero.setText("");
					campoRg.setText("");
					campoTelefone.setText("");
				}
			}
		});

		btnSalvar.setText("Salvar");

		btnSalvar.setBounds(310, 400, 85, 30);

		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				campoBairro.setText("");
//				campoCep.setText("");
//				campoComplemento.setText("");
//				campoCpf.setText("");
//				campoDataNascimento.setText("");
//				campoLogradouro.setText("");
//				campoNome.setText("");
//				campoNumero.setText("");
//				campoRg.setText("");
//				campoSalario.setText("");
//				campoTelefone.setText("");
				janela.dispose();
			}
		});
		btnSalvarProfissao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (Profissao.getSelectedItem().equals("Professor")) {
					lblMateria.setVisible(true);

					painelDeScroll.setVisible(true);
					tabela.setVisible(true);

					botaoIncluir.setVisible(true);
					botaoExcluir.setVisible(true);
					lblRamal.setVisible(false);
					jtfMateria.setVisible(true);
					campoRamal.setVisible(false);

					lblTurno.setVisible(false);
					rbtNoturno.setVisible(false);
					rbtTarde.setVisible(false);

				}
				if (Profissao.getSelectedItem().equals("Faxineira")) {
					lblMateria.setVisible(false);
					painelDeScroll.setVisible(false);
					tabela.setVisible(false);
					botaoIncluir.setVisible(false);
					botaoExcluir.setVisible(false);
					jtfMateria.setVisible(false);
					lblRamal.setVisible(false);
					campoRamal.setVisible(false);

					lblTurno.setVisible(true);
					rbtNoturno.setVisible(true);
					rbtTarde.setVisible(true);
				}

				if (Profissao.getSelectedItem().equals("Secretaria")) {
					lblRamal.setVisible(true);
					lblMateria.setVisible(false);
					painelDeScroll.setVisible(false);
					tabela.setVisible(false);
					botaoIncluir.setVisible(false);
					botaoExcluir.setVisible(false);
					jtfMateria.setVisible(false);
					campoRamal.setVisible(true);
					lblTurno.setVisible(false);
					rbtNoturno.setVisible(false);
					rbtTarde.setVisible(false);
				}
			}
		});

		btnSalvarProfissao.setBounds(360,144, 120, 20);

		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(400, 400, 85, 30);

		// configuraçoes do combo box
		Profissao.setSelectedIndex(-1);
		cboxEstado.setSelectedIndex(-1);
		cboxEstado.setBounds(560, 250, 150, 20);
		cboxEstado.setMaximumRowCount(100);

		cboxCidade.setSelectedIndex(-1);
		cboxCidade.setBounds(560, 280, 150, 20);
		cboxCidade.setMaximumRowCount(100);

		// configura campo
		campoBairro.setBounds(330, 310, 150, 20);
		campoComplemento.setBounds(110, 285, 150, 20);
		campoLogradouro.setBounds(110, 250, 370, 20);
		campoNumero.setBounds(110, 310, 150, 20);
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("#####-###");
			campoCep = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoCep.setBounds(330, 285, 150, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			campoDataNascimento = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoDataNascimento.setBounds(110, 119, 150, 20);
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##.###.###-#");
			campoRg = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoRg.setBounds(110, 69, 150, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("(##) #####-####");
			campoTelefone = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoTelefone.setBounds(330, 94, 150, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("###.###.###/##");
			campoCpf = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoCpf.setBounds(330, 69, 150, 20);

		Profissao.setBounds(360, 119, 120, 20);

		campoNome.setBounds(110, 44, 370, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("########");
			campoSalario = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoSalario.setBounds(110, 94, 150, 20);

		// configuracoes do painel da tela
		painelDaJanela.setLayout(null);
		painelDaJanela.setBorder(BorderFactory.createLoweredBevelBorder());

		painelDaJanela.add(lblTurno);
		painelDaJanela.add(lblNome);

		painelDaJanela.add(rbtNoturno);
		painelDaJanela.add(rbtTarde);
		painelDaJanela.add(lblRamal);
		painelDaJanela.add(lblTelefone);
		painelDaJanela.add(lblRg);
		painelDaJanela.add(lblCpf);
		painelDaJanela.add(lblDataNascimento);
		painelDaJanela.add(lblSenha);
		painelDaJanela.add(lblLogradouro);
		painelDaJanela.add(lblNumero);
		painelDaJanela.add(lblComplemento);
		painelDaJanela.add(lblBairro);
		painelDaJanela.add(lblCep);
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(lblSalario);
		painelDaJanela.add(lblProfissao);
		painelDaJanela.add(lblMateria);

		painelDaJanela.add(btnSalvarProfissao);
		painelDaJanela.add(btnSalvar);
		painelDaJanela.add(btnCancelar);

		painelDaJanela.add(cboxEstado);
		painelDaJanela.add(cboxCidade);

		painelDaJanela.add(Profissao);
		painelDaJanela.add(campoSalario);
		painelDaJanela.add(campoCep);
		painelDaJanela.add(campoRamal);
		painelDaJanela.add(campoBairro);
		painelDaJanela.add(campoComplemento);
		painelDaJanela.add(campoNumero);
		painelDaJanela.add(campoTelefone);
		painelDaJanela.add(campoLogradouro);
		painelDaJanela.add(campoNome);
		painelDaJanela.add(campoRg);
		painelDaJanela.add(campoCpf);
		painelDaJanela.add(painelDadosFuncionario);
		painelDaJanela.add(painelLogradouro);

		painelDaJanela.add(jtfMateria);
		painelDaJanela.add(campoDataNascimento);
		painelDadosFuncionario.setLayout(null);
		painelDadosFuncionario.add(painelDeScroll);
		painelDaJanela.add(botaoIncluir);
		painelDaJanela.add(botaoExcluir);

		// configutacoes da janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setSize(800, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);

	}

	public void adicionaLinha() {
		if (jtfMateria.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo UF e Estado obrigatorio");
		} else {
			// Obter o modelo da tabela criada
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			// adicionar nova linha com os dados
			modelo.addRow(new String[] { jtfMateria.getText() });

			jtfMateria.setText("");
			JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso!");
		}
	}

	public void excluirLinha() {
		if (tabela.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha");
		} else if (tabela.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Selecione apenas uma linha");
		} else {
			// obter o modelo da tabela criada
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.removeRow(tabela.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
		}

	}

}