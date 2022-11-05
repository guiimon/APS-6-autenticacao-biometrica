package app.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import app.model.Usuario;
import app.view.UserView;

public class UsuarioDAO extends DBConnect{
	public void InserirUsuario(Usuario usr) throws Exception{	
		String query = "insert into usuario (iduser, login, biometria, nome, cargo)";
		query+= "values (?,?,?,?,?);";
		this.getConnection(user, password, porta);
		PreparedStatement stmt = con.prepareStatement(query);
		//Preenchendo os valores de ? do Statement
		stmt.setInt(1, 0);
		stmt.setString(2, usr.getLogin());
		stmt.setBinaryStream(3, usr.getInput());
		stmt.setString(4, usr.getNome());
		stmt.setString(5,usr.getCargo());
		stmt.executeUpdate();
		stmt.close();
		con.close();
	}
	
	public boolean UpdateUsuarioBiometria(Usuario usr) {
		String query = "update usuario set login = ?, biometria = ?, nome = ?, cargo = ? ";
		query+= "where iduser = ?";
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setString(1, usr.getLogin());
			stmt.setBinaryStream(2, usr.getInput());
			stmt.setString(3, usr.getNome());
			stmt.setString(4, usr.getCargo());
			stmt.setInt(5, usr.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public boolean UpdateUsuario(Usuario usr) {
		String query = "update usuario set login = ?, nome = ?, cargo = ? ";
		query+= "where iduser = ?";
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setString(1, usr.getLogin());
			stmt.setString(2, usr.getNome());
			stmt.setString(3, usr.getCargo());
			stmt.setInt(4, usr.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public ArrayList<Usuario> LerUsuario() throws Exception{
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		String query = "select * from usuario;";
		this.getConnection(user, password, porta);
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.add(new Usuario(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5)));
		}
		return resultado;
	}
	
	public void visualizar(UserView janela) throws Exception{ //ajustar o nome da janela
		ArrayList<Usuario> lista = LerUsuario();
		DefaultTableModel modelo = (DefaultTableModel) janela.getTable().getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < lista.size(); i++) {
			Object[] linha = new Object[4];
			linha[0] = lista.get(i).getId();
			linha[1] = lista.get(i).getLogin();
			linha[2] = lista.get(i).getNome();
			linha[3] = lista.get(i).getCargo();
			modelo.addRow(linha);
		}
		janela.getTable().setModel(modelo);
	}
	
	
	public Usuario RetornaUsuario(String usuario) {
		String query = "select * from usuario where login = ?"; //não especifica qual valor será adicionado
		Usuario userDB = null;
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, usuario); //após passar para o PreparedStatement seta o valor no campo ?
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userDB = new Usuario();
				userDB.setNome(rs.getString("nome"));
				userDB.setLogin(rs.getString("login"));
				userDB.setCargo(rs.getString("cargo"));
				userDB.setInput(rs.getBinaryStream("biometria"));
			}
			stmt.close();
			con.close();
			return userDB;
		} catch (Exception e) {
			e.printStackTrace();
			return userDB;
		}


	}
	
	
	
}
