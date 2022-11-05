package app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.control.Funcoes;
import app.control.UsuarioDAO;
import app.model.Usuario;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Login extends JFrame {
	// Parametros
	private UsuarioDAO dao = new UsuarioDAO();
	private static CardLayout cl = new CardLayout();
	private JFileChooser janela = new JFileChooser();
	private String CaminhoArquivo;
	private Funcoes func = new Funcoes();
	private File imgLogin;
	private File imgBanco;
	private String pastaDigitais = "C:\\TempAPS6\\"; // caminho da pasta contendo as digitais
	private Usuario userDB;

	// Paineis de Exibição
	private RegAdd TelaRegAdd = new RegAdd();
	private PropAdd TelaPropAdd = new PropAdd();
	private RespAdd TelaRespAdd = new RespAdd();
	private UserAdd TelaUserAdd = new UserAdd();
	private RegView TelaRegView = new RegView();
	private PropView TelaPropView = new PropView();
	private RespView TelaRespView = new RespView();
	private UserView TelaUserView = new UserView();
	private PropEdit TelaPropEdit = new PropEdit();
	private RegEdit TelaRegEdit = new RegEdit();
	private RespEdit TelaRespEdit = new RespEdit();
	private UserEdit TelaUserEdit = new UserEdit();
	private Logged TelaLogado = new Logged();
	private JPanel MainPanel;
	private JLabel lblImagem;

	// Menu superior
	private JMenuBar menuBar;
	private JMenu mnRegioes;
	private JMenu mnPropriedades;
	private JMenu mnResponsaveis;
	private JMenu mnUsuarios;

	private JTextField txtLogin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public Login() {
		initComponents();
		cl = (CardLayout) MainPanel.getLayout();
		TelaPropAdd.setCard(cl,MainPanel);
	}
	
	public void initComponents() {
		FileFilter filter = new FileNameExtensionFilter("Imagens", new String[] { "jpg", "jpeg", "png", "tif" });
		janela.addChoosableFileFilter(filter);
		janela.setFileFilter(filter);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);

		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		setJMenuBar(menuBar);

		mnRegioes = new JMenu("Regiões");
		mnRegioes.setEnabled(false);
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
				menuRegViewActionPerformed();
			}
		});
		mnRegioes.add(mntmRegView);

		mnPropriedades = new JMenu("Propriedades");
		mnPropriedades.setEnabled(false);
		menuBar.add(mnPropriedades);

		JMenuItem mntmPropAdd = new JMenuItem("Adicionar");
		mntmPropAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPropAddActionPerformed();
			}
		});
		mnPropriedades.add(mntmPropAdd);

		JMenuItem mntmPropView = new JMenuItem("Visualizar");
		mntmPropView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPropViewActionPerformed();
			}
		});
		mnPropriedades.add(mntmPropView);

		mnResponsaveis = new JMenu("Responsaveis");
		mnResponsaveis.setEnabled(false);
		menuBar.add(mnResponsaveis);

		JMenuItem mntmRespAdd = new JMenuItem("Adicionar");
		mntmRespAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuRespAddActionPerformed();
			}
		});
		mnResponsaveis.add(mntmRespAdd);

		JMenuItem mntmRespView = new JMenuItem("Visualizar");
		mntmRespView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuRespViewActionPerformed();
			}
		});
		mnResponsaveis.add(mntmRespView);

		mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setEnabled(false);
		menuBar.add(mnUsuarios);

		JMenuItem mntmUserAdd = new JMenuItem("Adicionar");
		mntmUserAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUserAddActionPerformed();
			}
		});
		mnUsuarios.add(mntmUserAdd);

		JMenuItem mntmUserView = new JMenuItem("Visualizar");
		mntmUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUserViewActionPerformed();
			}
		});
		mnUsuarios.add(mntmUserView);

		JLabel lblNewLabel = new JLabel(
				"                                                                                                              ");
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
		lblBiometria.setBounds(255, 185, 60, 13);
		LoginPanel.add(lblBiometria);

		JButton btnArquivo = new JButton("Selecionar Arquivo");
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnArquivoActionPerformed();
			}
		});
		btnArquivo.setBounds(343, 181, 150, 21);
		LoginPanel.add(btnArquivo);

		lblImagem = new JLabel("NO IMAGE");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setIcon(null);
		lblImagem.setBounds(538, 117, 155, 171);
		LoginPanel.add(lblImagem);
		
		MainPanel.add(TelaRegAdd, "TelaRegAdd");
		MainPanel.add(TelaPropAdd, "TelaPropAdd");
		MainPanel.add(TelaRespAdd, "TelaRespAdd");
		MainPanel.add(TelaUserAdd, "TelaUserAdd");
		MainPanel.add(TelaRegView, "TelaRegView");
		MainPanel.add(TelaPropView, "TelaPropView");
		MainPanel.add(TelaRespView, "TelaRespView");
		MainPanel.add(TelaUserView, "TelaUserView");
		MainPanel.add(TelaPropEdit, "TelaPropEdit");
		MainPanel.add(TelaRespEdit, "TelaRespEdit");
		MainPanel.add(TelaRegEdit, "TelaRegEdit");
		MainPanel.add(TelaUserEdit,"TelaUserEdit");
		MainPanel.add(TelaLogado, "TelaLogado");
	}

	// Métodos
	private void btnArquivoActionPerformed() {
		int opt = janela.showOpenDialog(this);
		if (opt == JFileChooser.APPROVE_OPTION) {
			CaminhoArquivo = janela.getSelectedFile().getAbsolutePath();
			File imagem = janela.getSelectedFile();
			ImageIcon icon = new ImageIcon(new ImageIcon(imagem.getAbsolutePath()).getImage()
					.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH));
			lblImagem.setIcon(icon);
			imgLogin = imagem;
		}
	}

	private void btnConfirmaActionPerformed() {
		boolean resultado;
		if ((!(CaminhoArquivo == null)) && (!(txtLogin.getText().length() == 0))) {
			if(dao.PesquisarUsuario(txtLogin.getText())) {
				try {

					userDB = dao.RetornaUsuario(txtLogin.getText());
					InputStream binaryStream = userDB.getInput();
					createFile(pastaDigitais + "digital.jpg");
					Files.copy(binaryStream, Paths.get(pastaDigitais + "digital.jpg"));
					imgBanco = new File(pastaDigitais + "digital.jpg");
					resultado = func.ComparaDigital(imgLogin, imgBanco);
					Files.delete(Paths.get(pastaDigitais + "digital.jpg"));
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
				if (!resultado) {
					JOptionPane.showMessageDialog(this, "Impressão digital não compativel");
				} else {
					menuBar.setVisible(true);
					UserLevel(userDB.getCargo());
					cl = (CardLayout) MainPanel.getLayout();
					TelaLogado.setTexto(userDB.getNome(), userDB.getCargo());
					cl.show(MainPanel, "TelaLogado");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Usuário não existente no sistema.");
			}
		} else if (txtLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "O Login não pode ser vazio.");
		} else if (CaminhoArquivo == null) {
			JOptionPane.showMessageDialog(this, "Selecione o Arquivo de Biometria.");
		}
	}

	private void menuRegAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		TelaRegAdd.start();
		cl.show(MainPanel, "TelaRegAdd");
	}

	private void menuRegViewActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaRegView");
	}

	private void menuPropAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		TelaPropAdd.start();
		cl.show(MainPanel, "TelaPropAdd");
	}

	private void menuPropViewActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaPropView");
	}

	private void menuRespAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		TelaRespAdd.start();
		cl.show(MainPanel, "TelaRespAdd");
	}

	private void menuRespViewActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaRespView");
	}

	private void menuUserAddActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		TelaUserAdd.start();
		cl.show(MainPanel, "TelaUserAdd");
	}

	private void menuUserViewActionPerformed() {
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaUserView");
	}

	private void menuSairAddActionPerformed() {
		menuBar.setVisible(false);
		UserLevel("");
		cl = (CardLayout) MainPanel.getLayout();
		cl.show(MainPanel, "TelaLogin1");
	}

	private void UserLevel(String cargo) {
		switch (cargo) {
		case "Funcionário":
			mnRegioes.setEnabled(true);
			break;
		case "Diretor de Divisão":
			mnRegioes.setEnabled(true);
			mnPropriedades.setEnabled(true);
			break;
		case "Ministro do Meio Ambiente":
			mnRegioes.setEnabled(true);
			mnPropriedades.setEnabled(true);
			mnResponsaveis.setEnabled(true);
			mnUsuarios.setEnabled(true);
			break;
		default:
			mnRegioes.setEnabled(false);
			mnPropriedades.setEnabled(false);
			mnResponsaveis.setEnabled(false);
			mnUsuarios.setEnabled(false);
		}
	}

	private void createFile(String path) throws IOException {
		File arquivo = new File(path);
		arquivo.getParentFile().mkdir();
	}
}
