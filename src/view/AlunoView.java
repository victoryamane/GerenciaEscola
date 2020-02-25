package view;

import java.awt.GridLayout;

/**
 * Classe tela para cadastrar aluno
 * @author vyamane
 *@since 18/02/2020
 *@version 0.1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.AlunoController;

public class AlunoView {
	// Variaveis
	private JFrame janela;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JTextField campoMatricula;
	private JTextField campoDataNascimento;
	private JTextField campoNome;
	private JTextField campoLogradouro;
	private JTextField campoNumero;
	private JTextField campoComplemento;
	private JTextField campoBairro;
	private JTextField campoCep;
	private JTextField campoCpf;
	private JTextField campoRg;
	private JTextField campoTelefone;
	private JLabel lblMatricula;
	private JLabel lblNome;
	private JLabel lblDataNascimento;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblTelefone;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JRadioButton rbtSexoM;
	private JRadioButton rbtSexoF;
	private ButtonGroup grpRadio;
	private JComboBox cboxCidade;
	private String[] cidade = { "" };
	private JComboBox cboxEstado;
	private String[] estado = { "" };
	private JLabel jtfSenha;
	private JPasswordField jpwSenha;
	private JPanel painelDaJanela;
	private JPanel painelDadosAluno;
	private JPanel painelLogradouro;

	public void iniciaGui() {

		// instacia
		janela = new JFrame();
		botaoSalvar = new JButton("Salvar");
		botaoCancelar = new JButton("Cancelar");
		lblMatricula = new JLabel();
		lblNome = new JLabel();
		lblDataNascimento = new JLabel();
		lblCidade = new JLabel();
		lblEstado = new JLabel();
		lblLogradouro = new JLabel();
		lblNumero = new JLabel();
		lblComplemento = new JLabel();
		lblBairro = new JLabel();
		lblCep = new JLabel();
		lblCpf = new JLabel();
		lblRg = new JLabel();
		lblTelefone = new JLabel();
		campoMatricula = new JTextField();
		campoNome = new JTextField();
		campoDataNascimento = new JTextField();
		campoLogradouro = new JTextField();
		campoNumero = new JTextField();
		campoComplemento = new JTextField();
		campoBairro = new JTextField();
		campoCep = new JTextField();
		campoCpf = new JTextField();
		campoRg = new JTextField();
		campoTelefone = new JTextField();
		rbtSexoM = new JRadioButton();
		rbtSexoF = new JRadioButton();
		cboxCidade = new JComboBox();
		cboxEstado = new JComboBox();
		jtfSenha = new JLabel();
		jpwSenha = new JPasswordField();
		painelDaJanela = (JPanel) janela.getContentPane();
		painelDadosAluno = new JPanel();
		painelLogradouro = new JPanel();

		// Cria o objeto de grupo de botoões
		grpRadio = new ButtonGroup();

		// Adiciona os botões ao grupo
		grpRadio.add(rbtSexoM);
		grpRadio.add(rbtSexoF);

		// Cria o botão Salvar
		botaoSalvar.setBounds(170, 430, 100, 40);
		botaoSalvar.addActionListener(new SalvarListener());

		// Cria o botão Cancelar
		botaoCancelar.setBounds(280, 430, 100, 40);
		botaoCancelar.addActionListener(new CancelaListener());

		// Configuração da label matricula
		lblMatricula.setText("Matricula");
		lblMatricula.setBounds(30, 30, 95, 20);

		// Configuração da label nome
		lblNome.setText("Nome");
		lblNome.setBounds(200, 30, 95, 20);

		// Configuração da label data nascimento
		lblDataNascimento.setText("Dt. nascimento");
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			campoDataNascimento = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		lblDataNascimento.setBounds(30, 80, 95, 20);

		// Configuração da label cpf
		lblCpf.setText("CPF");
		try {
			javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###/##");
			campoCpf = new javax.swing.JFormattedTextField(cpf);
		} catch (Exception e) {
		}
		lblCpf.setBounds(200, 80, 95, 20);

		// Configuração da label rg
		lblRg.setText("RG");
		try {
			javax.swing.text.MaskFormatter rg = new javax.swing.text.MaskFormatter("##.###.###-#");
			campoRg = new javax.swing.JFormattedTextField(rg);
		} catch (Exception e) {
		}
		lblRg.setBounds(385, 80, 95, 20);

		// Configuração da label telefone
		lblTelefone.setText("Telefone");
		try {
			javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("(##) ####-####");
			campoTelefone = new javax.swing.JFormattedTextField(tel);
		} catch (Exception e) {
		}
		lblTelefone.setBounds(30, 130, 95, 20);

		// Configuração do botão sexo M
		rbtSexoM.setText("Masculino");
		rbtSexoM.setBounds(200, 150, 90, 24);

		// Configuração do botão sexo F
		rbtSexoF.setText("Feminino");
		rbtSexoF.setBounds(290, 150, 90, 24);

		// Configuração da label senha
		jtfSenha.setText("Senha");
		jtfSenha.setBounds(385, 130, 300, 20);

		// Configuração da label logradouro
		lblLogradouro.setText("Logradouro");
		lblLogradouro.setBounds(30, 230, 95, 20);

		// Configuração da label numero
		lblNumero.setText("Numero");
		lblNumero.setBounds(30, 280, 95, 20);

		// Configuração da label complemento
		lblComplemento.setText("Complemento");
		lblComplemento.setBounds(200, 280, 95, 20);

		// Configuração da label bairro
		lblBairro.setText("Bairro");
		lblBairro.setBounds(385, 280, 95, 20);

		// Configuração da label cep
		lblCep.setText("CEP");
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("#####-###");
			campoCep = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		lblCep.setBounds(30, 330, 95, 20);

		// Configuração da label cidade
		lblCidade.setText("Cidade");
		lblCidade.setBounds(200, 330, 95, 20);

		// Configuração da label estado
		lblEstado.setText("Estado");
		lblEstado.setBounds(385, 330, 95, 20);

		// Configurar a campo senha
		jpwSenha.setBounds(385, 150, 165, 20);

		// Cria um campo para digitar texto
		campoMatricula.setBounds(30, 50, 150, 20);
		campoNome.setBounds(200, 50, 350, 20);
		campoDataNascimento.setBounds(30, 100, 150, 20);
		campoCpf.setBounds(200, 100, 165, 20);
		campoRg.setBounds(385, 100, 165, 20);
		campoTelefone.setBounds(30, 150, 150, 20);
		campoLogradouro.setBounds(30, 250, 520, 20);
		campoNumero.setBounds(30, 300, 150, 20);
		campoComplemento.setBounds(200, 300, 165, 20);
		campoBairro.setBounds(385, 300, 165, 20);
		campoCep.setBounds(30, 350, 150, 20);

		// Configurações do combo box cidade
		cboxCidade.setSelectedIndex(-1);
		cboxCidade.setBounds(200, 350, 165, 19);
		cboxCidade.setMaximumRowCount(10);

		// Configurações do combo box estado
		cboxEstado.setSelectedIndex(-1);
		cboxEstado.setBounds(385, 350, 165, 19);
		cboxEstado.setMaximumRowCount(10);

		// Configuração do painel do aluno
		painelDadosAluno.setBounds(5, 5, 555, 200);
		painelDadosAluno.setLayout(new GridLayout(1, 0, 0, 0));
		painelDadosAluno.setBorder(new TitledBorder("Dados do Aluno"));

		// Configuração do painel do Logradouro
		painelLogradouro.setBounds(5, 210, 555, 200);
		painelLogradouro.setLayout(new GridLayout(1, 0, 0, 0));
		painelLogradouro.setBorder(new TitledBorder("Dados do Logradouro"));

		// Configurações do painel da tela
		painelDaJanela.setLayout(null);
		painelDaJanela.setBorder(BorderFactory.createLoweredBevelBorder());
		painelDaJanela.add(botaoSalvar);
		painelDaJanela.add(botaoCancelar);
		painelDaJanela.add(campoMatricula);
		painelDaJanela.add(campoNome);
		painelDaJanela.add(campoDataNascimento);
		painelDaJanela.add(campoLogradouro);
		painelDaJanela.add(campoNumero);
		painelDaJanela.add(campoComplemento);
		painelDaJanela.add(campoBairro);
		painelDaJanela.add(campoCep);
		painelDaJanela.add(campoCpf);
		painelDaJanela.add(campoRg);
		painelDaJanela.add(campoTelefone);
		painelDaJanela.add(cboxEstado);
		painelDaJanela.add(cboxCidade);
		painelDaJanela.add(rbtSexoM);
		painelDaJanela.add(rbtSexoF);
		painelDaJanela.add(lblMatricula);
		painelDaJanela.add(lblNome);
		painelDaJanela.add(lblDataNascimento);
		painelDaJanela.add(lblLogradouro);
		painelDaJanela.add(lblNumero);
		painelDaJanela.add(lblComplemento);
		painelDaJanela.add(lblBairro);
		painelDaJanela.add(lblCep);
		painelDaJanela.add(lblCpf);
		painelDaJanela.add(lblRg);
		painelDaJanela.add(lblTelefone);
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(jtfSenha);
		painelDaJanela.add(jpwSenha);
		painelDaJanela.add(painelDadosAluno);
		painelDaJanela.add(painelLogradouro);

		// Cria a janela
		janela.setTitle("Cadastro de Aluno");
		janela.setSize(580, 530);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	// Salva o aluno
	public class SalvarListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String sexo = "";
			if (rbtSexoF.isSelected()) {
				sexo = "F";
			}
			if (rbtSexoM.isSelected()) {
				sexo = "M";
			}		
			Object itemEstado = cboxEstado.getSelectedItem();
			String estadoS;
			if (itemEstado != null) {
				estadoS= itemEstado.toString();
			}else {
				estadoS ="";
			}				
			
			Object itemCidade = cboxCidade.getSelectedItem();			
			String cidadeS;
			if (itemCidade != null) {
				cidadeS= itemCidade.toString();
			}else {
				cidadeS ="";
			}

			AlunoController ac = new AlunoController();

			ac.verificarSelecionado(campoNome.getText(), campoMatricula.getText(), sexo, campoRg.getText(),
					campoCpf.getText(), campoTelefone.getText(), campoDataNascimento.getText(), jtfSenha.getText(),
					campoLogradouro.getText(), campoNumero.getText(), campoComplemento.getText(), campoBairro.getText(),
					campoCep.getText(), estadoS, cidadeS);

			campoBairro.setText(" ");
			campoCep.setText(" ");
			campoComplemento.setText(" ");
			campoCpf.setText(" ");
			campoDataNascimento.setText(" ");
			campoLogradouro.setText(" ");
			campoMatricula.setText(" ");
			campoNome.setText(" ");
			campoNumero.setText(" ");
			campoRg.setText(" ");
			jpwSenha.setText(" ");
			campoTelefone.setText(" ");
		}
	}

// Função do botão cancelar
	public class CancelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			campoBairro.setText(" ");
			campoCep.setText(" ");
			campoComplemento.setText(" ");
			campoCpf.setText(" ");
			campoDataNascimento.setText(" ");
			campoLogradouro.setText(" ");
			campoMatricula.setText(" ");
			campoNome.setText(" ");
			campoNumero.setText(" ");
			campoRg.setText(" ");
			jpwSenha.setText(" ");
			campoTelefone.setText(" ");

		}
	}
}
