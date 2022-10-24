package app.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RespAdd extends JPanel {
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtNascimento;
	
	/**
	 * Create the panel.
	 */
	public RespAdd() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registro de Responsáveis");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitulo.setBounds(240, 37, 270, 44);
		add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(172, 152, 72, 23);
		add(lblNome);
		
		JLabel lblEstado = new JLabel("CPF:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstado.setBounds(172, 192, 72, 23);
		add(lblEstado);
		
		JLabel lblNmero = new JLabel("Data de Nascimento:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNmero.setBounds(89, 232, 155, 23);
		add(lblNmero);
		
		JLabel lblRegio = new JLabel("Pripriedade:");
		lblRegio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegio.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblRegio.setBounds(113, 272, 131, 23);
		add(lblRegio);
		
		txtCep = new JTextField();
		txtCep.setBounds(280, 152, 120, 19);
		add(txtCep);
		txtCep.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(280, 193, 120, 19);
		add(txtEstado);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRegistro.setBounds(460, 404, 110, 33);
		add(btnRegistro);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(282, 233, 118, 19);
		add(txtNascimento);
		txtNascimento.setColumns(10);
		
		JComboBox cbxPropriedade = new JComboBox();
		cbxPropriedade.setBounds(280, 272, 120, 19);
		add(cbxPropriedade);
	}

}
