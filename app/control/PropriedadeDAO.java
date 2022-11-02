package app.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import app.view.PropView;

public class PropriedadeDAO extends DBConnect{
	
	
	public DefaultComboBoxModel<String> pesquisaRegiao() throws Exception{
		DefaultComboBoxModel<String> resultado = new DefaultComboBoxModel<String>();
		resultado.addElement("Escolha a regiao");
		String query = "select idRegioes, identificacao from regiao;";
		this.getConnection(user, password, porta);
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.addElement(rs.getInt(1)+" - "+rs.getString(2));
		}
		return resultado;
	}
	
	public boolean InserirPropriedade(Propriedade pro){	
		String query = "insert into propriedade (idpropriedades, cep, estado, num, regiao)";
		query+= "values (?,?,?,?,?);";
		
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setInt(1, 0);
			stmt.setString(2, pro.getCep());
			stmt.setString(3,pro.getEstado());
			stmt.setInt(4, pro.getNumero());
			stmt.setInt(5,pro.getRegiao());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public boolean UpdatePropriedade(Propriedade pro) {
		String query = "update propriedade set cep = ?, estado = ?, num = ?, regiao = ?";
		query+= "where idpropriedades = ?";
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setString(1, pro.getCep());
			stmt.setString(2, pro.getEstado());
			stmt.setInt(3, pro.getNumero());
			stmt.setInt(4, pro.getRegiao());
			stmt.setInt(5, pro.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public ArrayList<Propriedade> LerPropriedade() throws Exception{
		ArrayList<Propriedade> resultado = new ArrayList<Propriedade>();
		String query = "select * from propriedade;";
		this.getConnection(user, password, porta);
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.add(new Propriedade(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
		}
		return resultado;
	}
	
	public void visualizar(PropView janela) throws Exception{ 
		ArrayList<Propriedade> lista = LerPropriedade();
		DefaultTableModel modelo = (DefaultTableModel) janela.getTable().getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < lista.size(); i++) {
			Object[] linha = new Object[5];
			linha[0] = lista.get(i).getId();
			linha[1] = lista.get(i).getCep();
			linha[2] = lista.get(i).getEstado();
			linha[3] = lista.get(i).getNumero();
			linha[4] = lista.get(i).getRegiao();
			modelo.addRow(linha);
		}
		janela.getTable().setModel(modelo);
	}
}
