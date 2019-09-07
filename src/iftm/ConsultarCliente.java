package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dados.Cliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtProcuraCliente;
	private JTable table;
	private DefaultTableModel modelo;
	private TableRowSorter trs; 
	private String palavraAntiga, palavraNova;
	private int rowAntigo, columnAntigo, rowNovo, columnNovo;
	Cliente cli;
	Menu janelaMenu;

	public ConsultarCliente(Menu janelaOrigem) {
		janelaMenu = janelaOrigem;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultarCliente = new JLabel("CONSULTAR CLIENTE");
		lblConsultarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarCliente.setBounds(364, 6, 165, 14);
		contentPane.add(lblConsultarCliente);
		
		txtProcuraCliente = new JTextField();
		txtProcuraCliente.addKeyListener(new KeyAdapter() {
			//Procura o nome do cliente e mostra na JTable
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				txtProcuraCliente.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtProcuraCliente.getText(), 0));
					}
				});
				
				trs = new TableRowSorter(modelo);
				table.setRowSorter(trs);
			}
		});
		txtProcuraCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProcuraCliente.setBounds(119, 45, 235, 20);
		contentPane.add(txtProcuraCliente);
		txtProcuraCliente.setColumns(10);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 758, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					rowAntigo = table.getSelectedRow();
					columnAntigo = table.getSelectedColumn();
					palavraAntiga = table.getValueAt(rowAntigo, columnAntigo).toString();
				}catch(java.lang.ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Selecione a linha");
				}
				//JOptionPane.showMessageDialog(null, palavraAntiga);
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Endere\u00E7o", "N\u00BA", "CEP", "Bairro", "Cidade", "UF", "E-mail", "Telefone", "Data Nasc", "Sexo", "CPF"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(235);
		table.getColumnModel().getColumn(1).setPreferredWidth(201);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(126);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(26);
		table.getColumnModel().getColumn(7).setPreferredWidth(180);
		table.getColumnModel().getColumn(8).setPreferredWidth(110);
		table.getColumnModel().getColumn(9).setPreferredWidth(89);
		table.getColumnModel().getColumn(11).setPreferredWidth(92);
		table.setColumnSelectionAllowed(false);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerCliente();
			}
		});
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoCliente.setBounds(10, 46, 109, 14);
		contentPane.add(lblNomeDoCliente);
		
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(634, 295, 109, 23);
		contentPane.add(btnRemover);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarCliente();
			}
		});
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(527, 295, 97, 23);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				ConsultarCliente.this.dispose();
			}
		});
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(425, 295, 89, 23);
		contentPane.add(btnVoltar);
		
		preeencherTabela();
	}
	
	public void alterarCliente(){
		if(table.getSelectedRow() >= 0){
			rowNovo = table.getSelectedRow();
			columnNovo = table.getSelectedColumn();
			palavraNova = table.getValueAt(rowNovo, columnNovo).toString();
			
			try {
				String arquivo = "cadCliente.txt"; 
				File file = new File(arquivo);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				String linha = br.readLine();
				int cont = 0;
				//ArrayList<String> salvar = new ArrayList();
				while(linha != null){
					String[] obj = linha.split(";");
					if(obj[columnAntigo].contains(palavraAntiga)){
						
						janelaMenu.arrayCliente.get(cont).setNome(table.getValueAt(rowAntigo, 0).toString());
						janelaMenu.arrayCliente.get(cont).setEndereco(table.getValueAt(rowAntigo, 1).toString());
						janelaMenu.arrayCliente.get(cont).setNum(table.getValueAt(rowAntigo, 2).toString());
						janelaMenu.arrayCliente.get(cont).setCep(table.getValueAt(rowAntigo, 3).toString());
						janelaMenu.arrayCliente.get(cont).setBairro(table.getValueAt(rowAntigo, 4).toString());
						janelaMenu.arrayCliente.get(cont).setCidade(table.getValueAt(rowAntigo, 5).toString());
						janelaMenu.arrayCliente.get(cont).setUf(table.getValueAt(rowAntigo, 6).toString());
						janelaMenu.arrayCliente.get(cont).setEmail(table.getValueAt(rowAntigo, 7).toString());
						janelaMenu.arrayCliente.get(cont).setTelefone(table.getValueAt(rowAntigo, 8).toString());
						janelaMenu.arrayCliente.get(cont).setDataNasc(table.getValueAt(rowAntigo, 9).toString());
						janelaMenu.arrayCliente.get(cont).setSexo(table.getValueAt(rowAntigo, 10).toString());
						janelaMenu.arrayCliente.get(cont).setCpf(table.getValueAt(rowAntigo, 11).toString());
						break;
					}
					cont++;
					linha = br.readLine();
				}

				br.close();
				fr.close();

				escreverArquivo();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Erro");
			} catch(IOException o){
				JOptionPane.showMessageDialog(null, "Erro");
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Selecione o campo a ser alterado");
		}
	}
	
	public void preeencherTabela(){
		
		modelo = (DefaultTableModel) table.getModel();
		if(modelo.getRowCount() > 0){
			modelo.setRowCount(0);
		}
		
		for(int i = 0; i < janelaMenu.arrayCliente.size(); i++){
			modelo.addRow(new Object[]{janelaMenu.arrayCliente.get(i).getNome(), janelaMenu.arrayCliente.get(i).getEndereco(), janelaMenu.arrayCliente.get(i).getNum(), janelaMenu.arrayCliente.get(i).getCep(), janelaMenu.arrayCliente.get(i).getBairro(), janelaMenu.arrayCliente.get(i).getCidade(), janelaMenu.arrayCliente.get(i).getUf(), janelaMenu.arrayCliente.get(i).getEmail(), janelaMenu.arrayCliente.get(i).getTelefone(), janelaMenu.arrayCliente.get(i).getDataNasc(), janelaMenu.arrayCliente.get(i).getSexo(), janelaMenu.arrayCliente.get(i).getCpf()});
		}
	}
	
	public void removerCliente(){
		if(table.getSelectedRow() >= 0){
			int row2 = table.getSelectedRow();
			String nome2 = String.valueOf(table.getValueAt(row2, 0));
			String arquivo = "cadCliente.txt";
			
			for(int i = 0; i < janelaMenu.arrayCliente.size(); i++){
				if(nome2.equals(janelaMenu.arrayCliente.get(i).getNome()) == true){
					janelaMenu.arrayCliente.remove(i);
				}
				
				try {
					FileWriter fw2 = new FileWriter(arquivo, true);
					fw2.close();
					
					escreverArquivo();
		
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Erro");
				} catch(IOException o){
					JOptionPane.showMessageDialog(null, "Erro");
				}
			}
			
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			//Deletando a linha do JTable
			System.out.println(table.getSelectedRow());
			((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow()); 
		}else{	
			JOptionPane.showMessageDialog(null, "Selecione a linha");
		}
	}
	
	public void escreverArquivo(){
		
		try {
			FileWriter fw = new FileWriter("cadCliente.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < janelaMenu.arrayCliente.size(); i++){
				bw.write(janelaMenu.arrayCliente.get(i).getNome() + ";");
				bw.write(janelaMenu.arrayCliente.get(i).getEndereco()  + ";");
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}