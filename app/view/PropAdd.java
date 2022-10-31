package app.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PropAdd extends JPanel {
	private JTextField txtCep;
	private JTextField txtEstado;

	/**
	 * Create the panel.
	 */
	public PropAdd() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registro de Propriedades");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitulo.setBounds(240, 37, 270, 44);
		add(lblTitulo);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCep.setBounds(172, 152, 72, 23);
		add(lblCep);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstado.setBounds(172, 192, 72, 23);
		add(lblEstado);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNmero.setBounds(172, 232, 72, 23);
		add(lblNmero);
		
		JLabel lblRegio = new JLabel("Região:");
		lblRegio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegio.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblRegio.setBounds(172, 272, 72, 23);
		add(lblRegio);
		
		txtCep = new JTextField();
		txtCep.setBounds(280, 152, 120, 19);
		add(txtCep);
		txtCep.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(280, 193, 120, 19);
		add(txtEstado);
		
		JSpinner spnNumero = new JSpinner();
		spnNumero.setBounds(280, 233, 120, 19);
		add(spnNumero);
		
		JComboBox cmbRegiao = new JComboBox();
		cmbRegiao.setBounds(280, 272, 120, 19);
		add(cmbRegiao);
		
		JButton btnVoltar = 	new JButton("Voltar");
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRegistro.setBounds(460, 404, 110, 33);
		add(btnRegistro);

	}
}
