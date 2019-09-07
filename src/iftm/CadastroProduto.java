package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dados.Jogo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtDesenvolvedor;
	private JTextField txtAudio;
	private JTextField txtLegenda;
	private JTextField txtGenero;
	private JTextField txtFornecedor;
	private JTextField txtGarantia;
	private JFileChooser fcImagemJogo;
	private String caminho;
	private FileWriter fw;
	private BufferedWriter bw;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	Menu janelaMenu;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public CadastroProduto(Menu janOrigem) {
		janelaMenu = janOrigem;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroJogo = new JLabel("CADASTRO JOGO");
		lblCadastroJogo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastroJogo.setBounds(215, 11, 136, 14);
		contentPane.add(lblCadastroJogo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 61, 48, 17);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setBounds(10, 81, 48, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblTituloDoJogo = new JLabel("T\u00EDtulo do Jogo");
		lblTituloDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloDoJogo.setBounds(75, 61, 99, 17);
		contentPane.add(lblTituloDoJogo);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTitulo.setBounds(68, 81, 190, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlataforma.setBounds(280, 62, 71, 14);
		contentPane.add(lblPlataforma);
		
		JComboBox cbPlataforma = new JComboBox();
		cbPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbPlataforma.setBackground(Color.WHITE);
		cbPlataforma.setBounds(280, 81, 136, 20);
		cbPlataforma.addItem("Playstation 4");
		cbPlataforma.addItem("Xbox One");
		cbPlataforma.addItem("PC");
		cbPlataforma.addItem("Nintendo Switch");
		cbPlataforma.addItem("Playstation 3");
		cbPlataforma.addItem("Xbox 360");
		cbPlataforma.addItem("Nintendo Wii U");
		cbPlataforma.setSelectedItem(null);
		contentPane.add(cbPlataforma);
		
		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassificao.setBounds(10, 112, 82, 17);
		contentPane.add(lblClassificao);
		
		JComboBox cbClassificacao = new JComboBox();
		cbClassificacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbClassificacao.setBackground(Color.WHITE);
		cbClassificacao.setBounds(10, 131, 71, 20);
		cbClassificacao.addItem("L");
		cbClassificacao.addItem("+10");
		cbClassificacao.addItem("+12");
		cbClassificacao.addItem("+14");
		cbClassificacao.addItem("+16");
		cbClassificacao.addItem("+18");
		cbClassificacao.setSelectedItem(null);
		contentPane.add(cbClassificacao);
		
		JLabel lblDesenvolvedor = new JLabel("Desenvolvedor");
		lblDesenvolvedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesenvolvedor.setBounds(102, 112, 99, 14);
		contentPane.add(lblDesenvolvedor);
		
		txtDesenvolvedor = new JTextField();
		txtDesenvolvedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDesenvolvedor.setBounds(102, 131, 167, 20);
		contentPane.add(txtDesenvolvedor);
		txtDesenvolvedor.setColumns(10);
		
		JLabel lblAudio = new JLabel("\u00C1udio");
		lblAudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAudio.setBounds(287, 112, 40, 14);
		contentPane.add(lblAudio);
		
		txtAudio = new JTextField();
		txtAudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAudio.setBounds(282, 131, 104, 20);
		contentPane.add(txtAudio);
		txtAudio.setColumns(10);
		
		JLabel lblLegenda = new JLabel("Legenda");
		lblLegenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLegenda.setBounds(10, 162, 60, 17);
		contentPane.add(lblLegenda);
		
		txtLegenda = new JTextField();
		txtLegenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLegenda.setBounds(10, 182, 114, 20);
		contentPane.add(txtLegenda);
		txtLegenda.setColumns(10);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(140, 164, 61, 14);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGenero.setBounds(138, 182, 104, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		JLabel lblCapaJogo = new JLabel("");
		lblCapaJogo.setBounds(426, 66, 127, 136);
		contentPane.add(lblCapaJogo);
		
		JButton btnAbirImagem = new JButton("ABRIR IMAGEM");
		fcImagemJogo = new JFileChooser();
		
		btnAbirImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fcImagemJogo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					caminho = fcImagemJogo.getSelectedFile().getAbsolutePath();
					ImageIcon img = new ImageIcon(caminho);
					lblCapaJogo.setIcon(img);
				}
				
			}
		});
		btnAbirImagem.setBackground(Color.WHITE);
		btnAbirImagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAbirImagem.setBounds(426, 213, 125, 23);
		contentPane.add(btnAbirImagem);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFornecedor.setBounds(258, 164, 71, 14);
		contentPane.add(lblFornecedor);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFornecedor.setBounds(258, 184, 130, 20);
		contentPane.add(txtFornecedor);
		txtFornecedor.setColumns(10);
		
		JLabel lblGarantia = new JLabel("Garantia");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGarantia.setBounds(12, 213, 60, 14);
		contentPane.add(lblGarantia);
		
		txtGarantia = new JTextField();
		txtGarantia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGarantia.setBounds(12, 230, 99, 20);
		contentPane.add(txtGarantia);
		txtGarantia.setColumns(10);

		JTextArea txtInfoJogo = new JTextArea();
		txtInfoJogo.setBackground(Color.WHITE);
		txtInfoJogo.setLineWrap(true);
		txtInfoJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInfoJogo.setBounds(10, 279, 283, 52);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		txtInfoJogo.setBorder(border);
		contentPane.add(txtInfoJogo);
		
		//Volta ao menu principal
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				CadastroProduto.this.dispose();
			}
		});
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(116, 342, 89, 23);
		contentPane.add(btnVoltar);
		
		//Limpa os campos da janela
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAudio.setText("");
				txtCodigo.setText("");
				txtDesenvolvedor.setText("");
				txtFornecedor.setText("");
				txtGarantia.setText("");
				txtGenero.setText("");
				txtTitulo.setText("");
				txtLegenda.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				txtInfoJogo.setText("");
				cbClassificacao.setSelectedItem(null);
				cbPlataforma.setSelectedItem(null);
				lblCapaJogo.setIcon(null);
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(215, 342, 89, 23);
		contentPane.add(btnLimpar);
		
		//Realizando o cadastro do jogo
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCodigo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o código do jogo");
				}
				if(txtTitulo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o título do jogo");
				}
				if(cbPlataforma.getSelectedIndex() == -1){
					JOptionPane.showMessageDialog(null, "Informe a plataforma do jogo");
				}
				if(cbClassificacao.getSelectedIndex() == -1){
					JOptionPane.showMessageDialog(null, "Informe a classificação do jogo");
				}
				if(txtDesenvolvedor.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o desenvolvedor do jogo");
				}
				if(txtAudio.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o áudio do jogo");
				}
				if(txtLegenda.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe a legenda do jogo");
				}
				if(txtGenero.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o gênero do jogo");
				}
				if(txtFornecedor.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o fornecedor do jogo");
				}
				if(txtGarantia.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe a garantia do jogo");
				}
				if(txtPreco.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o preço do jogo");
				}
				if(txtQuantidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe a quantidade do jogo");
				}
				if(txtInfoJogo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe as informações do jogo");
				}
				if(lblCapaJogo.getIcon() == null){
					JOptionPane.showMessageDialog(null, "Informe a capa do jogo");
				}
				if(!txtPreco.getText().equals("") && !txtQuantidade.getText().equals("") && !txtInfoJogo.getText().equals("") && !txtAudio.getText().equals("") && !txtCodigo.getText().equals("") && !txtDesenvolvedor.getText().equals("") && !txtFornecedor.getText().equals("") && !txtGarantia.getText().equals("") && !txtGenero.getText().equals("") && !txtLegenda.getText().equals("") && !txtTitulo.getText().equals("") && cbClassificacao.getSelectedIndex() != -1 && cbPlataforma.getSelectedIndex() != -1 && lblCapaJogo.getIcon() != null){
						//Passando os dados do jogo para o arquivo txt
					Jogo jogo = new Jogo(txtCodigo.getText().trim(), txtTitulo.getText().trim(), cbPlataforma.getSelectedItem().toString().trim(), cbClassificacao.getSelectedItem().toString().trim(), txtDesenvolvedor.getText().trim(), txtAudio.getText().trim(), txtLegenda.getText().trim(), txtGenero.getText().trim(), txtFornecedor.getText().trim(), txtGarantia.getText().trim(), txtPreco.getText().trim(), txtQuantidade.getText().trim(), txtInfoJogo.getText().trim(), caminho);	
					janelaMenu.arrayJogo.add(jogo);
					
					try {
						fw = new FileWriter("cadProduto.txt", false);
						bw = new BufferedWriter(fw);
						
						for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
							bw.write(janelaMenu.arrayJogo.get(i).getCod() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getNomeJogo() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getPlataforma() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getClassificacao() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getDesenvolvedor() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getIdioma() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getLegenda() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getGenero() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getFornecedor() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getGarantia() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getPreco() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getQuantidade() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getObs() + ";");
							bw.write(janelaMenu.arrayJogo.get(i).getCaminho());
							bw.newLine();
						}
							
							bw.close();
							fw.close();
							JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
							Menu menu = new Menu(); //Abre a janela do menu
							menu.setVisible(true);
							setVisible(false); // fecha a janela do cadastro do jogo
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(315, 342, 127, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblInformacoesJogo = new JLabel("Informa\u00E7\u00F5es do Jogo");
		lblInformacoesJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformacoesJogo.setBounds(10, 261, 141, 17);
		contentPane.add(lblInformacoesJogo);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(140, 210, 46, 21);
		contentPane.add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPreco.setBounds(140, 230, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(247, 210, 80, 17);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(247, 230, 40, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
	}
}
