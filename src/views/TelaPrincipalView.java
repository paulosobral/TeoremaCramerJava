package views;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class TelaPrincipalView extends JFrame {

	private static final long serialVersionUID = 1L;

	// VAR QUE REPRESENTA QUE ESTÁ NA TELA INICIAL:
	public boolean telaInicio = true;

	// ATRIBUTOS DO MENU PRINCIPAL:
	public JMenuBar menuBar = new JMenuBar();
	public JMenu mnNovoCramer = new JMenu("Nova Matriz");
	public JMenuItem mntmx = new JMenuItem("Cramer 2x2");
	public JMenuItem mntmx_1 = new JMenuItem("Cramer 3x3");
	public JMenuItem mntmx_4 = new JMenuItem("Laplace 4x4");
	public JMenu mnSobre = new JMenu("Sobre");
	public JMenuItem mntmx_2 = new JMenuItem("Desenvolvedores");
	public JMenuItem mntmx_3 = new JMenuItem("Gabriel Cramer");
	public JMenuItem mntmx_5 = new JMenuItem("Pierre Simon Laplace");

	// PAINÉIS:
	public JPanel panelPrincipal = new JPanel();
	public JPanel panelInicio = new JPanel();
	public JPanel panelCramer2x2 = new JPanel();
	public JPanel panelCramer3x3 = new JPanel();
	public JPanel panelLaplace4x4 = new JPanel();

	// CAMPOS DE TEXTO PARA O CRAMER:
	public JTextField tfX1 = new JTextField();
	public JTextField tfX2 = new JTextField();
	public JTextField tfX3 = new JTextField();
	public JTextField tfX4 = new JTextField();
	public JTextField tfY1 = new JTextField();
	public JTextField tfY2 = new JTextField();
	public JTextField tfY3 = new JTextField();
	public JTextField tfY4 = new JTextField();
	public JTextField tfZ1 = new JTextField();
	public JTextField tfZ2 = new JTextField();
	public JTextField tfZ3 = new JTextField();
	public JTextField tfZ4 = new JTextField();
	public JTextField tfW1 = new JTextField();
	public JTextField tfW2 = new JTextField();
	public JTextField tfW3 = new JTextField();
	public JTextField tfW4 = new JTextField();
	public JTextField tfI1 = new JTextField();
	public JTextField tfI2 = new JTextField();
	public JTextField tfI3 = new JTextField();
	public JTextField tfI4 = new JTextField();

	// CAMPOS DE TEXTO COM RESULTADOS:
	public JTextField tfDeltaX = new JTextField();
	public JTextField tfDeltaY = new JTextField();
	public JTextField tfDeltaZ = new JTextField();
	public JTextField tfDeltaW = new JTextField();
	public JTextField tfDeterminanteSistema = new JTextField();

	// TEXTOS E LEGENDAS:
	private JTextArea txtrInfoCramer = new JTextArea();
	private JLabel lblResultadoCramer = new JLabel();
	private JLabel lblTipoTabela = new JLabel("");
	private JLabel lblI = new JLabel("Independentes", SwingConstants.CENTER);
	private JLabel lblY = new JLabel("Y", JLabel.CENTER);
	private JLabel lblX = new JLabel("X", JLabel.CENTER);
	private JLabel lblZ = new JLabel("Z", JLabel.CENTER);
	private JLabel lblW = new JLabel("W", JLabel.CENTER);

	// BOTÕES:
	private JButton btnInicioCramer2x2 = new JButton("Novo Cramer 2x2");
	private JButton btnInicioCramer3x3 = new JButton("Novo Cramer 3x3");
	private JButton btnInicioLaplace4x4 = new JButton("Novo Laplace 4x4");
	private JButton btnCalcularCramer2x2 = new JButton();
	private JButton btnCalcularCramer3x3 = new JButton();
	private JButton btnCalcularLaplace4x4 = new JButton();
	private JButton btnLimparCramer = new JButton();

	public TelaPrincipalView() {

		// INFO GERAL:
		super("Teorema de Cramer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// CENTRALIZA NA TELA ESTA JANELA:
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit()
				.getScreenSize());
		setPreferredSize(new Dimension(600, 600));
		int wdwLeft = screenSize.width / 2 - 300;
		int wdwTop = screenSize.height / 2 - 300;
		pack();
		setLocation(wdwLeft, wdwTop);

		setResizable(false);

		// ICONE DO JFRAME:
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass()
					.getResource("/assets/img/icone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(image);

		// MONTA O MENU PRINCIPAL:
		montaMenuPrincipal();

		// MONTA O PAINEL PRINCIPAL:
		montaPainelPrincipal();
		
		// MONTA O PAINEL INÍCIO:
		montaPainelInicio();

		// MONTATEXTO INFO CRAMER:
		this.txtrInfoCramer.setFont(new Font("Monospaced", Font.PLAIN, 11));
		this.txtrInfoCramer.setBackground(UIManager
				.getColor("Button.background"));
		this.txtrInfoCramer.setEditable(false);
		this.txtrInfoCramer.setLineWrap(true);
		this.txtrInfoCramer
				.setText("* Informe somente os num\u00E9ros, caso seja um n\u00FAmero negativo informe o sinal de menos na frente do n\u00FAmero. \r\nExemplo: -7 (sem espa\u00E7os)\r\n\r\n* S\u00E3o aceitos n\u00FAmeros decimais, caso queira informar uma fra\u00E7\u00E3o\r\ninforme em decimal.\r\nExemplo 1/5 = 0.2 (somente ponto)\r\n\r\n* Caso algum campo esteja em branco, se auto assumir\u00E1 como 0.");
		this.txtrInfoCramer.setBounds(24, 40, 546, 160);

		setVisible(true);
	}

	// MONTA O MENU PRINCIPAL:
	public void montaMenuPrincipal() {
		this.mnNovoCramer.add(this.mntmx);
		this.mnNovoCramer.add(this.mntmx_1);
		this.mnNovoCramer.add(this.mntmx_4);
		this.mnSobre.add(this.mntmx_2);
		this.mnSobre.add(this.mntmx_3);
		this.mnSobre.add(this.mntmx_5);
		this.menuBar.add(this.mnNovoCramer);
		this.menuBar.add(this.mnSobre);
		setJMenuBar(this.menuBar);

	}

	public void montaPainelPrincipal() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		// ROLAGEM NA TELA:
		JScrollPane scrollPane = new JScrollPane(this.panelPrincipal);
		getContentPane().add(scrollPane);
		this.panelPrincipal.setLayout(new BorderLayout(0, 0));
	}

	public void montaPainelInicio() {
		panelInicio.setBackground(new Color(240, 240, 240));
		this.panelInicio.setPreferredSize(new Dimension(500, 500));
		this.panelInicio.setMinimumSize(new Dimension(500, 500));
		panelInicio.setLayout(new BorderLayout(0, 0));
		this.panelInicio.add(new JLabel(new ImageIcon(this.getClass()
				.getResource("/assets/img/telaInicio.jpg"))), BorderLayout.NORTH);

		this.panelPrincipal.add(this.panelInicio);
		
		JPanel panelBtnInicio = new JPanel();
		
		panelInicio.add(panelBtnInicio, BorderLayout.CENTER);
		panelBtnInicio.setLayout(new GridLayout(1, 3, 0, 0));
		
		panelBtnInicio.add(btnInicioCramer2x2);
		
		panelBtnInicio.add(btnInicioCramer3x3);
		
		panelBtnInicio.add(btnInicioLaplace4x4);
	}

	// MONTA TELA CRAMER 2X2:
	public void montaPainelCramer2x2() {
		
		// INFORMA QUE SAIU DA TELA INICIAL:
		this.telaInicio = false;

		this.panelCramer2x2.setLayout(null);
		this.lblTipoTabela.setBounds(24, 0, 155, 45);

		this.lblTipoTabela.setText("Tabela (Cramer 2x2):");
		this.panelCramer2x2.add(this.lblTipoTabela);

		// TABELA CRAMER 2X2 XY:
		JPanel panelTabelaCramerXY = new JPanel();
		panelTabelaCramerXY.setBounds(24, 220, 304, 99);

		this.panelCramer2x2.add(panelTabelaCramerXY);
		panelTabelaCramerXY.setLayout(new GridLayout(3, 2, 0, 0));

		panelTabelaCramerXY.add(this.lblX);
		panelTabelaCramerXY.add(this.lblY);
		panelTabelaCramerXY.add(this.tfX1);
		panelTabelaCramerXY.add(this.tfY1);
		panelTabelaCramerXY.add(this.tfX2);
		panelTabelaCramerXY.add(this.tfY2);

		// TABELA INDEPENDENTES:
		JPanel panelTabelaIndependentesXY = new JPanel();
		panelTabelaIndependentesXY.setBounds(390, 220, 180, 99);

		this.panelCramer2x2.add(panelTabelaIndependentesXY);
		panelTabelaIndependentesXY.setLayout(new GridLayout(3, 1, 0, 0));

		panelTabelaIndependentesXY.add(this.lblI);
		panelTabelaIndependentesXY.add(this.tfI1);
		panelTabelaIndependentesXY.add(this.tfI2);

		this.tfI2.setHorizontalAlignment(JTextField.CENTER);
		this.tfI1.setHorizontalAlignment(JTextField.CENTER);
		this.tfY2.setHorizontalAlignment(JTextField.CENTER);
		this.tfX2.setHorizontalAlignment(JTextField.CENTER);
		this.tfX1.setHorizontalAlignment(JTextField.CENTER);
		this.tfY1.setHorizontalAlignment(JTextField.CENTER);

		this.btnCalcularCramer2x2.setBounds(24, 350, 162, 23);
		this.btnLimparCramer.setBounds(215, 350, 162, 23);

		// BTN CRAMER:
		this.btnCalcularCramer2x2.setText("Calcular Cramer 2x2");
		this.btnLimparCramer.setText("Limpar Cramer");
		this.panelCramer2x2.add(this.btnCalcularCramer2x2);
		this.panelCramer2x2.add(this.btnLimparCramer);

		// SINAL DE IGUAL E INFO:
		JLabel lblIgual = new JLabel("=", JLabel.CENTER);
		lblIgual.setBounds(338, 260, 40, 14);
		JLabel lblIgual2 = new JLabel("=", SwingConstants.CENTER);
		lblIgual2.setBounds(338, 293, 40, 14);
		this.panelCramer2x2.add(lblIgual);
		this.panelCramer2x2.add(lblIgual2);
		this.panelCramer2x2.add(this.txtrInfoCramer);

		this.lblResultadoCramer.setText("Resultado Cramer 2x2:");
		this.lblResultadoCramer.setBounds(24, 400, 155, 45);
		this.panelCramer2x2.add(this.lblResultadoCramer);

		// RESULTADOS:
		JPanel panelTabelaResultadoCramer2x2 = new JPanel();
		panelTabelaResultadoCramer2x2.setBounds(24, 450, 546, 65);
		this.panelCramer2x2.add(panelTabelaResultadoCramer2x2);
		panelTabelaResultadoCramer2x2.setLayout(new GridLayout(2, 3, 0, 0));

		JLabel lblDeltaX = new JLabel("Delta X", SwingConstants.CENTER);
		panelTabelaResultadoCramer2x2.add(lblDeltaX);

		JLabel lblDeltaY = new JLabel("Delta Y", SwingConstants.CENTER);
		panelTabelaResultadoCramer2x2.add(lblDeltaY);

		JLabel lblDeterminanteDoSistema = new JLabel("Determinante do Sistema",
				SwingConstants.CENTER);
		panelTabelaResultadoCramer2x2.add(lblDeterminanteDoSistema);

		this.tfDeltaX.setEnabled(false);
		this.tfDeltaX.setEditable(false);
		this.tfDeltaX.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer2x2.add(this.tfDeltaX);

		this.tfDeltaY.setEnabled(false);
		this.tfDeltaY.setEditable(false);
		this.tfDeltaY.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer2x2.add(this.tfDeltaY);

		this.tfDeterminanteSistema.setEnabled(false);
		this.tfDeterminanteSistema.setEditable(false);
		this.tfDeterminanteSistema.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer2x2.add(this.tfDeterminanteSistema);

		this.panelPrincipal.add(this.panelCramer2x2);
		this.panelPrincipal.invalidate();
		this.panelPrincipal.validate();
		this.panelPrincipal.repaint();
	}

	// MONTA TELA CRAMER 3X3:
	public void montaPainelCramer3x3() {

		// INFORMA QUE SAIU DA TELA INICIAL:
		this.telaInicio = false;

		this.panelCramer3x3.setLayout(null);
		this.lblTipoTabela.setBounds(24, 0, 155, 45);

		this.lblTipoTabela.setText("Tabela (Cramer 3x3):");
		this.panelCramer3x3.add(this.lblTipoTabela);

		// TABELA CRAMER 3X3 XYZ:
		JPanel panelTabelaCramerXYZ = new JPanel();
		panelTabelaCramerXYZ.setBounds(24, 220, 304, 99);

		this.panelCramer3x3.add(panelTabelaCramerXYZ);
		panelTabelaCramerXYZ.setLayout(new GridLayout(4, 3, 0, 0));

		panelTabelaCramerXYZ.add(this.lblX);
		panelTabelaCramerXYZ.add(this.lblY);
		panelTabelaCramerXYZ.add(this.lblZ);
		panelTabelaCramerXYZ.add(this.tfX1);
		panelTabelaCramerXYZ.add(this.tfY1);
		panelTabelaCramerXYZ.add(this.tfZ1);
		panelTabelaCramerXYZ.add(this.tfX2);
		panelTabelaCramerXYZ.add(this.tfX2);
		panelTabelaCramerXYZ.add(this.tfY2);
		panelTabelaCramerXYZ.add(this.tfZ2);
		panelTabelaCramerXYZ.add(this.tfX3);

		panelTabelaCramerXYZ.add(this.tfY3);
		panelTabelaCramerXYZ.add(this.tfZ3);

		// TABELA INDEPENDENTES:
		JPanel panelTabelaIndependentesXYZ = new JPanel();
		panelTabelaIndependentesXYZ.setBounds(390, 220, 180, 99);

		this.panelCramer3x3.add(panelTabelaIndependentesXYZ);
		panelTabelaIndependentesXYZ.setLayout(new GridLayout(4, 1, 0, 0));

		panelTabelaIndependentesXYZ.add(this.lblI);
		panelTabelaIndependentesXYZ.add(this.tfI1);
		panelTabelaIndependentesXYZ.add(this.tfI2);
		panelTabelaIndependentesXYZ.add(this.tfI3);

		this.tfI1.setHorizontalAlignment(JTextField.CENTER);
		this.tfI3.setHorizontalAlignment(JTextField.CENTER);
		this.tfI2.setHorizontalAlignment(JTextField.CENTER);

		this.tfX1.setHorizontalAlignment(JTextField.CENTER);
		this.tfX2.setHorizontalAlignment(JTextField.CENTER);
		this.tfX3.setHorizontalAlignment(JTextField.CENTER);

		this.tfY1.setHorizontalAlignment(JTextField.CENTER);
		this.tfY2.setHorizontalAlignment(JTextField.CENTER);
		this.tfY3.setHorizontalAlignment(JTextField.CENTER);

		this.tfZ1.setHorizontalAlignment(JTextField.CENTER);
		this.tfZ2.setHorizontalAlignment(JTextField.CENTER);
		this.tfZ3.setHorizontalAlignment(JTextField.CENTER);

		this.btnCalcularCramer3x3.setBounds(24, 350, 162, 23);
		this.btnLimparCramer.setBounds(215, 350, 162, 23);

		// BTN CRAMER:
		this.btnCalcularCramer3x3.setText("Calcular Cramer 3x3");
		this.btnLimparCramer.setText("Limpar Cramer");
		this.panelCramer3x3.add(this.btnCalcularCramer3x3);
		this.panelCramer3x3.add(this.btnLimparCramer);

		// SINAL DE IGUAL E INFO:
		JLabel lblIgual = new JLabel("=", JLabel.CENTER);
		lblIgual.setBounds(338, 250, 40, 14);
		JLabel lblIgual2 = new JLabel("=", SwingConstants.CENTER);
		lblIgual2.setBounds(338, 275, 40, 14);
		JLabel lblIgual3 = new JLabel("=", SwingConstants.CENTER);
		lblIgual3.setBounds(338, 300, 40, 14);
		this.panelCramer3x3.add(lblIgual);
		this.panelCramer3x3.add(lblIgual2);
		this.panelCramer3x3.add(lblIgual3);
		this.lblResultadoCramer.setText("Resultado Cramer 3x3:");
		this.lblResultadoCramer.setBounds(24, 400, 155, 45);
		this.panelCramer3x3.add(this.lblResultadoCramer);
		this.panelCramer3x3.add(this.txtrInfoCramer);

		// RESULTADOS:
		JPanel panelTabelaResultadoCramer3x3 = new JPanel();
		panelTabelaResultadoCramer3x3.setBounds(24, 450, 546, 65);
		this.panelCramer3x3.add(panelTabelaResultadoCramer3x3);
		panelTabelaResultadoCramer3x3.setLayout(new GridLayout(2, 4, 0, 0));

		JLabel lblDeltaX = new JLabel("Delta X", SwingConstants.CENTER);
		panelTabelaResultadoCramer3x3.add(lblDeltaX);

		JLabel lblDeltaY = new JLabel("Delta Y", SwingConstants.CENTER);
		panelTabelaResultadoCramer3x3.add(lblDeltaY);

		JLabel lblDeltaZ = new JLabel("Delta Z", SwingConstants.CENTER);
		panelTabelaResultadoCramer3x3.add(lblDeltaZ);

		JLabel lblDeterminanteDoSistema = new JLabel("D. do Sistema",
				SwingConstants.CENTER);
		panelTabelaResultadoCramer3x3.add(lblDeterminanteDoSistema);

		this.tfDeltaX.setEnabled(false);
		this.tfDeltaX.setEditable(false);
		this.tfDeltaX.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer3x3.add(this.tfDeltaX);

		this.tfDeltaY.setEnabled(false);
		this.tfDeltaY.setEditable(false);
		this.tfDeltaY.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer3x3.add(this.tfDeltaY);

		this.tfDeltaZ.setEnabled(false);
		this.tfDeltaZ.setEditable(false);
		this.tfDeltaZ.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer3x3.add(this.tfDeltaZ);

		this.tfDeterminanteSistema.setEnabled(false);
		this.tfDeterminanteSistema.setEditable(false);
		this.tfDeterminanteSistema.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoCramer3x3.add(this.tfDeterminanteSistema);
		this.panelPrincipal.add(this.panelCramer3x3);
		this.panelPrincipal.invalidate();
		this.panelPrincipal.validate();
		this.panelPrincipal.repaint();
	}

	// MONTA TELA CRAMER 3X3:
	public void montaPainelLaplace4x4() {

		// INFORMA QUE SAIU DA TELA INICIAL:
		this.telaInicio = false;

		this.panelLaplace4x4.setLayout(null);
		this.lblTipoTabela.setBounds(24, 0, 155, 45);

		this.lblTipoTabela.setText("Tabela (Laplace 4x4):");
		this.panelLaplace4x4.add(this.lblTipoTabela);

		// TABELA LAPLACE 4X4 XYZW:
		JPanel panelTabelaLaplaceXYZW = new JPanel();
		panelTabelaLaplaceXYZW.setBounds(24, 220, 304, 99);

		this.panelLaplace4x4.add(panelTabelaLaplaceXYZW);
		panelTabelaLaplaceXYZW.setLayout(new GridLayout(5, 4, 0, 0));

		panelTabelaLaplaceXYZW.add(this.lblX);
		panelTabelaLaplaceXYZW.add(this.lblY);
		panelTabelaLaplaceXYZW.add(this.lblZ);
		panelTabelaLaplaceXYZW.add(this.lblW);
		panelTabelaLaplaceXYZW.add(this.tfX1);
		panelTabelaLaplaceXYZW.add(this.tfY1);
		panelTabelaLaplaceXYZW.add(this.tfZ1);
		panelTabelaLaplaceXYZW.add(this.tfW1);
		panelTabelaLaplaceXYZW.add(this.tfX2);
		panelTabelaLaplaceXYZW.add(this.tfY2);
		panelTabelaLaplaceXYZW.add(this.tfZ2);
		panelTabelaLaplaceXYZW.add(this.tfW2);
		panelTabelaLaplaceXYZW.add(this.tfX3);
		panelTabelaLaplaceXYZW.add(this.tfY3);
		panelTabelaLaplaceXYZW.add(this.tfZ3);
		panelTabelaLaplaceXYZW.add(this.tfW3);
		panelTabelaLaplaceXYZW.add(this.tfX4);
		panelTabelaLaplaceXYZW.add(this.tfY4);
		panelTabelaLaplaceXYZW.add(this.tfZ4);
		panelTabelaLaplaceXYZW.add(this.tfW4);

		// TABELA INDEPENDENTES:
		JPanel panelTabelaIndependentesXYZW = new JPanel();
		panelTabelaIndependentesXYZW.setBounds(390, 220, 180, 99);

		this.panelLaplace4x4.add(panelTabelaIndependentesXYZW);
		panelTabelaIndependentesXYZW.setLayout(new GridLayout(5, 1, 0, 0));

		panelTabelaIndependentesXYZW.add(this.lblI);
		panelTabelaIndependentesXYZW.add(this.tfI1);
		panelTabelaIndependentesXYZW.add(this.tfI2);
		panelTabelaIndependentesXYZW.add(this.tfI3);
		panelTabelaIndependentesXYZW.add(this.tfI4);

		this.tfI1.setHorizontalAlignment(JTextField.CENTER);
		this.tfI2.setHorizontalAlignment(JTextField.CENTER);
		this.tfI3.setHorizontalAlignment(JTextField.CENTER);
		this.tfI4.setHorizontalAlignment(JTextField.CENTER);

		this.tfX1.setHorizontalAlignment(JTextField.CENTER);
		this.tfX2.setHorizontalAlignment(JTextField.CENTER);
		this.tfX3.setHorizontalAlignment(JTextField.CENTER);
		this.tfX4.setHorizontalAlignment(JTextField.CENTER);

		this.tfY1.setHorizontalAlignment(JTextField.CENTER);
		this.tfY2.setHorizontalAlignment(JTextField.CENTER);
		this.tfY3.setHorizontalAlignment(JTextField.CENTER);
		this.tfY4.setHorizontalAlignment(JTextField.CENTER);

		this.tfZ1.setHorizontalAlignment(JTextField.CENTER);
		this.tfZ2.setHorizontalAlignment(JTextField.CENTER);
		this.tfZ3.setHorizontalAlignment(JTextField.CENTER);
		this.tfZ4.setHorizontalAlignment(JTextField.CENTER);

		this.tfW1.setHorizontalAlignment(JTextField.CENTER);
		this.tfW2.setHorizontalAlignment(JTextField.CENTER);
		this.tfW3.setHorizontalAlignment(JTextField.CENTER);
		this.tfW4.setHorizontalAlignment(JTextField.CENTER);

		this.btnCalcularLaplace4x4.setBounds(24, 350, 162, 23);
		this.btnLimparCramer.setBounds(215, 350, 162, 23);

		// BTN LAPLACE:
		this.btnCalcularLaplace4x4.setText("Calcular Laplace 4x4");
		this.btnLimparCramer.setText("Limpar Laplace");
		this.panelLaplace4x4.add(this.btnCalcularLaplace4x4);
		this.panelLaplace4x4.add(this.btnLimparCramer);

		// SINAL DE IGUAL E INFO:
		JLabel lblIgual = new JLabel("=", JLabel.CENTER);
		lblIgual.setBounds(338, 244, 40, 14);
		JLabel lblIgual2 = new JLabel("=", SwingConstants.CENTER);
		lblIgual2.setBounds(338, 262, 40, 14);
		JLabel lblIgual3 = new JLabel("=", SwingConstants.CENTER);
		lblIgual3.setBounds(338, 280, 40, 14);
		JLabel lblIgual4 = new JLabel("=", SwingConstants.CENTER);
		lblIgual4.setBounds(338, 300, 40, 14);
		this.panelLaplace4x4.add(lblIgual);
		this.panelLaplace4x4.add(lblIgual2);
		this.panelLaplace4x4.add(lblIgual3);
		this.panelLaplace4x4.add(lblIgual4);
		this.lblResultadoCramer.setText("Resultado Laplace 4x4:");
		this.lblResultadoCramer.setBounds(24, 400, 155, 45);
		this.panelLaplace4x4.add(this.lblResultadoCramer);
		this.panelLaplace4x4.add(this.txtrInfoCramer);

		// RESULTADOS:
		JPanel panelTabelaResultadoLaplace4x4 = new JPanel();
		panelTabelaResultadoLaplace4x4.setBounds(24, 450, 546, 65);
		this.panelLaplace4x4.add(panelTabelaResultadoLaplace4x4);
		panelTabelaResultadoLaplace4x4.setLayout(new GridLayout(2, 4, 0, 0));

		JLabel lblDeltaX = new JLabel("Delta X", SwingConstants.CENTER);
		panelTabelaResultadoLaplace4x4.add(lblDeltaX);

		JLabel lblDeltaY = new JLabel("Delta Y", SwingConstants.CENTER);
		panelTabelaResultadoLaplace4x4.add(lblDeltaY);

		JLabel lblDeltaZ = new JLabel("Delta Z", SwingConstants.CENTER);
		panelTabelaResultadoLaplace4x4.add(lblDeltaZ);

		JLabel lblDeltaW = new JLabel("Delta W", SwingConstants.CENTER);
		panelTabelaResultadoLaplace4x4.add(lblDeltaW);

		JLabel lblDeterminanteDoSistema = new JLabel("D. do Sistema",
				SwingConstants.CENTER);
		panelTabelaResultadoLaplace4x4.add(lblDeterminanteDoSistema);

		this.tfDeltaX.setEnabled(false);
		this.tfDeltaX.setEditable(false);
		this.tfDeltaX.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoLaplace4x4.add(this.tfDeltaX);

		this.tfDeltaY.setEnabled(false);
		this.tfDeltaY.setEditable(false);
		this.tfDeltaY.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoLaplace4x4.add(this.tfDeltaY);

		this.tfDeltaZ.setEnabled(false);
		this.tfDeltaZ.setEditable(false);
		this.tfDeltaZ.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoLaplace4x4.add(this.tfDeltaZ);

		this.tfDeltaW.setEnabled(false);
		this.tfDeltaW.setEditable(false);
		this.tfDeltaW.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoLaplace4x4.add(this.tfDeltaW);

		this.tfDeterminanteSistema.setEnabled(false);
		this.tfDeterminanteSistema.setEditable(false);
		this.tfDeterminanteSistema.setHorizontalAlignment(JTextField.CENTER);
		panelTabelaResultadoLaplace4x4.add(this.tfDeterminanteSistema);
		this.panelPrincipal.add(this.panelLaplace4x4);
		this.panelPrincipal.invalidate();
		this.panelPrincipal.validate();
		this.panelPrincipal.repaint();
	}

	// ADD OUVINTE AO MENU CRAMER2x2:
	public void addOuvinteMenu2x2(ActionListener ouvinte) {
		this.mntmx.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO MENU CRAMER3x3:
	public void addOuvinteMenu3x3(ActionListener ouvinte) {
		this.mntmx_1.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO MENU LAPLACE4x4:
	public void addOuvinteMenu4x4(ActionListener ouvinte) {
		this.mntmx_4.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO MENU DESENVOLVEDORES:
	public void addOuvinteMenuDesenvolvedores(ActionListener ouvinte) {
		this.mntmx_2.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO MENU CRAMER:
	public void addOuvinteMenuCramer(ActionListener ouvinte) {
		this.mntmx_3.addActionListener(ouvinte);
	}
	
	// ADD OUVINTE AO MENU LAPLACE:
	public void addOuvinteMenuLaplace(ActionListener ouvinte) {
		this.mntmx_5.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO BTN INICIO CRAMER 2x2:
	public void addOuvinteBtnInicioCramer2x2(ActionListener ouvinte) {
		this.btnInicioCramer2x2.addActionListener(ouvinte);
	}
	
	// ADD OUVINTE AO BTN INICIO CRAMER 3x3:
	public void addOuvinteBtnInicioCramer3x3(ActionListener ouvinte) {
		this.btnInicioCramer3x3.addActionListener(ouvinte);
	}
	
	// ADD OUVINTE AO BTN INICIO CRAMER 2x2:
	public void addOuvinteBtnInicioLaplace4x4(ActionListener ouvinte) {
		this.btnInicioLaplace4x4.addActionListener(ouvinte);
	}
		
	// ADD OUVINTE AO BTN LIMPAR CRAMER:
	public void addOuvinteBtnLimparCramer(ActionListener ouvinte) {
		this.btnLimparCramer.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO BTN CALCULAR CRAMER 2x2:
	public void addOuvinteBtnCalcular2x2(ActionListener ouvinte) {
		this.btnCalcularCramer2x2.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO BTN CALCULAR CRAMER 3x3:
	public void addOuvinteBtnCalcular3x3(ActionListener ouvinte) {
		this.btnCalcularCramer3x3.addActionListener(ouvinte);
	}

	// ADD OUVINTE AO BTN CALCULAR LAPLACE 4x4:
	public void addOuvinteBtnCalcular4x4(ActionListener ouvinte) {
		this.btnCalcularLaplace4x4.addActionListener(ouvinte);
	}
}
