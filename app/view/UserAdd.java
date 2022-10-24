package app.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class UserAdd extends JPanel {
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtBiometria;
	/**
	 * Create the panel.
	 */
	public UserAdd() {
setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registro de Usuários");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitulo.setBounds(240, 37, 270, 44);
		add(lblTitulo);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogin.setBounds(172, 152, 72, 23);
		add(lblLogin);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(172, 192, 72, 23);
		add(lblNome);
		
		JLabel lblBiometria = new JLabel("Biometria");
		lblBiometria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBiometria.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBiometria.setBounds(89, 232, 155, 23);
		add(lblBiometria);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCargo.setBounds(113, 310, 131, 23);
		add(lblCargo);
		
		txtCep = new JTextField();
		txtCep.setBounds(280, 152, 230, 19);
		add(txtCep);
		txtCep.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(280, 193, 230, 19);
		add(txtEstado);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRegistro.setBounds(460, 404, 110, 33);
		add(btnRegistro);
		
		txtBiometria = new JTextField();
		txtBiometria.setEditable(false);
		txtBiometria.setBounds(280, 233, 230, 19);
		add(txtBiometria);
		txtBiometria.setColumns(10);
		
		JButton btnNewButton = new JButton("Escolher Arquivo");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNewButton.setBounds(309, 262, 173, 21);
		add(btnNewButton);
		
		JComboBox cbxCargo = new JComboBox();
		cbxCargo.setModel(new DefaultComboBoxModel(new String[] {"Escolha a Função", "1 - Funionário", "2 - Diretor de Divisão", "3 - Ministro do Meio Ambiente"}));
		cbxCargo.setBounds(280, 310, 230, 21);
		add(cbxCargo);
	}

}
