package app.control;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	protected String user = "root";
	protected String password = "1234";
	protected String porta = "3306";
	
	protected Connection con;
	
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
	
	public boolean PesquisarUsuario(String login){
		String query = "select * from usuario where login = ?";
		try {
			this.getConnection(user, password, porta);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean VerificarConection() throws Exception{
		getConnection(user, password, porta);
		boolean resposta = con.isValid(10);
		return resposta;
	}
	
	public void getConnection(String user, String password, String porta) throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:"+porta+"/aps6";
		//url += "?useTimezone=true&serverTimezone=UTC";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
	}
	
	
}
