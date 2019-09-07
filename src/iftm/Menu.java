package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Cliente;
import dados.Jogo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private File fileCliente, fileProduto, fileCompra;
	public ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
	public ArrayList<Jogo> arrayJogo = new ArrayList<Jogo>();
	Jogo jogo;
	Cliente cli;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 306);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fileCliente = new File("cadCliente.txt");
		fileProduto= new File("cadProduto.txt");
		fileCompra = new File("cadCompra.txt");
		
		carregarArquivosJogo();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\alany\\Desktop\\java\\trabalhoPoo\\img\\gameStop2.png"));
		label.setBounds(20, 0, 475, 92);
		contentPane.add(label);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR CLIENTE");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroCliente cadCliente = new CadastroCliente(Menu.this);
				cadCliente.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnCadastrarCliente.setBackground(Color.WHITE);
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarCliente.setBounds(10, 122, 223, 29);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnListarCliente = new JButton("LISTAR CLIENTE");
		btnListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					FileReader fr = new FileReader(fileCliente);
					int tamanho = (int) fileCliente.length();
					if(tamanho != 0){
						ConsultarCliente consulta = new ConsultarCliente(Menu.this);
						consulta.setVisible(true);
						Menu.this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Cadastre um cliente");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Cadastre um cliente");
				}
				
			}
		});
		btnListarCliente.setBackground(Color.WHITE);
		btnListarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnListarCliente.setBounds(10, 174, 223, 29);
		contentPane.add(btnListarCliente);
		
		JButton btnComprar = new JButton("COMPRAR JOGO");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int verifica = 0;
					int tamanhoCliente = (int) fileCliente.length(), tamanhoProduto = (int) fileProduto.length();
					FileReader frCliente = new FileReader(fileCliente);
					FileReader frProduto = new FileReader(fileProduto);
					if(tamanhoCliente == 0){
						JOptionPane.showMessageDialog(null, "Cadastre um cliente");
					}
					if(tamanhoProduto == 0){
						JOptionPane.showMessageDialog(null, "Cadastre um jogo");
					}
					
					if(tamanhoCliente != 0 && tamanhoProduto != 0){
						ComprarJogo comprarJogo = new ComprarJogo(Menu.this);
						comprarJogo.setVisible(true);
						Menu.this.dispose();
					}
					
					
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Para realizar a compra precisa de pelo menos 1 cliente e 1 jogo");
					e.printStackTrace();
				}
				
			}
		});
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnComprar.setBounds(10, 227, 223, 29);
		contentPane.add(btnComprar);
		
		JButton btnCadastrarJogo = new JButton("CADASTRAR JOGO");
		btnCadastrarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto cadProduto = new CadastroProduto(Menu.this);
				cadProduto.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnCadastrarJogo.setBackground(Color.WHITE);
		btnCadastrarJogo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarJogo.setBounds(260, 122, 241, 29);
		contentPane.add(btnCadastrarJogo);
		
		JButton btnListarJogo = new JButton("LISTAR JOGO");
		btnListarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fr = new FileReader(fileProduto);
					int tamanho = (int) fileProduto.length();
					if(tamanho != 0){
						ConsultarProduto consultaProduto = new ConsultarProduto(Menu.this);
						consultaProduto.setVisible(true);
						Menu.this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Cadastre um jogo");
					}
				} catch (FileNotFoundException w) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Cadastre um jogo");
				}
			}
		});
		btnListarJogo.setBackground(Color.WHITE);
		btnListarJogo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnListarJogo.setBounds(260, 174, 241, 29);
		contentPane.add(btnListarJogo);
		
		JButton btnListarVenda = new JButton("LISTAR VENDA");
		btnListarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					FileReader fr = new FileReader(fileCompra);
					int tamanho = (int) fileCompra.length();
					if(tamanho != 0){
						ListarCompra listaCompra = new ListarCompra(Menu.this);
						listaCompra.setVisible(true);
						Menu.this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Faça uma compra primeiro");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Faça uma compra primeiro");
				}
			}
		});
		btnListarVenda.setBackground(Color.WHITE);
		btnListarVenda.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnListarVenda.setBounds(260, 227, 241, 29);
		contentPane.add(btnListarVenda);
	}
	
	public void carregarArquivosJogo(){
		try{
			String nomeArquivoJogo = "cadProduto.txt";
			
			File arquivoJogo = new File(nomeArquivoJogo);
			FileInputStream fisJogo = new FileInputStream(arquivoJogo);
			InputStreamReader isrJogo = new InputStreamReader(fisJogo);
			BufferedReader brJogo = new BufferedReader(isrJogo);
			
			String linhaJogo = brJogo.readLine();
			
			while(linhaJogo != null){
				String[] obj = linhaJogo.split(";");
				//System.out.println(obj[1] +" "+obj[13]);
				jogo = new Jogo(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6], obj[7], obj[8], obj[9], obj[10], obj[11], obj[12], obj[13]);
				//System.out.println(obj[0] + " " + obj[1] + " " + obj[2]+ " " + obj[3] + " " + obj[4]+ " " + obj[5]+ " " + obj[6]+ " " + obj[7]+ " " + obj[8]+ " " + obj[9]+ " " + obj[10] + " " + obj[11]+ " " + obj[12]+ " " + obj[13]);
				arrayJogo.add(jogo);
				linhaJogo = brJogo.readLine();
			}
			brJogo.close();
			isrJogo.close();
			fisJogo.close();
			
			String nomeArquivoCliente = "cadCliente.txt";
			
			File arquivoCliente = new File(nomeArquivoCliente);
			FileInputStream fisCliente = new FileInputStream(arquivoCliente);
			InputStreamReader isrCliente = new InputStreamReader(fisCliente);
			BufferedReader brCliente = new BufferedReader(isrCliente);
			
			String linhaCliente = brCliente.readLine();
			
			while(linhaCliente != null){
				String[] obj = linhaCliente.split(";");
				cli = new Cliente(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6], obj[7], obj[8], obj[9], obj[10], obj[11]);
				arrayCliente.add(cli);
				linhaCliente = brCliente.readLine();
			}
			brCliente.close();
			isrCliente.close();
			fisCliente.close();
			
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Erro");
		}catch(IOException o){
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}
}