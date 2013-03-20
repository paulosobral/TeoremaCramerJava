package views;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.UIManager;

public class TelaSobreView extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaSobreView() {
		
		//INFO GERAL:
		super("Sobre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,600);
		setResizable(false);
		getContentPane().setLayout(null);
		
		//ICONE DO JFRAME:
		BufferedImage image = null;
        try {
            image = ImageIO.read(
                getClass().getResource("/assets/img/about.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIconImage(image);
		        
		//INFO ANHANGUERA:
		JLabel lblLogoAnhanguera = new JLabel(new ImageIcon(this.getClass().getResource("/assets/img/logoAnhanguera.png")));
		lblLogoAnhanguera.setPreferredSize(new Dimension(160, 130));
		lblLogoAnhanguera.setBounds(116, 8, 167, 130);
		getContentPane().add(lblLogoAnhanguera);
		
		JLabel lblAnhanguera = new JLabel("Trabalho desenvolvido para a Anhanguera UniA Unidade III",JLabel.CENTER);
		 
		lblAnhanguera.setBounds(35, 145, 330, 14);
		getContentPane().add(lblAnhanguera);
		
		//INFO PROFESSOR:
		JLabel lblProfessorReinaldoSimonelli = new JLabel("Professor Reinaldo Simonelli - Matem\u00E1tica Aplicada II",JLabel.CENTER);
		lblProfessorReinaldoSimonelli.setBounds(48, 165, 317, 14);
		getContentPane().add(lblProfessorReinaldoSimonelli);
		
		//INFO GRUPO:
		JLabel lblGrupo = new JLabel("Ci\u00EAncias da Computa\u00E7\u00E3o - Integrantes do Grupo 7:",JLabel.CENTER);
		lblGrupo.setBounds(50, 185, 308, 14);
		getContentPane().add(lblGrupo);
		
		JTextArea txtrGrupo = new JTextArea();
		txtrGrupo.setBackground(UIManager.getColor("Button.background"));
		txtrGrupo.setFont(new Font("Monospaced", Font.BOLD, 11));
		txtrGrupo.setEditable(false);
		txtrGrupo.setText("Andr\u00E9 Henrique\r\nRA: 4200060619\r\n\r\nFernando Lucas\r\nRA: 4200060622\r\n\r\nJorge de Oliveira\r\nRA: 4200060636\r\n\r\nLeonardo Dombrauskas\r\nRA: 4200060624\r\n\r\nMichael Sousa\r\nRA: 129992 0396\r\n\r\nPaulo Fernando\r\nRA: 3708609304");
		txtrGrupo.setBounds(135, 215, 155, 285);
		getContentPane().add(txtrGrupo);
		
		//LICENSE:
		JLabel lblLicense = new JLabel(new ImageIcon(this.getClass().getResource("/assets/img/88x31.png")));
		lblLicense.setBounds(147, 510, 111, 42);
		getContentPane().add(lblLicense);
		
		JLabel lblCreativeCommons = new JLabel("Creative Commons Attribution 3.0 Unported License.",JLabel.CENTER);
		lblCreativeCommons.setBounds(45, 552, 323, 14);
		getContentPane().add(lblCreativeCommons);
		
		//DEIXA VISÍVEL:
		setVisible(true);
	}
}
