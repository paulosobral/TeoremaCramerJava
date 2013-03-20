package views;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TelaPrincipalView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS DO MENU PRINCIPAL:
	JMenuBar menuBar = new JMenuBar();
	JMenu mnNovoCrammer = new JMenu("Novo Crammer");
	JMenuItem mntmx = new JMenuItem("2x2");
	JMenuItem mntmx_1 = new JMenuItem("3x3");
	JMenu mnSobre = new JMenu("Sobre");
	JPanel panelPrincipal = new JPanel();
	JPanel panelInicio = new JPanel();
	
	public TelaPrincipalView() {
		
		//INFO GERAL:
		super("Teorema de Crammer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setResizable(false);
		
		//ICONE DO JFRAME:
		BufferedImage image = null;
        try {
            image = ImageIO.read(
                getClass().getResource("/assets/img/icone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIconImage(image);
		
		//MONTA O MENU PRINCIPAL:
		montaMenuPrincipal();
		
		//MONTA O PAINEL PRINCIPAL:
		montaPainelPrincipal();
		
		//MONTA O PAINEL INÍCIO:
		montaPainelInicio();
		
		setVisible(true);
	}
	
	//MONTA O MENU PRINCIPAL:
	public void montaMenuPrincipal()
	{
		this.menuBar.add(this.mnNovoCrammer);
		this.mnNovoCrammer.add(this.mntmx);
		this.mnNovoCrammer.add(this.mntmx_1);
		this.menuBar.add(this.mnSobre);
		setJMenuBar(this.menuBar);
		
	}
	
	public void montaPainelPrincipal()
	{
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(this.panelPrincipal);
	}
	
	public void montaPainelInicio()
	{
		this.panelInicio.setPreferredSize(new Dimension(500, 500));
		this.panelInicio.setMinimumSize(new Dimension(500, 500));
		this.panelInicio.add(new JLabel(new ImageIcon(this.getClass().getResource("/assets/img/telaInicio.jpg"))));
		
		this.panelPrincipal.add(panelInicio);
	}

}
