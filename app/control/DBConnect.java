package app.control;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	private String user = "root";
	private String password = "1234";
	private String porta = "3306";
	
	private Connection con;
	
	public boolean Inserir(String login, String nome, FileInputStream arquivo, String cargo) {
		//Connection
				
		String query = "insert into usuario (iduser, login, biometria, nome, cargo)";
		query+= "values (?,?,?,?,?);";
		
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			//Preenchendo os valores de ? do Statement
			stmt.setInt(1, 2);
			stmt.setString(2, login);
			stmt.setBinaryStream(3, arquivo, arquivo.available());
			stmt.setString(4, nome);
			stmt.setString(5, cargo);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		}
		catch(Exception e) {	
			return false;
		}
	}
	
	public InputStream Imagem(String usuario) {
		String query = "select * from usuario where login = ?"; //não especifica qual valor será adicionado
		InputStream input = null;
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, usuario); //após passar para o PreparedStatement seta o valor no campo ?
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				input = rs.getBinaryStream("biometria");
			}
			stmt.close();
			con.close();
			return input;
		} catch (Exception e) {
			e.printStackTrace();
			return input;
		}
		
		
	}
	
	public boolean VerificarConection() throws Exception{
		getConnection(user, password, porta);
		try {
			boolean resposta = con.isValid(10);
			return resposta;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void getConnection(String user, String password, String porta) throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:"+porta+"/aps6";
		//url += "?useTimezone=true&serverTimezone=UTC";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
	}
	
	
}
