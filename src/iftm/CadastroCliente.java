package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dados.Cliente;

import java.awt.Color;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEnd;
	private JTextField txtN;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtDataNasc;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private FileWriter fw;
	private BufferedWriter bw;
	private JTextField txtCpf;
	Menu janelaMenu;

	public CadastroCliente(Menu janOrigem) {
		janelaMenu = janOrigem;
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroCliente = new JLabel("CADASTRO CLIENTE");
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastroCliente.setBounds(160, 11, 152, 14);
		contentPane.add(lblCadastroCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 43, 43, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(10, 60, 447, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(10, 85, 63, 20);
		contentPane.add(lblEndereo);
		
		txtEnd = new JTextField();
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEnd.setBounds(10, 108, 302, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblN.setBounds(322, 88, 26, 14);
		contentPane.add(lblN);
		
		txtN = new JTextField();
		txtN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtN.setBounds(322, 108, 43, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCep.setBounds(372, 88, 32, 14);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCep.setBounds(372, 108, 79, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBairro.setBounds(10, 139, 43, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairro.setBounds(10, 158, 131, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCidade.setBounds(151, 141, 46, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setBounds(151, 158, 253, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUf.setBounds(414, 139, 26, 14);
		contentPane.add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUf.setBounds(414, 158, 44, 20);
		contentPane.add(txtUf);
		txtUf.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc");
		lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataNasc.setBounds(10, 237, 68, 14);
		contentPane.add(lblDataNasc);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataNasc.setBounds(10, 254, 86, 20);
		contentPane.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(107, 237, 34, 14);
		contentPane.add(lblSexo);
		
		JComboBox cbSexo = new JComboBox();
		cbSexo.setBackground(Color.WHITE);
		cbSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbSexo.setBounds(106, 254, 91, 20);
		contentPane.add(cbSexo);
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		cbSexo.addItem("Outro");
		
		//Realizando o cadastro do cliente
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNome.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o nome");
				}
				
				if(txtEnd.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o endereço");
				}
				
				if(txtN.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o número");
				}
				
				if(txtCep.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o CEP");
				}
				
				if(txtBairro.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o bairro");
				}
				
				if(txtCidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe a cidade");
				}
				
				if(txtUf.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o UF");
				}
				
				if(txtEmail.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o e-mail");
				}
				
				if(txtTelefone.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o telefone");
				}
				
				if(txtDataNasc.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe a data de nascimento");
				}
				
				if(cbSexo.getSelectedIndex() == -1){
					JOptionPane.showMessageDialog(null, "Informe o sexo");
				}
				if(txtCpf.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o CPF");
				}
				
				if((!txtCpf.getText().equals("") && !txtBairro.getText().equals("")) && (!txtCep.getText().equals("")) && (!txtCidade.getText().equals("")) && (!txtDataNasc.getText().equals("")) && (!txtEmail.getText().equals("")) && (!txtEnd.getText().equals("")) && (!txtN.getText().equals("")) && (!txtNome.getText().equals("")) && (!txtTelefone.getText().equals("")) && (cbSexo.getSelectedIndex() != -1)){
					//Passando os dados para o arquivo txt
					Cliente cli = new Cliente(txtNome.getText().trim(), txtEnd.getText().trim(), txtN.getText().trim(), txtCep.getText().trim(), txtBairro.getText().trim(), txtCidade.getText().trim(), txtUf.getText().trim(), txtEmail.getText().trim(), txtTelefone.getText().trim(), txtDataNasc.getText().trim(), cbSexo.getSelectedItem().toString().trim(), txtCpf.getText().trim());
					janelaMenu.arrayCliente.add(cli);
					try {	
						fw = new FileWriter("cadCliente.txt", false);
						bw = new BufferedWriter(fw);
						for(int i = 0; i < janelaMenu.arrayCliente.size(); i++){
							bw.write(janelaMenu.arrayCliente.get(i).getNome() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getEndereco() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getNum() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getCep() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getBairro() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getCidade() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getUf() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getEmail() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getTelefone() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getDataNasc() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getSexo() + ";");
							bw.write(janelaMenu.arrayCliente.get(i).getCpf());
							bw.newLine();
						}
						bw.close();
						fw.close();
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						Menu menu = new Menu();//Abre a janela de menu
						menu.setVisible(true);
						setVisible(false);//fecha a janela do cadastro do cliente
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
					}
				}
			}
		});
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(343, 285, 124, 23);
		contentPane.add(btnCadastrar);
		
		//Limpa os campos da janela
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBairro.setText("");
				txtCep.setText("");
				txtCidade.setText("");
				txtDataNasc.setText("");
				txtEnd.setText("");
				txtN.setText("");
				txtNome.setText("");
				txtUf.setText("");
				txtEmail.setText("");
				txtCpf.setText("");
				txtTelefone.setText("");
				cbSexo.setSelectedItem(null);
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setBounds(247, 285, 86, 23);
		contentPane.add(btnLimpar);
		
		//Volta ao menu principal
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				CadastroCliente.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(148, 285, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 189, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(10, 206, 323, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(346, 189, 56, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setBounds(348, 206, 109, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		cbSexo.setSelectedItem(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(205, 239, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setBounds(207, 254, 86, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
	}
}