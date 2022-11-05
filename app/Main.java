package app;

import app.view.Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
