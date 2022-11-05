package app.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import app.model.Regiao;
import app.view.RegView;

public class RegiaoDAO extends DBConnect{
	
	public boolean InserirRegiao(Regiao reg){	
		String query = "insert into regiao (idRegioes, identificacao, impacto, ocorrencias)";
		query+= "values (?,?,?,?);";
		
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setInt(1, 0);
			stmt.setString(2, reg.getIdentificacao());
			stmt.setString(3,reg.getImpacto());
			stmt.setInt(4, reg.getOcorrencias());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public boolean UpdateRegiao(Regiao reg) {
		String query = "update regiao set identificacao = ?, impacto = ?, ocorrencias = ? ";
		query+= "where idRegioes = ?";
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setString(1, reg.getIdentificacao());
			stmt.setString(2, reg.getImpacto());
			stmt.setInt(3, reg.getOcorrencias());
			stmt.setInt(4, reg.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public ArrayList<Regiao> LerRegiao() throws Exception{
		ArrayList<Regiao> resultado = new ArrayList<Regiao>();
		String query = "select * from regiao;";
		this.getConnection(user, password, porta);
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.add(new Regiao(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
		return resultado;
	}
	
	public void visualizar(RegView janela) throws Exception{
		ArrayList<Regiao> lista = LerRegiao();
		DefaultTableModel modelo = (DefaultTableModel) janela.getTable().getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < lista.size(); i++) {
			Object[] linha = new Object[4];
			linha[0] = lista.get(i).getId();
			linha[1] = lista.get(i).getIdentificacao();
			linha[2] = lista.get(i).getImpacto();
			linha[3] = lista.get(i).getOcorrencias();
			modelo.addRow(linha);
		}
		janela.getTable().setModel(modelo);
	}
}
