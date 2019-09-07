package iftm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaSplash extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSplash frame = new TelaSplash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaSplash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 311);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar pbSplash = new JProgressBar();
		pbSplash.setStringPainted(true);
		pbSplash.setBounds(124, 246, 313, 26);
		contentPane.add(pbSplash);
		
		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setIcon(new ImageIcon("C:\\Users\\alany\\Desktop\\java\\trabalhoPoo\\img\\GameStopLogo4.jpg"));
		lblImagemFundo.setBounds(0, 0, 559, 272);
		contentPane.add(lblImagemFundo);
		
		new Thread(){
			
			public void run(){
				for(int i = 0; i < 101; i++){
					try {
						sleep(60);
						pbSplash.setValue(i);
						if(i == 100){
							Menu menu = new Menu();
							menu.setVisible(true);
							TelaSplash.this.dispose();
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}
}