package app.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.control.UsuarioDAO;
import app.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class UserView extends PainelBase {
	UsuarioDAO dao = new UsuarioDAO();
	
	private JTable dataTable;

	/**
	 * Create the panel.
	 */
	public UserView() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				carrega();
			}
		});
		setLayout(null);
		
		JLabel lblVisualizaoDeUsurios = new JLabel("Visualização de Usuários");
		lblVisualizaoDeUsurios.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizaoDeUsurios.setFont(new Font("Calibri", Font.BOLD, 25));
		lblVisualizaoDeUsurios.setBounds(10, 37, 730, 44);
		add(lblVisualizaoDeUsurios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(54, 69, 622, 315);
		add(scrollPane);
		
		dataTable = new JTable();
		dataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Login", "Nome", "Cargo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		dataTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		scrollPane.setViewportView(dataTable);
		
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
		btnEditar.setBounds(460, 404, 100, 33);
		add(btnEditar);
		
	}
	
	public JTable getTable() {
		return dataTable;
	}
	
	public void carrega() {
		try {
			dao.visualizar(this);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	private Usuario passarDados() {
		Usuario resultado = new Usuario();
		int linha = dataTable.getSelectedRow();
		for(int i = 0; i<4; i++) {
			switch(i) {
			case 0:
				resultado.setId(Integer.parseInt(dataTable.getModel().getValueAt(linha, i).toString()));
				break;
			case 1:
				resultado.setLogin(dataTable.getModel().getValueAt(linha, i).toString());
				break;
			case 2:
				resultado.setNome(dataTable.getModel().getValueAt(linha, i).toString());
				break;
			case 3:
				resultado.setCargo(dataTable.getModel().getValueAt(linha, i).toString());
				break;
			}
		}
		return resultado;
	}
	
	private void btnVoltarActionPerformed(){
		cl.show(MainPanel, "TelaLogado");
	}
	
	private void btnEditarActionPerformed() {
		if(!dataTable.getSelectionModel().isSelectionEmpty()) {
			setUsuario(passarDados());
			cl.show(MainPanel, "TelaUserEdit");
		}else {
			JOptionPane.showMessageDialog(this, "Selecione algum elemento da lista.");
		}
	}
}
