package app.view;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.control.UsuarioDAO;
import app.model.Usuario;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserAdd extends PainelBase {
	JFileChooser janelaArquivo = new JFileChooser();
	private UsuarioDAO dao = new UsuarioDAO();
	private JTextField txtLogin;
	private JTextField txtNome;
	private JTextField txtBiometria;
	private JComboBox<String> cbxCargo;
	private JLabel lblImagem;
	private File imgCadastro;
	/**
	 * Create the panel.
	 */
	public UserAdd() {
		FileFilter filter = new FileNameExtensionFilter("Imagens", new String[] {"jpg","jpeg","png","tif"});
		janelaArquivo.addChoosableFileFilter(filter);
		janelaArquivo.setFileFilter(filter);
		
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registro de Usuários");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitulo.setBounds(240, 37, 270, 44);
		add(lblTitulo);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogin.setBounds(172, 152, 72, 23);
		add(lblLogin);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(172, 192, 72, 23);
		add(lblNome);
		
		JLabel lblBiometria = new JLabel("Biometria:");
		lblBiometria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBiometria.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBiometria.setBounds(89, 232, 155, 23);
		add(lblBiometria);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCargo.setBounds(113, 302, 131, 23);
		add(lblCargo);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(280, 152, 230, 19);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(280, 192, 230, 19);
		add(txtNome);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVoltarActionPerformed();
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistroActionPerformed();
			}
		});
		btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnRegistro.setBounds(460, 404, 110, 33);
		add(btnRegistro);
		
		txtBiometria = new JTextField();
		txtBiometria.setEditable(false);
		txtBiometria.setBounds(280, 232, 230, 19);
		add(txtBiometria);
		txtBiometria.setColumns(10);
		
		JButton btnArquivo = new JButton("Escolher Arquivo");
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnArquivoActionPerformed();
			}
		});
		btnArquivo.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnArquivo.setBounds(309, 262, 173, 21);
		add(btnArquivo);
		
		cbxCargo = new JComboBox<String>();
		cbxCargo.setModel(new DefaultComboBoxModel<String>(new String[] {"Escolha a Função", "1 - Funcionário", "2 - Diretor de Divisão", "3 - Ministro do Meio Ambiente"}));
		cbxCargo.setBounds(280, 302, 230, 21);
		add(cbxCargo);
		
		lblImagem = new JLabel("NO IMAGE");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setIcon(null);
		lblImagem.setBounds(538, 117, 155, 171);
		add(lblImagem);
		
		JLabel lblNewLabel = new JLabel("Imagem");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(583, 298, 67, 13);
		add(lblNewLabel);
	}
	
	private void btnRegistroActionPerformed() {
		if(verificador()) {
			if(dao.PesquisarUsuario(txtLogin.getText())) {
				JOptionPane.showMessageDialog(this, "Usuário já existe no banco de dados, tente outro nome.");
			}else {
				try {
					FileInputStream fis = new FileInputStream(imgCadastro);

					dao.InserirUsuario(new Usuario(0, txtLogin.getText(), fis, txtNome.getText(), retornaCargo(cbxCargo.getSelectedIndex()) ));
					JOptionPane.showMessageDialog(this, "Usuário criado com sucesso!!!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e);
				}
				
			}
		}else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
		}
	}
	
	private void btnArquivoActionPerformed() {
		int opt = janelaArquivo.showOpenDialog(this);
		if(opt == JFileChooser.APPROVE_OPTION) {
			txtBiometria.setText(janelaArquivo.getSelectedFile().getAbsolutePath());
			File imagem = janelaArquivo.getSelectedFile();
			ImageIcon icon = new ImageIcon(new ImageIcon(imagem.getAbsolutePath()).getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH));
			lblImagem.setIcon(icon);
			imgCadastro = imagem;
		}
	}
	
	private void btnVoltarActionPerformed(){
		cl.show(MainPanel, "TelaLogado");
	}
	
	private String retornaCargo(int index) {
		String resultado;
		switch(index) {
		case 1:
			resultado = "Funcionário";
			break;
		case 2:
			resultado = "Diretor de Divisão";
			break;
			
		case 3:
			resultado = "Ministro do Meio Ambiente";
			break;
		default:
			resultado = "Funcionário";
		}
		return resultado;
	}
	
	private boolean verificador() {
		if(!txtBiometria.getText().equals("")&!txtLogin.getText().equals("")&!txtNome.getText().equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
	public void start() {
		txtLogin.setText("");
		txtNome.setText("");
		txtBiometria.setText("");
		lblImagem.setIcon(null);
		cbxCargo.setSelectedIndex(0);
	}
	
	
}
