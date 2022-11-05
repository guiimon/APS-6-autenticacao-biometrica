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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

public class PropEdit extends PainelBase {
	//
	private PropriedadeDAO dao = new PropriedadeDAO();
	
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtId;
	private JSpinner spnNumero;
	private JComboBox<String> cbxRegiao;
	
	/**
	 * Create the panel.
	 */
	public PropEdit() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				carregaRegiao();
				carregarDados(getPropriedade());
			}
		});
		setLayout(null);
		
		JLabel lblEditorDePropriedades = new JLabel("Editor de Propriedades");
		lblEditorDePropriedades.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorDePropriedades.setFont(new Font("Calibri", Font.BOLD, 25));
		lblEditorDePropriedades.setBounds(258, 52, 270, 44);
		add(lblEditorDePropriedades);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCep.setBounds(190, 207, 72, 23);
		add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(298, 207, 150, 19);
		add(txtCep);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstado.setBounds(190, 247, 72, 23);
		add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(298, 247, 150, 19);
		add(txtEstado);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNmero.setBounds(190, 287, 72, 23);
		add(lblNmero);
		
		spnNumero = new JSpinner();
		spnNumero.setBounds(298, 287, 150, 19);
		add(spnNumero);
		
		JLabel lblRegio = new JLabel("Região:");
		lblRegio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegio.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblRegio.setBounds(190, 327, 72, 23);
		add(lblRegio);
		
		cbxRegiao = new JComboBox<String>();
		cbxRegiao.setBounds(298, 327, 150, 19);
		add(cbxRegiao);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblId.setBounds(190, 167, 72, 23);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(298, 167, 150, 19);
		add(txtId);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				btnVoltarActionPerformed();
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				btnEditarActionPerformed();
			}
		});
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnEditar.setBounds(460, 404, 100, 33);
		add(btnEditar);

	}
	
	private void carregarDados(Propriedade prop) {
		txtId.setText(prop.getId()+"");
		txtCep.setText(prop.getCep());
		txtEstado.setText(prop.getEstado());
		spnNumero.setValue(prop.getNumero());
		cbxRegiao.setSelectedIndex(prop.getRegiao());
	}
	
	private void carregaRegiao() {
		try {
			cbxRegiao.setModel(dao.pesquisaRegiao());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possivel efetuar conexão ao banco de dados\nVerifique sua conexão.");
		}
	}
	
	private void btnVoltarActionPerformed() {
		cl.show(MainPanel, "TelaPropView");
	}
	
	private void btnEditarActionPerformed(){
		try {
			spnNumero.commitEdit();
			if(cbxRegiao.getSelectedIndex()!=0) {
				if(!txtId.getText().equals("")&!txtCep.getText().equals("")&!txtEstado.getText().equals("")&!spnNumero.getValue().equals(0))
				try {
					dao.UpdatePropriedade(new Propriedade(Integer.parseInt(txtId.getText()),txtCep.getText(), txtEstado.getText(), (Integer)spnNumero.getValue(), cbxRegiao.getSelectedIndex()));
					JOptionPane.showMessageDialog(this, "Propriedade atualizada com êxito.");
					cl.show(MainPanel, "TelaPropView");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Preencha todos os valores.");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Selecione uma Região para a propriedade.");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Coloque um valor numérico em Numero.");
		}
		
	}
}
