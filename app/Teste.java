package app;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;

import app.control.DBConnect;
import app.view.JanelaTeste2;

public class Teste {

	public static void main(String[] args) {
		
		JanelaTeste2 janela = new JanelaTeste2();
		janela.setVisible(true);
		// TODO Auto-generated method stub
		/*
		DBConnect db = new DBConnect();
		
		try {
			boolean b = db.VerificarConection();
			System.out.println(b);
			
			JFileChooser janela = new JFileChooser();
			janela.showOpenDialog(null);
			File arquivo = janela.getSelectedFile();
			FileInputStream stream = new FileInputStream(arquivo);
			db.Inserir("jorge", "Jorge Jorge", stream, "Nivel 2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

}
