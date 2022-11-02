package app.view;

import javax.swing.JPanel;
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

public class UserView extends JPanel {
	UsuarioDAO dao = new UsuarioDAO();
	
	private JTable dataTable;

	/**
	 * Create the panel.
	 */
	public UserView() {
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
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
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
	
}
