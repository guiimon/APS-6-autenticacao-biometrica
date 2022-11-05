package app.view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import app.control.ResponsavelDAO;
import app.model.Responsavel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class RespEdit extends PainelBase {
	//
	private ResponsavelDAO dao = new ResponsavelDAO();
	//
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtIdade;
	private JTextField txtNascimento;
	private JComboBox<String> cbxPropriedade;

	/**
	 * Create the panel.
	 */
	public RespEdit() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				carregaPropriedade();
				carregarDados(getResponsavel());
			}
		});
		setLayout(null);
		
		JLabel lblEditorDeResponsveis = new JLabel("Editor de Responsáveis");
		lblEditorDeResponsveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorDeResponsveis.setFont(new Font("Calibri", Font.BOLD, 25));
		lblEditorDeResponsveis.setBounds(240, 37, 270, 44);
		add(lblEditorDeResponsveis);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblId.setBounds(172, 152, 72, 23);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(280, 152, 182, 19);
		add(txtId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(172, 192, 72, 23);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(280, 192, 182, 19);
		add(txtNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCPF.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCPF.setBounds(172, 232, 72, 23);
		add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(280, 233, 182, 19);
		add(txtCPF);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblIdade.setBounds(89, 272, 155, 23);
		add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(282, 273, 180, 19);
		add(txtIdade);
		
		JLabel lblNascimento = new JLabel("Data de Nascimento:");
		lblNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNascimento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNascimento.setBounds(89, 312, 155, 23);
		add(lblNascimento);
		
		txtNascimento = new JTextField();
		txtNascimento.setColumns(10);
		txtNascimento.setBounds(280, 312, 180, 19);
		add(txtNascimento);
		
		JLabel lblPropriedade = new JLabel("Propriedade:");
		lblPropriedade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropriedade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPropriedade.setBounds(113, 352, 131, 23);
		add(lblPropriedade);
		
		cbxPropriedade = new JComboBox<String>();
		cbxPropriedade.setBounds(280, 352, 182, 19);
		add(cbxPropriedade);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVoltarActionPerformed();
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarActionPerformed();
			}
		});
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnEditar.setBounds(460, 404, 110, 33);
		add(btnEditar);
		
	}
	
	private void carregarDados(Responsavel resp) {
		txtId.setText(resp.getId()+"");
		txtNome.setText(resp.getNome());
		txtCPF.setText(resp.getCpf());
		txtIdade.setText(resp.getIdade()+"");
		txtNascimento.setText(resp.getDataNasc());
		cbxPropriedade.setSelectedIndex(resp.getPropriedade());
	}
	
	private void btnEditarActionPerformed() {
		if(cbxPropriedade.getSelectedIndex()!=0) {
			if(!txtNome.getText().equals("")&!txtCPF.getText().equals("")&!txtNascimento.getText().equals("")) {
				try {
					dao.UpdateResponsavel(new Responsavel(Integer.parseInt(txtId.getText()),txtNome.getText(), txtCPF.getText(), Integer.parseInt(txtIdade.getText()), txtNascimento.getText(), cbxPropriedade.getSelectedIndex()));
					JOptionPane.showMessageDialog(this, "Responsável editado com êxito.");
					cl.show(MainPanel, "TelaRespView");
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
	
	private void carregaPropriedade() {
		try {
			cbxPropriedade.setModel(dao.pesquisaPropriedade());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possivel efetuar conexão ao banco de dados\nVerifique sua conexão.");
		}
	}
	
	private void btnVoltarActionPerformed() {
		cl.show(MainPanel, "TelaRespView");
	}
	
}
