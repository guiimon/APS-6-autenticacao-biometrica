package app.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Logged extends JPanel {
	//
	private JLabel lblBemvindo;
	private JLabel lblFuncao;
	/**
	 * Create the panel.
	 */
	public Logged() {
		setLayout(null);
		
		lblBemvindo = new JLabel("Bem vindo, ");
		lblBemvindo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblBemvindo.setBounds(64, 46, 154, 18);
		add(lblBemvindo);
		
		lblFuncao = new JLabel("");
		lblFuncao.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFuncao.setBounds(552, 47, 154, 18);
		add(lblFuncao);
		
		JLabel lblDescricao = new JLabel("Utilize o menu superior para navegar entre as telas do programa.");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescricao.setBounds(107, 427, 536, 18);
		add(lblDescricao);
		

	}
	
	public void resetTexto() {
		lblBemvindo.setText("Bem vindo, ");
		lblFuncao.setText("");
	}
	
	public void setTexto(String nome, String cargo) {
		resetTexto();
		lblBemvindo.setText(lblBemvindo.getText()+nome);
		lblFuncao.setText(cargo);
	}
	
	
	
}
