package app.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.control.DBConnect;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class JanelaTeste2 extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaTeste2 frame = new JanelaTeste2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public JanelaTeste2() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Tela de Login");
		lblTitulo.setBounds(260, 10, 80, 13);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo);
		
		lblImagem = new JLabel("teste");
		lblImagem.setBounds(50, 55, 500, 321);
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblImagem);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCarregarListener();
			}
		});
		btnCarregar.setBounds(260, 386, 85, 21);
		getContentPane().add(btnCarregar);
		
		
	}
	
	private DBConnect db = new DBConnect();
	//partes da janela
	private	JLabel lblImagem;
	
	private void btnCarregarListener() {
		InputStream input = null;
		input = db.Imagem("Jorge Jorge");
		File arquivo = new File("biometria.png");
		try {
			if(!input.equals(null)) {
				FileOutputStream output = new FileOutputStream(arquivo);
				byte[] data = new byte[1024];
				while(input.read(data)>0) {
					output.write(data);
				}
				String caminho = arquivo.getAbsolutePath();
				System.out.println(arquivo.getAbsolutePath());
				//ImageIcon imagem = new ImageIcon(caminho);
				Image imagem = ImageIO.read(arquivo);
				Image novaImagem = imagem.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon icone = new ImageIcon(novaImagem);
				lblImagem.setIcon(icone);
			} else {
				//mensagem de erro.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
