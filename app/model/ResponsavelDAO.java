package app.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import app.control.DBConnect;
import app.view.RespView;

public class ResponsavelDAO extends DBConnect{
	public boolean InserirResponsavel(Responsavel resp){	
		String query = "insert into responsavel (idResponsaveis, nome, cpf, idade, dataNasc, propriedade)";
		query+= "values (?,?,?,?,?,?);";
		
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setInt(1, 0);
			stmt.setString(2, resp.getNome());
			stmt.setString(3, resp.getDataNasc());
			stmt.setInt(4, resp.getIdade());
			stmt.setString(5,resp.getDataNasc());
			stmt.setInt(6, resp.getPropriedade());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public boolean UpdateResponsavel(Responsavel resp) {
		String query = "update responsavel set nome = ?, cpf = ?, idade = ?, dataNasc = ?, propriedade = ?";
		query+= "where idResponsaveis = ?";
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setString(1, resp.getNome());
			stmt.setString(2, resp.getCpf());
			stmt.setInt(3, resp.getIdade());
			stmt.setString(4, resp.getDataNasc());
			stmt.setInt(5, resp.getPropriedade());
			stmt.setInt(6, resp.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public ArrayList<Responsavel> LerResponsavel() throws Exception{
		ArrayList<Responsavel> resultado = new ArrayList<Responsavel>();
		String query = "select * from responsavel;";
		this.getConnection(user, password, porta);
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.add(new Responsavel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6)));
		}
		return resultado;
	}
	
	public void visualizar(RespView janela) throws Exception{ //ajustar o nome da janela
		ArrayList<Responsavel> lista = LerResponsavel();
		DefaultTableModel modelo = (DefaultTableModel) janela.getTable().getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < lista.size(); i++) {
			Object[] linha = new Object[6];
			linha[0] = lista.get(i).getId();
			linha[1] = lista.get(i).getNome();
			linha[2] = lista.get(i).getCpf();
			linha[3] = lista.get(i).getIdade();
			linha[4] = lista.get(i).getDataNasc();
			linha[5] = lista.get(i).getPropriedade();
			modelo.addRow(linha);
		}
		janela.getTable().setModel(modelo);
	}
}
