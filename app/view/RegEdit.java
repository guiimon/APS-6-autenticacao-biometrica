package app.view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import app.control.RegiaoDAO;
import app.model.Regiao;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class RegEdit extends PainelBase {
	private RegiaoDAO dao = new RegiaoDAO();
	
	private JTextField txtIdentificacao;
	private JTextField txtImpacto;
	private JTextField txtQuantidade;
	private JTextField txtId;

	/**
	 * Create the panel.
	 */
	public RegEdit() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				carregarDados(getRegiao());
			}
		});
		setLayout(null);
		
		JLabel lblEditorDeRegies = new JLabel("Editor de Regiões");
		lblEditorDeRegies.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorDeRegies.setFont(new Font("Calibri", Font.BOLD, 25));
		lblEditorDeRegies.setBounds(267, 37, 216, 44);
		add(lblEditorDeRegies);
		
		JLabel lblNewLabel_1 = new JLabel("Região: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(172, 192, 72, 23);
		add(lblNewLabel_1);
		
		txtIdentificacao = new JTextField();
		txtIdentificacao.setColumns(10);
		txtIdentificacao.setBounds(262, 192, 153, 21);
		add(txtIdentificacao);
		
		JLabel lblNewLabel_1_1 = new JLabel("Porcentagem de Impacto:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(37, 232, 207, 25);
		add(lblNewLabel_1_1);
		
		txtImpacto = new JTextField();
		txtImpacto.setColumns(10);
		txtImpacto.setBounds(262, 232, 153, 21);
		add(txtImpacto);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade de ocorrencias:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 272, 234, 25);
		add(lblNewLabel_1_1_1);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(262, 272, 153, 21);
		add(txtQuantidade);
		
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
				btnEditorActionPerformed();
			}
		});
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnEditar.setBounds(460, 404, 110, 33);
		add(btnEditar);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(172, 152, 72, 23);
		add(lblNewLabel_1_2);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(262, 152, 153, 21);
		add(txtId);

	}
	
	private void carregarDados(Regiao reg) {
		txtId.setText(reg.getId()+"");
		txtIdentificacao.setText(reg.getIdentificacao());
		txtImpacto.setText(reg.getImpacto());
		txtQuantidade.setText(reg.getOcorrencias()+"");
	}
	
	
	private void btnVoltarActionPerformed() {
		cl.show(MainPanel, "TelaRegView");
	}
	
	private void btnEditorActionPerformed(){
		if(!txtId.getText().equals("")&!txtIdentificacao.getText().equals("") & !txtImpacto.getText().equals("") & !txtQuantidade.getText().equals("")) {
			try{
				dao.UpdateRegiao(new Regiao(Integer.parseInt(txtId.getText()),txtIdentificacao.getText(),txtImpacto.getText(),Integer.parseInt(txtQuantidade.getText())));
				JOptionPane.showMessageDialog(this, "Região atualizada com êxito.");
				cl.show(MainPanel, "TelaRegView");
			}catch(Exception e){
				JOptionPane.showMessageDialog(this, "Coloque um valor numérico na quantidade.");
			}
		}else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
		}
	}

}
