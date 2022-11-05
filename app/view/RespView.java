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

import app.control.ResponsavelDAO;
import app.model.Responsavel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RespView extends PainelBase {
	ResponsavelDAO dao = new ResponsavelDAO();
	
	private JTable dataTable;

	/**
	 * Create the panel.
	 */
	public RespView() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				carrega();
			}
		});
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Visualização de Responsáveis");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitulo.setBounds(195, 37, 360, 44);
		add(lblTitulo);
		
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
				"ID", "Nome", "Cpf", "Idade", "Data Nascimento", "Propriedade"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
	
	private Responsavel passarDados() {
		Responsavel resultado = new Responsavel();
		int linha = dataTable.getSelectedRow();
		for(int i = 0; i<6; i++) {
			switch(i) {
			case 0:
				resultado.setId(Integer.parseInt(dataTable.getModel().getValueAt(linha, i).toString()));
				break;
			case 1:
				resultado.setNome(dataTable.getModel().getValueAt(linha, i).toString());
				break;
			case 2:
				resultado.setCpf(dataTable.getModel().getValueAt(linha, i).toString());
				break;
			case 3:
				resultado.setIdade(Integer.parseInt(dataTable.getModel().getValueAt(linha, i).toString()));
				break;
			case 4:
				resultado.setDataNasc(dataTable.getModel().getValueAt(linha, i).toString());
				break;
			case 5:
				resultado.setPropriedade(Integer.parseInt(dataTable.getModel().getValueAt(linha, i).toString()));
				break;
			}
		}
		return resultado;
	}
	
	private void btnEditarActionPerformed() {
		if(!dataTable.getSelectionModel().isSelectionEmpty()) {
			setResponsavel(passarDados());
			cl.show(MainPanel, "TelaRespEdit");
		}else {
			JOptionPane.showMessageDialog(this, "Selecione algum elemento da lista.");
		}		
	}
	
	private void btnVoltarActionPerformed(){
		cl.show(MainPanel, "TelaLogado");
	}
	
}
