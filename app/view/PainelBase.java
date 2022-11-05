package app.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import app.model.Propriedade;
import app.model.Regiao;
import app.model.Responsavel;
import app.model.Usuario;


public class PainelBase extends JPanel {
	protected static CardLayout cl;
	protected static JPanel MainPanel;
	protected static Propriedade prop;
	protected static Regiao regi;
	protected static Responsavel resp;
	protected static Usuario user;
	/**
	 * Create the panel.
	 */
	public void setCard(CardLayout cl, JPanel Main){
        PainelBase.cl = cl;
        PainelBase.MainPanel = Main;
    }
	
	public void setPropriedade(Propriedade prop) {
		PainelBase.prop = prop;
	}
	
	public Propriedade getPropriedade() {
		return prop;
	}
	
	public void setRegiao(Regiao regi){
		PainelBase.regi = regi;
	}
	
	public Regiao getRegiao() {
		return regi;
	}
	
	public void setResponsavel(Responsavel resp) {
		PainelBase.resp = resp;
	}
	
	public Responsavel getResponsavel() {
		return resp;
	}
	
	public void setUsuario(Usuario user) {
		PainelBase.user = user;
	}
	
	public Usuario getUsuario() {
		return user;
	}
}
