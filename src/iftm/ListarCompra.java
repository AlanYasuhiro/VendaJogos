package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCompra extends JFrame {

	private JPanel contentPane;
	private DefaultListModel modeloListarCompra;
	Menu janelaMenu;

	public ListarCompra(Menu janelaOrigem) {
		janelaMenu = janelaOrigem;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 234, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloListarCompra = new DefaultListModel();
		contentPane.setLayout(null);
		
		JLabel lblListarCompra = new JLabel("Listar Compra");
		lblListarCompra.setBounds(54, 23, 116, 20);
		lblListarCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblListarCompra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 199, 232);
		contentPane.add(scrollPane);
		
		JList list = new JList(modeloListarCompra);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(list);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaMenu.setVisible(true);
				ListarCompra.this.dispose();
			}
		});
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(67, 300, 89, 23);
		contentPane.add(btnVoltar);
		
		listarCompraJogo();
	}
	
	public void listarCompraJogo(){
	
		try{
				
			String nomeArquivo = "cadCompra.txt";
			
			File arquivo = new File(nomeArquivo);
			FileInputStream fis = new FileInputStream(arquivo);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			String linha = br.readLine();
			ArrayList<String> salvar = new ArrayList();
			while(linha != null){
				//String[] campos = linha.split(";");
				salvar.add(linha);
				linha = br.readLine();
			}
			
			for(int i = 0; i < salvar.size(); i++){	
				modeloListarCompra.addElement(salvar.get(i));
			}
		
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Erro");
		}catch(IOException o){
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}
}