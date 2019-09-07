package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dados.Cliente;
import dados.Jogo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

public class ComprarJogo extends JFrame {

	private JPanel contentPane, panelInformacaoJogo, panelJogo;
	private JList listCliente, listJogo;
	private DefaultListModel modeloCliente, modeloJogo, modeloCarrinho;
	private JLabel lblEscolhaOJogo;
	private JLabel lblInformaesDoJogo, lblCapaJogo, lblPre, lblPreo, lblPlat, lblPlataforma, lblNomeJ, lblNome;
	private ImageIcon img;
	private JPanel panelCarrinho;
	private JLabel lblCarrinho;
	private JList<String> listCarrinho;
	private JButton btnAdicionarNoCarrinho;
	private JLabel lblValorTotalR;
	private JLabel lblValorTotal;
	private JLabel lblComprarJogo;
	private JSpinner spinnerQuant;
	private FileWriter fw;
	private BufferedWriter bw;
	private int cont = 0;
	private double valorTotal = 0.00;
	Cliente cli;
	Jogo jogo;
	Menu janelaMenu;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	public ComprarJogo(Menu janelaOrigem) {
		janelaMenu = janelaOrigem;
		
		modeloCarrinho = new DefaultListModel();
		modeloCliente = new DefaultListModel();
		modeloJogo = new DefaultListModel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCliente.setBackground(Color.WHITE);
		panelCliente.setBounds(10, 49, 177, 255);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblEscolhaUmCliente = new JLabel("Escolha um cliente");
		lblEscolhaUmCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscolhaUmCliente.setBounds(20, 11, 135, 14);
		panelCliente.add(lblEscolhaUmCliente);
		
		listCliente = new JList();
		listCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listJogo.setEnabled(true);
			}
		});
		listCliente.setBounds(10, 38, 157, 206);
		listCliente.setLayoutOrientation(listCliente.VERTICAL_WRAP);
		panelCliente.add(listCliente);
		
		panelJogo = new JPanel();
		panelJogo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelJogo.setBackground(Color.WHITE);
		panelJogo.setBounds(197, 49, 218, 255);
		contentPane.add(panelJogo);
		panelJogo.setLayout(null);
		
		lblEscolhaOJogo = new JLabel("Escolha o jogo");
		lblEscolhaOJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscolhaOJogo.setBounds(67, 11, 101, 17);
		panelJogo.add(lblEscolhaOJogo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 198, 186);
		panelJogo.add(scrollPane);
		
		listJogo = new JList();
		scrollPane.setViewportView(listJogo);
		listJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				adicionaInformacao();
			}
		});
		listJogo.setLayoutOrientation(listJogo.VERTICAL_WRAP);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(10, 230, 72, 14);
		panelJogo.add(lblQuantidade);
		
		spinnerQuant = new JSpinner();
		spinnerQuant.setBounds(80, 227, 29, 20);
		panelJogo.add(spinnerQuant);
		
		panelInformacaoJogo = new JPanel();
		panelInformacaoJogo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInformacaoJogo.setBackground(Color.WHITE);
		panelInformacaoJogo.setBounds(438, 49, 394, 187);
		contentPane.add(panelInformacaoJogo);
		panelInformacaoJogo.setLayout(null);
		
		lblInformaesDoJogo = new JLabel("Informa\u00E7\u00F5es do Jogo");
		lblInformaesDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformaesDoJogo.setBounds(124, 11, 144, 22);
		panelInformacaoJogo.add(lblInformaesDoJogo);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 42, 46, 14);
		panelInformacaoJogo.add(lblNome);
		
		lblNomeJ = new JLabel("");
		lblNomeJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeJ.setBounds(10, 60, 258, 14);
		panelInformacaoJogo.add(lblNomeJ);
		
		lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlataforma.setBounds(10, 79, 78, 14);
		panelInformacaoJogo.add(lblPlataforma);
		
		lblPlat = new JLabel("");
		lblPlat.setBounds(10, 100, 133, 14);
		panelInformacaoJogo.add(lblPlat);
		
		lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(10, 116, 46, 17);
		panelInformacaoJogo.add(lblPreo);
		
		lblPre = new JLabel("");
		lblPre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPre.setBounds(10, 135, 58, 14);
		panelInformacaoJogo.add(lblPre);
		
		lblCapaJogo = new JLabel("");
		lblCapaJogo.setBounds(270, 40, 114, 136);
		panelInformacaoJogo.add(lblCapaJogo);
		
		panelCarrinho = new JPanel();
		panelCarrinho.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCarrinho.setBackground(Color.WHITE);
		panelCarrinho.setBounds(438, 247, 394, 187);
		contentPane.add(panelCarrinho);
		panelCarrinho.setLayout(null);
		
		lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCarrinho.setBounds(171, 11, 59, 14);
		panelCarrinho.add(lblCarrinho);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 34, 364, 105);
		panelCarrinho.add(scrollPane_1);
		
		listCarrinho = new JList();
		scrollPane_1.setViewportView(listCarrinho);
		listCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//adicionaInformacao();
			}
		});
		listCarrinho.setLayoutOrientation(listCarrinho.VERTICAL_WRAP);
		
		lblValorTotalR = new JLabel("Valor Total: R$");
		lblValorTotalR.setBounds(10, 154, 84, 22);
		panelCarrinho.add(lblValorTotalR);
		
		lblValorTotal = new JLabel("");
		lblValorTotal.setBounds(95, 158, 72, 14);
		panelCarrinho.add(lblValorTotal);
		
		btnAdicionarNoCarrinho = new JButton("ADICIONAR NO CARRINHO");
		btnAdicionarNoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionaJogo();
			}
		});
		btnAdicionarNoCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarNoCarrinho.setBackground(Color.WHITE);
		btnAdicionarNoCarrinho.setBounds(10, 322, 208, 23);
		contentPane.add(btnAdicionarNoCarrinho);
		
		lblComprarJogo = new JLabel("COMPRAR JOGO");
		lblComprarJogo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComprarJogo.setBounds(318, 11, 142, 14);
		contentPane.add(lblComprarJogo);
		
		JButton btnComprar = new JButton("FINALIZAR COMPRAR");
		btnComprar.setBackground(Color.WHITE);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprarJogo();
			}
		});
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprar.setBounds(10, 376, 208, 23);
		contentPane.add(btnComprar);
	
		
		JButton btnRetirarDoCarrinho = new JButton("RETIRAR DO CARRINHO");
		btnRetirarDoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retirarCarrinho();
			}
		});
		btnRetirarDoCarrinho.setBackground(Color.WHITE);
		btnRetirarDoCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRetirarDoCarrinho.setBounds(227, 322, 188, 23);
		contentPane.add(btnRetirarDoCarrinho);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu menu = new Menu();
				menu.setVisible(true);
				ComprarJogo.this.dispose();
			}
		});
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(227, 376, 188, 23);
		contentPane.add(btnVoltar);
		
		preencherListaCliente();
		preencherListaJogo();
	}
	
	public void comprarJogo(){
		if(listCarrinho.getModel().getSize() == 0){
			JOptionPane.showMessageDialog(null, "Adicione algum jogo no carrinho para finalizar a compra");
		}else{
			JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
			
			GregorianCalendar calendar = new GregorianCalendar();
			try {
				fw = new FileWriter("cadCompra.txt", true);
				bw = new BufferedWriter(fw);
				bw.write("\nHora: " + calendar.get(Calendar.HOUR_OF_DAY) + ":");
				bw.write(calendar.get(Calendar.MINUTE) + ":");
				bw.write(calendar.get(Calendar.SECOND) + "\n");
				bw.write("Dia: " + calendar.get(Calendar.DAY_OF_MONTH) + "/");
				bw.write(calendar.get(Calendar.MONTH) + 1 + "/");
				bw.write(calendar.get(Calendar.YEAR) + "\n");
				bw.write("Nome: " + listCliente.getSelectedValue().toString() + "\n");
				for(int i = 0; i < cont; i++){
					String info = listCarrinho.getModel().getElementAt(i).toString();
					String[] obj = info.split(";");
					//pega a quantidade do jogo
					bw.write("Quantidade: " + obj[0] + "\n");
					//pega o nome do jogo
					bw.write("Jogo: " + obj[1] + "\n");
					//pega o valor do jogo
					bw.write("Valor: " + obj[2] + "\n");
				}
				bw.write("Valor Total: " + lblValorTotal.getText() + "\n");
				bw.write("----------------------------------\n");
				
				bw.newLine();
				
				bw.close();
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			limpaCampoInfo();
			modeloCarrinho.removeAllElements();
			lblValorTotal.setText("0,00");
			
			Menu menu = new Menu();
			menu.setVisible(true);
			ComprarJogo.this.dispose();
		}
	}
	
	public void preencherListaCliente(){
		for(int i = 0; i < janelaMenu.arrayCliente.size(); i++){
			listCliente.setModel(modeloCliente);
			modeloCliente.addElement(janelaMenu.arrayCliente.get(i).getNome());
		}
	}
	
	public void preencherListaJogo(){
		for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
			listJogo.setModel(modeloJogo);
			modeloJogo.addElement(janelaMenu.arrayJogo.get(i).getNomeJogo());
		}
		listJogo.setEnabled(false);
	}
	
	public void adicionaJogo(){
		try{
			if(!spinnerQuant.getValue().equals(0)){
				int quant2 = 0;
				String nomeJ = listJogo.getSelectedValue().toString();
				
				modeloCarrinho.addElement(spinnerQuant.getValue() + ";" + nomeJ + ";" + lblPre.getText());
				listCarrinho.setModel(modeloCarrinho);
				double valor = 0.00;
				double quantidade = 0.00;
				String valorJogo = lblPre.getText();
				String quant = spinnerQuant.getValue().toString();
				quantidade = (Double)Double.parseDouble(quant);
				valor = (double)Double.parseDouble(valorJogo);
				quant2 = (int)Integer.parseInt(spinnerQuant.getValue().toString());
				
				String nomeJogo = listJogo.getSelectedValue().toString();
				
				for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
					if(nomeJ.equals(janelaMenu.arrayJogo.get(i).getNomeJogo()) == true){
						int sub = (int)Integer.parseInt(janelaMenu.arrayJogo.get(i).getQuantidade()) - quant2;
						janelaMenu.arrayJogo.get(i).setQuantidade(String.valueOf(sub));
						break;
					}
				}
				
				escreverArquivo();
				
				valor = valor * quantidade;
				
				NumberFormat doubleformat = NumberFormat.getInstance();
				doubleformat.setMinimumFractionDigits(2);
				doubleformat.setMaximumFractionDigits(2);

				valorTotal += valor;
				
				int indice2 = listJogo.getSelectedIndex();
				modeloJogo.remove(indice2);
				
				lblValorTotal.setText(String.valueOf(doubleformat.format(valorTotal)));
				limpaCampoInfo();
				cont++;
			}else{
				JOptionPane.showMessageDialog(null, "Informe a quantidade");
			}
		}catch(java.lang.NullPointerException e){
			JOptionPane.showMessageDialog(null, "Selecione o jogo");
		}
	}
	
	public void adicionaInformacao(){
		
		try{
			limpaCampoInfo();
			if(listJogo.isEnabled()){
				listCliente.setEnabled(false);
			}
			
			String nomeJogo = listJogo.getSelectedValue().toString();
			for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
				if(nomeJogo.equals(janelaMenu.arrayJogo.get(i).getNomeJogo())){
					lblNomeJ.setText(janelaMenu.arrayJogo.get(i).getNomeJogo());
					lblPlat.setText(janelaMenu.arrayJogo.get(i).getPlataforma());
					lblPre.setText(janelaMenu.arrayJogo.get(i).getPreco());
					img = new ImageIcon(janelaMenu.arrayJogo.get(i).getCaminho());
					lblCapaJogo.setIcon(img);
					break;
				}
			}
		}catch(java.lang.NullPointerException e){
			JOptionPane.showMessageDialog(null, "Selecione o cliente");
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
	
	public void limpaCampoInfo(){
		spinnerQuant.setValue(0);
		lblNomeJ.setText("");
		lblPlat.setText("");
		lblPre.setText("");
		lblCapaJogo.setIcon(null);;
	}
	
	public void retirarCarrinho(){
		String valorRetirar = "";
		double valorRet;
		int quant = 0;
		//int cont = 0;
		int indice = listCarrinho.getSelectedIndex();
		try {
			String nomeJogo = listCarrinho.getSelectedValue().toString();
			String[] obj1 = nomeJogo.split(";");
			int quant2 = (int)Integer.parseInt(obj1[0]);
			valorRet = (double)Double.parseDouble(obj1[2]);
			for(int i = 0; i < janelaMenu.arrayJogo.size(); i++){
				if(obj1[1].equals(janelaMenu.arrayJogo.get(i).getNomeJogo())){
					int soma = (int)Integer.parseInt(janelaMenu.arrayJogo.get(i).getQuantidade()) + quant2;
					janelaMenu.arrayJogo.get(i).setQuantidade(String.valueOf(soma));
					break;
				}
			}
	
			escreverArquivo();
			
			valorTotal -= valorRet * quant2;
			
			NumberFormat doubleformat = NumberFormat.getInstance();
			doubleformat.setMinimumFractionDigits(2);
			doubleformat.setMaximumFractionDigits(2);
			
			lblValorTotal.setText(String.valueOf(doubleformat.format(valorTotal)));
			modeloCarrinho.remove(indice);
			modeloJogo.addElement(obj1[1]);
			cont--;
			JOptionPane.showMessageDialog(null, "Jogo retirado");
				
		}catch(java.lang.ArrayIndexOutOfBoundsException u){
			JOptionPane.showMessageDialog(null, "Selecione o jogo a ser retirado");
		}catch(java.lang.NullPointerException a){
			JOptionPane.showMessageDialog(null, "Selecione o jogo a ser retirado");
		}
	}
}