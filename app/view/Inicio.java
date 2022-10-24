package app.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	//Componentes visuais
	private JPanel MainPanel;
	private JTextField txtLogin;

	
	//Componentes Não Visuais
	private CardLayout cl;
	private Login telaLogin = new Login();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel LoginPanel = new JPanel();
		MainPanel.add(LoginPanel, "name_954692848652400");
		LoginPanel.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(300, 141, 150, 22);
		LoginPanel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(350, 109, 50, 13);
		LoginPanel.add(lblLogin);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmaActionPerformed();
			}
		});
		btnConfirma.setBounds(330, 225, 90, 21);
		LoginPanel.add(btnConfirma);
		
		//MainPanel.add(telaLogin, "TelaLogin");
	}
	
	private void btnConfirmaActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaLogin");
	}
}
