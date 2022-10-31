package app.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.model.RegiaoDAO;

import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class RegView extends JPanel {
	//
	RegiaoDAO dao = new RegiaoDAO();
	
	//Objetos internos do painel
	private JTable dataTable;
	
	/**
	 * Create the panel.
	 */
	public RegView() {
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(64, 69, 622, 315);
		add(scrollPane);
		
		dataTable = new JTable();
		dataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Identifica\u00E7\u00E3o", "Impacto", "Ocorrencias"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		dataTable.getColumnModel().getColumn(0).setResizable(false);
		dataTable.getColumnModel().getColumn(1).setResizable(false);
		dataTable.getColumnModel().getColumn(2).setResizable(false);
		dataTable.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(dataTable);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnEditar.setBounds(460, 404, 100, 33);
		add(btnEditar);
		
		JLabel lblVisualizaoDeRegies = new JLabel("Visualização de Regiões");
		lblVisualizaoDeRegies.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizaoDeRegies.setFont(new Font("Calibri", Font.BOLD, 25));
		lblVisualizaoDeRegies.setBounds(248, 37, 254, 44);
		add(lblVisualizaoDeRegies);
		
		
		
	}
	
	//Getters and Setters
	public JTable getTable() {
		return dataTable;
	}
	
	//Métodos
	public void carrega() {
		try {
			dao.visualizar(this);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
}