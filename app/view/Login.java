package app.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	//Parametros
	private CardLayout cl;
	JFileChooser janela = new JFileChooser();
	
	//Paineis de Exibição
	private RegAdd TelaRegAdd = new RegAdd();
	private PropAdd TelaPropAdd = new PropAdd();
	private RespAdd TelaRespAdd = new RespAdd();
	private UserAdd TelaUserAdd = new UserAdd();
	private JPanel MainPanel;
	
	
	JMenuBar menuBar;
	private JTextField txtLogin;
	
	
	/**
	 * @wbp.nonvisual location=383,554
	 */
	private final JLabel lblArquivo = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		setJMenuBar(menuBar);
		
		JMenu mnRegioes = new JMenu("Regiões");
		menuBar.add(mnRegioes);
		
		JMenuItem mntmRegAdd = new JMenuItem("Adicionar");
		mntmRegAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuRegAddActionPerformed();
			}
		});
		
		mnRegioes.add(mntmRegAdd);
		
		JMenuItem mntmRegView = new JMenuItem("Visualizar");
		mntmRegView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnRegioes.add(mntmRegView);
		
		JMenu mnPropriedades = new JMenu("Propriedades");
		menuBar.add(mnPropriedades);
		
		JMenuItem mntmPropAdd = new JMenuItem("Adicionar");
		mntmPropAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPropAddActionPerformed();
			}
		});
		mnPropriedades.add(mntmPropAdd);
		
		JMenuItem mntmPropView = new JMenuItem("Visualizar");
		mnPropriedades.add(mntmPropView);
		
		JMenu mnResponsaveis = new JMenu("Responsaveis");
		menuBar.add(mnResponsaveis);
		
		JMenuItem mntmRespAdd = new JMenuItem("Adicionar");
		mntmRespAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuRespAddActionPerformed();
			}
		});
		mnResponsaveis.add(mntmRespAdd);
		
		JMenuItem mntmRespView = new JMenuItem("Visualizar");
		mnResponsaveis.add(mntmRespView);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmUserAdd = new JMenuItem("Adicionar");
		mntmUserAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUserAddActionPerformed();
			}
		});
		mnUsuarios.add(mntmUserAdd);
		
		JMenuItem mntmUserView = new JMenuItem("Visualizar");
		mnUsuarios.add(mntmUserView);
		
		JLabel lblNewLabel = new JLabel("                                                                                                              ");
		lblNewLabel.setEnabled(false);
		menuBar.add(lblNewLabel);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuSairAddActionPerformed();
			}
		});
		menuBar.add(mntmSair);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel LoginPanel = new JPanel();
		MainPanel.add(LoginPanel, "TelaLogin1");
		LoginPanel.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(343, 143, 150, 22);
		LoginPanel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(255, 147, 50, 13);
		LoginPanel.add(lblLogin);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmaActionPerformed();
			}
		});
		btnConfirma.setBounds(330, 225, 90, 21);
		LoginPanel.add(btnConfirma);
		
		JLabel lblLoginDeUsurio = new JLabel("Login de Usuário");
		lblLoginDeUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginDeUsurio.setFont(new Font("Calibri", Font.BOLD, 25));
		lblLoginDeUsurio.setBounds(240, 37, 270, 44);
		LoginPanel.add(lblLoginDeUsurio);
		
		JLabel lblBiometria = new JLabel("Biometria:");
		lblBiometria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBiometria.setBounds(255, 185, 50, 13);
		LoginPanel.add(lblBiometria);
		
		JButton btnArquivo = new JButton("Selecionar Arquivo");
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnArquivoActionPerformed();
			}
		});
		btnArquivo.setBounds(343, 181, 150, 21);
		LoginPanel.add(btnArquivo);
		
		MainPanel.add(TelaRegAdd, "TelaRegAdd");
		MainPanel.add(TelaPropAdd, "TelaPropAdd");
		MainPanel.add(TelaRespAdd, "TelaRespAdd");
		MainPanel.add(TelaUserAdd, "TelaUserAdd");
	}
	//Métodos
	private void btnArquivoActionPerformed() {
		janela.showOpenDialog(this);
		lblArquivo.setText(janela.getSelectedFile().getAbsolutePath());
		
	}
	
	private void btnConfirmaActionPerformed() {
		if(!lblArquivo.getText().equals("") && !txtLogin.getText().equals("")) {
			//metodo que verifica se o usuario existe no DB
			
			
			menuBar.setVisible(true);
			cl = (CardLayout) MainPanel.getLayout();
			cl.show(MainPanel, "TelaRegAdd");
		}else if(txtLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "O Login não pode ser vazio.");
		}
		else if(lblArquivo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Selecione o Arquivo de Biometria.");
		}
	}
	
	private void menuRegAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaRegAdd");
	}
	
	private void menuPropAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaPropAdd");
	}
	
	private void menuRespAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaRespAdd");
	}
	
	private void menuUserAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaUserAdd");
	}
	
	private void menuSairAddActionPerformed() {
		menuBar.setVisible(false);
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaLogin1");
	}
}
