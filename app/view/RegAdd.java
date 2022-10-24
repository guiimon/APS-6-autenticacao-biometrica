package app.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegAdd extends JPanel {
	private JTextField txtIdentificacao;
	private JTextField txtImpacto;
	private JTextField txtQuantidade;

	/**
	 * Create the panel.
	 */
	public RegAdd() {
		
		JLabel lblTitulo = new JLabel("Registro de Regiões");
		lblTitulo.setBounds(267, 37, 216, 44);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Região: ");
		lblNewLabel_1.setBounds(172, 152, 72, 23);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		txtIdentificacao = new JTextField();
		txtIdentificacao.setBounds(262, 152, 153, 21);
		txtIdentificacao.setColumns(10);
		
		txtImpacto = new JTextField();
		txtImpacto.setBounds(262, 192, 153, 21);
		txtImpacto.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Porcentagem de Impacto:");
		lblNewLabel_1_1.setBounds(37, 192, 207, 25);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(262, 232, 153, 21);
		txtQuantidade.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade de ocorrencias:");
		lblNewLabel_1_1_1.setBounds(10, 232, 234, 25);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(169, 404, 100, 33);
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(460, 404, 110, 33);
		btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		setLayout(null);
		add(btnVoltar);
		add(btnRegistro);
		add(lblTitulo);
		add(lblNewLabel_1);
		add(lblNewLabel_1_1);
		add(lblNewLabel_1_1_1);
		add(txtImpacto);
		add(txtIdentificacao);
		add(txtQuantidade);

	}

}