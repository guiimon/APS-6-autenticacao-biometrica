package app.view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.control.UsuarioDAO;
import app.model.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileInputStream;



public class UserEdit extends PainelBase {
	private JFileChooser janelaArquivo = new JFileChooser();
	private UsuarioDAO dao = new UsuarioDAO();
	private String chkLogin;
	
	private JTextField txtLogin;
	private JTextField txtNome;
	private JTextField txtId;
	private JTextField txtBiometria;
	private JComboBox<String> cbxCargo;
	JRadioButton rdbtnSim;
	JRadioButton rdbtnNao;
	
	private JLabel lblImagem;
	private File imgCadastro;
	/**
	 * Create the panel.
	 */
	public UserEdit() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				carregarDados(getUsuario());
			}
		});
		FileFilter filter = new FileNameExtensionFilter("Imagens", new String[] {"jpg","jpeg","png","tif"});
		janelaArquivo.addChoosableFileFilter(filter);
		janelaArquivo.setFileFilter(filter);
		
		setLayout(null);
		
		JLabel lblEditorDeUsurios = new JLabel("Editor de Usuários");
		lblEditorDeUsurios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorDeUsurios.setFont(new Font("Calibri", Font.BOLD, 25));
		lblEditorDeUsurios.setBounds(231, 37, 270, 44);
		add(lblEditorDeUsurios);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(280, 152, 230, 19);
		add(txtLogin);
		
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
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(280, 192, 230, 19);
		add(txtNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblId.setBounds(172, 112, 72, 23);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(280, 112, 117, 19);
		add(txtId);
		
		JLabel lblBiometria_1 = new JLabel("Biometria:");
		lblBiometria_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBiometria_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBiometria_1.setBounds(88, 272, 155, 23);
		add(lblBiometria_1);
		
		txtBiometria = new JTextField();
		txtBiometria.setEditable(false);
		txtBiometria.setColumns(10);
		txtBiometria.setBounds(280, 272, 230, 19);
		add(txtBiometria);
		
		JButton btnArquivo = new JButton("Escolher Arquivo");
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnArquivoActionPerformed();
			}
		});
		btnArquivo.setEnabled(false);
		btnArquivo.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnArquivo.setBounds(309, 302, 173, 21);
		add(btnArquivo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCargo.setBounds(113, 342, 131, 23);
		add(lblCargo);
		
		cbxCargo = new JComboBox<String>();
		cbxCargo.setModel(new DefaultComboBoxModel<String>(new String[] {"Escolha a Função", "1 - Funcionário", "2 - Diretor de Divisão", "3 - Ministro do Meio Ambiente"}));
		cbxCargo.setBounds(280, 342, 230, 21);
		add(cbxCargo);
		
		lblImagem = new JLabel("NO IMAGE");
		lblImagem.setVisible(false);
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(538, 117, 155, 171);
		add(lblImagem);
		
		JLabel lblImagemsubtitulo = new JLabel("Imagem");
		lblImagemsubtitulo.setVisible(false);
		lblImagemsubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagemsubtitulo.setBounds(583, 298, 67, 13);
		add(lblImagemsubtitulo);
		
		JLabel lblAtualizarABiometria = new JLabel("Atualizar a biometria?");
		lblAtualizarABiometria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAtualizarABiometria.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAtualizarABiometria.setBounds(44, 232, 200, 23);
		add(lblAtualizarABiometria);
		
		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBiometria.setEnabled(true);
				btnArquivo.setEnabled(true);
				lblImagem.setVisible(true);
				lblImagemsubtitulo.setVisible(true);
			}
		});
		rdbtnSim.setBounds(280, 232, 103, 21);
		add(rdbtnSim);
		
		rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setSelected(true);
		rdbtnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBiometria.setEnabled(false);
				btnArquivo.setEnabled(false);
				lblImagem.setVisible(false);
				lblImagemsubtitulo.setVisible(false);
			}
		});
		rdbtnNao.setBounds(413, 232, 103, 21);
		add(rdbtnNao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVoltarActionPerformed();
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnVoltar.setBounds(169, 404, 100, 33);
		add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistroActionPerformed();
			}
		});
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnEditar.setBounds(460, 404, 110, 33);
		add(btnEditar);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnSim);
		grupo.add(rdbtnNao);
	}
	
	
	//Metodos dos botões
	private void btnVoltarActionPerformed() {
		cl.show(MainPanel, "TelaUserView");
	}
	
	private void btnArquivoActionPerformed() {
		int opt = janelaArquivo.showOpenDialog(this);
		if(opt == JFileChooser.APPROVE_OPTION) {
			txtBiometria.setText(janelaArquivo.getSelectedFile().getAbsolutePath());
			imgCadastro = janelaArquivo.getSelectedFile();
			ImageIcon icon = new ImageIcon(new ImageIcon(imgCadastro.getAbsolutePath()).getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH));
			lblImagem.setIcon(icon);
		}
	}
	
	private void btnRegistroActionPerformed() {
		if(verificador()) {
			if(!txtLogin.getText().equals(chkLogin)) {
				if(dao.PesquisarUsuario(txtLogin.getText())) {
					JOptionPane.showMessageDialog(this, "Este nome de usuário já existe no banco de dados, tente outro nome.");
					return;
				}
			}
			try {
				if(rdbtnSim.isSelected()) {
					FileInputStream fis = new FileInputStream(imgCadastro);

					dao.UpdateUsuarioBiometria(new Usuario(Integer.parseInt(txtId.getText()), txtLogin.getText(), fis, txtNome.getText(), retornaCargo(cbxCargo.getSelectedIndex()) ));
					JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!!!");
				}else {
					dao.UpdateUsuario(new Usuario(Integer.parseInt(txtId.getText()), txtLogin.getText(), txtNome.getText(), retornaCargo(cbxCargo.getSelectedIndex()) ));
					JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!!!");
				}
				cl.show(MainPanel, "TelaUserView");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e);
			}	
		}else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
		}
	}
	
	//Metodos
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
	
	private int retornaCargo(String cargo) {
		int resultado;
		switch(cargo) {
		case "Funcionário":
			resultado = 1;
			break;
		case "Diretor de Divisão":
			resultado = 2;
			break;
		case "Ministro do Meio Ambiente":
			resultado = 3;
			break;
		default:
			resultado = 1;
			break;
		}
		
		return resultado;
	}
	
	private boolean verificador() {
		if(rdbtnSim.isSelected()) {
			if(!txtBiometria.getText().equals("")&!txtLogin.getText().equals("")&!txtNome.getText().equals("")) {
				return true;
			}else {
				return false;
			}
		}else {
			if(!txtLogin.getText().equals("")&!txtNome.getText().equals("")) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	private void carregarDados(Usuario usr) {
		chkLogin = usr.getLogin();
		txtId.setText(usr.getId()+"");
		txtLogin.setText(usr.getLogin());
		txtNome.setText(usr.getNome());
		cbxCargo.setSelectedIndex(retornaCargo(usr.getCargo()));
		rdbtnNao.setSelected(true);
		txtBiometria.setText("");
		lblImagem.setIcon(null);
	}
	
}
