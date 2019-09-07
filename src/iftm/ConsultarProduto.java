package iftm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import dados.Cliente;
import dados.Jogo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ConsultarProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtProcuraJogo;
	private TableRowSorter trs; 
	private DefaultTableModel modelo;
	private int rowAntigo, columnAntigo, rowNovo, columnNovo;
	private String palavraAntiga, palavraNova;
	Menu janelaMenu;
	Jogo jogo;
	
	public ConsultarProduto(Menu janelaOrigem) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		janelaMenu = janelaOrigem;
		
		JLabel lblConsultarProduto = new JLabel("CONSULTAR PRODUTO");
		lblConsultarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarProduto.setBounds(291, 11, 180, 14);
		contentPane.add(lblConsultarProduto);
		
		JLabel lblNomeDoProduto = new JLabel("Título do Jogo:");
		lblNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoProduto.setBounds(10, 46, 100, 17);
		contentPane.add(lblNomeDoProduto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 758, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowAntigo = table.getSelectedRow();
				columnAntigo = table.getSelectedColumn();
				palavraAntiga = table.getValueAt(rowAntigo, columnAntigo).toString();
				//JOptionPane.showMessageDialog(null, palavraAntiga);
			}
		});
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "T\u00EDtulo do Jogo", "Plataforma", "Classifica\u00E7\u00E3o", "Desenvolvedor", "Audio", "Legenda", "G\u00EAnero", "Fornecedor", "Garantia", "Pre\u00E7o", "Quantidade", "Informa\u00E7\u00F5es do Jogo", "Caminho Capa"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(1).setPreferredWidth(269);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(79);
		table.getColumnModel().getColumn(4).setPreferredWidth(141);
		table.getColumnModel().getColumn(6).setPreferredWidth(96);
		table.getColumnModel().getColumn(8).setPreferredWidth(124);
		table.getColumnModel().getColumn(12).setPreferredWidth(343);
		table.getColumnModel().getColumn(13).setPreferredWidth(300);
		
		txtProcuraJogo = new JTextField();
		txtProcuraJogo.addKeyListener(new KeyAdapter() {
			//Procura o nome do cliente e mostra na JTable
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				txtProcuraJogo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtProcuraJogo.getText(), 1));
					}
				});
				
				trs = new TableRowSorter(modelo);
				table.setRowSorter(trs);
			}
		});
		txtProcuraJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProcuraJogo.setBounds(105, 44, 235, 20);
		contentPane.add(txtProcuraJogo);
		txtProcuraJogo.setColumns(10);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerProduto();
			}
		});
		
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(634, 295, 109, 23);
		contentPane.add(btnRemover);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarProduto();
				
			}
		});
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(524, 295, 100, 23);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu menu = new Menu();
				menu.setVisible(true);
				ConsultarProduto.this.dispose();
			}
		});
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(413, 295, 89, 23);
		contentPane.add(btnVoltar);
		
		preeencherTabela();
	}
	
	public void preeencherTabela(){
		
		modelo = (DefaultTableModel) table.getModel();
		if(modelo.getRowCount() > 0){
			modelo.setRowCount(0);
		}
		
		for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
			modelo.addRow(new Object[]{janelaMenu.arrayJogo.get(i).getCod(), janelaMenu.arrayJogo.get(i).getNomeJogo(), janelaMenu.arrayJogo.get(i).getPlataforma(), janelaMenu.arrayJogo.get(i).getClassificacao(), janelaMenu.arrayJogo.get(i).getDesenvolvedor(), janelaMenu.arrayJogo.get(i).getIdioma(), janelaMenu.arrayJogo.get(i).getLegenda(), janelaMenu.arrayJogo.get(i).getGenero(), janelaMenu.arrayJogo.get(i).getFornecedor(), janelaMenu.arrayJogo.get(i).getGarantia(), janelaMenu.arrayJogo.get(i).getPreco(), janelaMenu.arrayJogo.get(i).getQuantidade(), janelaMenu.arrayJogo.get(i).getObs(), janelaMenu.arrayJogo.get(i).getCaminho()});
		}
	}
	
	public void alterarProduto(){
	if(table.getSelectedRow() >= 0){
		rowNovo = table.getSelectedRow();
		columnNovo = table.getSelectedColumn();
		palavraNova = table.getValueAt(rowNovo, columnNovo).toString();
		
		try {
			String arquivo = "cadProduto.txt"; 
			File file = new File(arquivo);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String linha = br.readLine();
			int cont = 0;
			
			while(linha != null){
				String[] obj = linha.split(";");
				if(obj[columnAntigo].contains(palavraAntiga)){
					
					janelaMenu.arrayJogo.get(cont).setCod(table.getValueAt(rowAntigo, 0).toString());
					janelaMenu.arrayJogo.get(cont).setNomeJogo(table.getValueAt(rowAntigo, 1).toString());
					janelaMenu.arrayJogo.get(cont).setPlataforma(table.getValueAt(rowAntigo, 2).toString());
					janelaMenu.arrayJogo.get(cont).setClassificacao(table.getValueAt(rowAntigo, 3).toString());
					janelaMenu.arrayJogo.get(cont).setDesenvolvedor(table.getValueAt(rowAntigo, 4).toString());
					janelaMenu.arrayJogo.get(cont).setIdioma(table.getValueAt(rowAntigo, 5).toString());
					janelaMenu.arrayJogo.get(cont).setLegenda(table.getValueAt(rowAntigo, 6).toString());
					janelaMenu.arrayJogo.get(cont).setGenero(table.getValueAt(rowAntigo, 7).toString());
					janelaMenu.arrayJogo.get(cont).setFornecedor(table.getValueAt(rowAntigo, 8).toString());
					janelaMenu.arrayJogo.get(cont).setGarantia(table.getValueAt(rowAntigo, 9).toString());
					janelaMenu.arrayJogo.get(cont).setPreco(table.getValueAt(rowAntigo, 10).toString());
					janelaMenu.arrayJogo.get(cont).setQuantidade(table.getValueAt(rowAntigo, 11).toString());
					janelaMenu.arrayJogo.get(cont).setObs(table.getValueAt(rowAntigo, 12).toString());
					janelaMenu.arrayJogo.get(cont).setCaminho(table.getValueAt(rowAntigo, 13).toString());
					
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
		
	public void removerProduto(){
		if(table.getSelectedRow() >= 0){
			int row2 = table.getSelectedRow();
			String nome2 = String.valueOf(table.getValueAt(row2, 1));
			String arquivo = "cadProduto.txt";
			
			for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
				if(nome2.equals(janelaMenu.arrayJogo.get(i).getNomeJogo()) == true){
					janelaMenu.arrayJogo.remove(i);
					
					try {
						FileWriter fw2 = new FileWriter(arquivo, true);
						fw2.close();
						
						escreverArquivo();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Removido com sucesso");
			((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
		}else{
			JOptionPane.showMessageDialog(null, "Selecione a linha");
		}
	}

	public void escreverArquivo(){
		
		try {
			FileWriter fw = new FileWriter("cadProduto.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
				bw.write(janelaMenu.arrayJogo.get(i).getCod() + ";");
				bw.write(janelaMenu.arrayJogo.get(i).getNomeJogo()  + ";");
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}