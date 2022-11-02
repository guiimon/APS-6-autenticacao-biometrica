package app.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.control.ResponsavelDAO;
import app.model.Responsavel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RespAdd extends JPanel {
	private ResponsavelDAO dao = new ResponsavelDAO();
	
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtIdade;
	private JComboBox<String> cbxPropriedade;
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
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCPF.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCPF.setBounds(172, 192, 72, 23);
		add(lblCPF);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblIdade.setBounds(89, 232, 155, 23);
		add(lblIdade);
		
		JLabel lblPropriedade = new JLabel("Propriedade:");
		lblPropriedade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropriedade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPropriedade.setBounds(113, 312, 131, 23);
		add(lblPropriedade);
		
		txtNome = new JTextField();
		txtNome.setBounds(280, 152, 182, 19);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(280, 193, 182, 19);
		add(txtCPF);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistroActionPerformed();
			}
		});
		btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRegistro.setBounds(460, 404, 110, 33);
		add(btnRegistro);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(282, 233, 180, 19);
		add(txtIdade);
		txtIdade.setColumns(10);
		
		cbxPropriedade = new JComboBox<String>();
		cbxPropriedade.setBounds(280, 312, 182, 19);
		add(cbxPropriedade);
		
		JLabel lblNascimento = new JLabel("Data de Nascimento:");
		lblNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNascimento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNascimento.setBounds(89, 272, 155, 23);
		add(lblNascimento);
		
		txtNascimento = new JTextField();
		txtNascimento.setColumns(10);
		txtNascimento.setBounds(280, 272, 180, 19);
		add(txtNascimento);
	}
	
	public void start() {
		txtNome.setText("");
		txtCPF.setText("");
		txtIdade.setText("");
		txtNascimento.setText("");
		carregaPropriedade();
	}
	
	private void carregaPropriedade() {
		try {
			cbxPropriedade.setModel(dao.pesquisaPropriedade());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possivel efetuar conexão ao banco de dados\nVerifique sua conexão.");
		}
	}
	
	private void btnRegistroActionPerformed() {
		if(cbxPropriedade.getSelectedIndex()!=0) {
			if(!txtNome.getText().equals("")&!txtCPF.getText().equals("")&!txtNascimento.getText().equals("")) {
				try {
					dao.InserirResponsavel(new Responsavel(txtNome.getText(), txtCPF.getText(), Integer.parseInt(txtIdade.getText()), txtNascimento.getText(), cbxPropriedade.getSelectedIndex()));
					JOptionPane.showMessageDialog(this, "Responsável cadastrado com êxito.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e);
					
				}
			}else {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
			}
		}else {
			JOptionPane.showMessageDialog(this, "Selecione uma propriedade.");
		}
	}
}
