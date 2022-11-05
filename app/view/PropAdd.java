package app.view;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import app.control.PropriedadeDAO;
import app.model.Propriedade;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PropAdd extends PainelBase {
	private PropriedadeDAO dao = new PropriedadeDAO();
	private JComboBox<String> cbxRegiao;
	private JSpinner spnNumero;
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
		txtCep.setBounds(280, 152, 150, 19);
		add(txtCep);
		txtCep.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(280, 193, 150, 19);
		add(txtEstado);
		
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnNumero.setBounds(280, 233, 150, 19);
		add(spnNumero);
		
		cbxRegiao = new JComboBox<String>();
		cbxRegiao.setBounds(280, 272, 150, 19);
		add(cbxRegiao);
		
		JButton btnVoltar = 	new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVoltarActionPerformed();
			}
		});
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
	

	}
	
	public void start() {
		txtCep.setText("");
		txtEstado.setText("");
		spnNumero.setValue(0);
		carregaRegiao();
	}
	
	private void carregaRegiao() {
		try {
			cbxRegiao.setModel(dao.pesquisaRegiao());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possivel efetuar conexão ao banco de dados\nVerifique sua conexão.");
		}
	}
	
	private void btnVoltarActionPerformed(){
		cl.show(MainPanel, "TelaLogado");
	}
	
	private void btnRegistroActionPerformed() {
		if(cbxRegiao.getSelectedIndex()!=0) {
			if(!txtCep.getText().equals("")&!txtEstado.getText().equals("")&!spnNumero.getValue().equals(0))
			try {
				dao.InserirPropriedade(new Propriedade(txtCep.getText(), txtEstado.getText(), (Integer)spnNumero.getValue(), cbxRegiao.getSelectedIndex()));
				JOptionPane.showMessageDialog(this, "Propriedade registrada com êxito.");
				start();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Preencha todos os valores.");
			}
		}else {
			JOptionPane.showMessageDialog(this, "Selecione uma Região para a propriedade.");
		}
	}
	
}
