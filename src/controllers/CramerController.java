package controllers;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.MontaCramer2x2Model;
import models.MontaCramer3x3Model;
import models.MontaLaplace4x4Model;
import util.ValidaCamposMatriz;
import views.*;

public class CramerController extends Thread {

	private TelaPrincipalView telaprincipal;
	private OuvinteMenu2x2 ouvinte2x2;
	private OuvinteMenu3x3 ouvinte3x3;
	private OuvinteMenu4x4 ouvinte4x4;

	private OuvinteMenuDesenvolvedores ouvintedesenvolvedores;
	private OuvinteMenuCramer ouvintecramer;
	private OuvinteMenuLaplace ouvintelaplace;

	private OuvinteBtnCalcular2x2 ouvintecalcular2x2;
	private OuvinteBtnCalcular3x3 ouvintecalcular3x3;
	private OuvinteBtnCalcular4x4 ouvintecalcular4x4;
	private OuvinteBtnLimparCramer ouvintelimparcramer;

	public CramerController() {
		this.telaprincipal = new TelaPrincipalView();

		this.ouvinte2x2 = new OuvinteMenu2x2();
		this.ouvinte3x3 = new OuvinteMenu3x3();
		this.ouvinte4x4 = new OuvinteMenu4x4();

		this.ouvintedesenvolvedores = new OuvinteMenuDesenvolvedores();
		this.ouvintecramer = new OuvinteMenuCramer();
		this.ouvintelaplace = new OuvinteMenuLaplace();
		this.ouvintecalcular2x2 = new OuvinteBtnCalcular2x2();
		this.ouvintecalcular3x3 = new OuvinteBtnCalcular3x3();
		this.ouvintecalcular4x4 = new OuvinteBtnCalcular4x4();
		this.ouvintelimparcramer = new OuvinteBtnLimparCramer();

		// ADD OUVINTES:
		this.telaprincipal.addOuvinteMenu2x2(ouvinte2x2);
		this.telaprincipal.addOuvinteMenu3x3(ouvinte3x3);
		this.telaprincipal.addOuvinteMenu4x4(ouvinte4x4);
		this.telaprincipal
				.addOuvinteMenuDesenvolvedores(ouvintedesenvolvedores);
		this.telaprincipal.addOuvinteMenuCramer(ouvintecramer);
		this.telaprincipal.addOuvinteMenuLaplace(ouvintelaplace);
		this.telaprincipal.addOuvinteBtnCalcular2x2(ouvintecalcular2x2);
		this.telaprincipal.addOuvinteBtnCalcular3x3(ouvintecalcular3x3);
		this.telaprincipal.addOuvinteBtnCalcular4x4(ouvintecalcular4x4);
		this.telaprincipal.addOuvinteBtnLimparCramer(ouvintelimparcramer);
	}

	// CHAMA A TELA DE CRAMER2X2:
	public void cramer2x2() {
		limparCramer();
		this.telaprincipal.panelCramer2x2.removeAll();
		this.telaprincipal.panelPrincipal.removeAll();
		this.telaprincipal.montaPainelCramer2x2();

	}

	// CHAMA A TELA DE CRAMER2X2:
	public void cramer3x3() {
		limparCramer();
		this.telaprincipal.panelCramer3x3.removeAll();
		this.telaprincipal.panelPrincipal.removeAll();
		this.telaprincipal.montaPainelCramer3x3();
	}

	// CHAMA A TELA DE LAPLACE4x4:
	public void laplace4x4() {
		limparCramer();
		this.telaprincipal.panelLaplace4x4.removeAll();
		this.telaprincipal.panelPrincipal.removeAll();
		this.telaprincipal.montaPainelLaplace4x4();
	}

	// CALCULA CRAMER2X2;
	public void calculaCramer2x2(ValidaCamposMatriz v) {
		MontaCramer2x2Model c2 = new MontaCramer2x2Model(v.getValoresOk()
				.get(0), v.getValoresOk().get(1), v.getValoresOk().get(2), v
				.getValoresOk().get(3), v.getValoresOk().get(4), v
				.getValoresOk().get(5));
		c2.calculaDeterminanteSistema();

		// VERIFICA SISTEMA IMCOMPATÍVEL:
		if (c2.getCramer2x2().getDeterminanteSistema() == 0) {
			JOptionPane.showMessageDialog(null,
					"O determinante do sistema é 0! Sistema incompatível.");
			this.telaprincipal.tfDeterminanteSistema.setText("0");
			this.telaprincipal.tfDeltaX.setText("Sistema Incompatível");
			this.telaprincipal.tfDeltaY.setText("Sistema Incompatível");
		} else {
			c2.calculaDeterminantes();
			c2.calculaDeltas();
			this.telaprincipal.tfDeterminanteSistema.setEnabled(true);
			this.telaprincipal.tfDeltaX.setEnabled(true);
			this.telaprincipal.tfDeltaY.setEnabled(true);
			this.telaprincipal.tfDeterminanteSistema.setText(String.valueOf(c2
					.getCramer2x2().getDeterminanteSistema()));
			this.telaprincipal.tfDeltaX.setText(String.valueOf(c2
					.getCramer2x2().getDeltaX()));
			this.telaprincipal.tfDeltaY.setText(String.valueOf(c2
					.getCramer2x2().getDeltaY()));
		}
	}

	// CALCULA CRAMER3X3;
	public void calculaCramer3x3(ValidaCamposMatriz v) {
		MontaCramer3x3Model c3 = new MontaCramer3x3Model(v.getValoresOk()
				.get(0), v.getValoresOk().get(1), v.getValoresOk().get(2), v
				.getValoresOk().get(3), v.getValoresOk().get(4), v
				.getValoresOk().get(5), v.getValoresOk().get(6), v
				.getValoresOk().get(7), v.getValoresOk().get(8), v
				.getValoresOk().get(9), v.getValoresOk().get(10), v
				.getValoresOk().get(11));
		c3.calculaDeterminanteSistema();

		// VERIFICA SISTEMA IMCOMPATÍVEL:
		if (c3.getCramer3x3().getDeterminanteSistema() == 0) {
			JOptionPane.showMessageDialog(null,
					"O determinante do sistema é 0! Sistema incompatível.");
			this.telaprincipal.tfDeterminanteSistema.setText("0");
			this.telaprincipal.tfDeltaX.setText("Sistema Incompatível");
			this.telaprincipal.tfDeltaY.setText("Sistema Incompatível");
			this.telaprincipal.tfDeltaZ.setText("Sistema Incompatível");
		} else {
			c3.calculaDeterminantes();
			c3.calculaDeltas();
			this.telaprincipal.tfDeterminanteSistema.setEnabled(true);
			this.telaprincipal.tfDeltaX.setEnabled(true);
			this.telaprincipal.tfDeltaY.setEnabled(true);
			this.telaprincipal.tfDeltaZ.setEnabled(true);
			this.telaprincipal.tfDeterminanteSistema.setText(String.valueOf(c3
					.getCramer3x3().getDeterminanteSistema()));
			this.telaprincipal.tfDeltaX.setText(String.valueOf(c3
					.getCramer3x3().getDeltaX()));
			this.telaprincipal.tfDeltaY.setText(String.valueOf(c3
					.getCramer3x3().getDeltaY()));
			this.telaprincipal.tfDeltaZ.setText(String.valueOf(c3
					.getCramer3x3().getDeltaZ()));
		}
	}

	// CALCULA CRAMER3X3;
	public void calculaLaplace4x4(ValidaCamposMatriz v) {

		MontaLaplace4x4Model c4 = new MontaLaplace4x4Model(v.getValoresOk()
				.get(0), v.getValoresOk().get(1), v.getValoresOk().get(2), v
				.getValoresOk().get(3), v.getValoresOk().get(4), v
				.getValoresOk().get(5), v.getValoresOk().get(6), v
				.getValoresOk().get(7), v.getValoresOk().get(8), v
				.getValoresOk().get(9), v.getValoresOk().get(10), v
				.getValoresOk().get(11), v.getValoresOk().get(12), v
				.getValoresOk().get(13), v.getValoresOk().get(14), v
				.getValoresOk().get(15), v.getValoresOk().get(16), v
				.getValoresOk().get(17), v.getValoresOk().get(18), v
				.getValoresOk().get(19));
		c4.calculaDeterminanteSistema();

		// VERIFICA SISTEMA IMCOMPATÍVEL:
		if (c4.getLaplace4x4().getDeterminanteSistema() == 0) {
			JOptionPane.showMessageDialog(null,
					"O determinante do sistema é 0! Sistema incompatível.");
			this.telaprincipal.tfDeterminanteSistema.setText("0");
			this.telaprincipal.tfDeltaX.setText("S. Incompatível");
			this.telaprincipal.tfDeltaY.setText("S. Incompatível");
			this.telaprincipal.tfDeltaZ.setText("S. Incompatível");
			this.telaprincipal.tfDeltaW.setText("S. Incompatível");
		} else {
			c4.calculaDeterminantes();
			c4.calculaDeltas();
			this.telaprincipal.tfDeterminanteSistema.setEnabled(true);
			this.telaprincipal.tfDeltaX.setEnabled(true);
			this.telaprincipal.tfDeltaY.setEnabled(true);
			this.telaprincipal.tfDeltaZ.setEnabled(true);
			this.telaprincipal.tfDeltaW.setEnabled(true);
			this.telaprincipal.tfDeterminanteSistema.setText(String.valueOf(c4
					.getLaplace4x4().getDeterminanteSistema()));
			this.telaprincipal.tfDeltaX.setText(String.valueOf(c4
					.getLaplace4x4().getDeltaX()));
			this.telaprincipal.tfDeltaY.setText(String.valueOf(c4
					.getLaplace4x4().getDeltaY()));
			this.telaprincipal.tfDeltaZ.setText(String.valueOf(c4
					.getLaplace4x4().getDeltaZ()));
			this.telaprincipal.tfDeltaW.setText(String.valueOf(c4
					.getLaplace4x4().getDeltaW()));
		}
	}

	// LIMPA OS VALORES DO CRAMER/LAPLACE:
	public void limparCramer() {

		this.telaprincipal.tfX1.setText(null);
		this.telaprincipal.tfX2.setText(null);
		this.telaprincipal.tfX3.setText(null);
		this.telaprincipal.tfX4.setText(null);
		this.telaprincipal.tfY1.setText(null);
		this.telaprincipal.tfY2.setText(null);
		this.telaprincipal.tfY3.setText(null);
		this.telaprincipal.tfY4.setText(null);
		this.telaprincipal.tfZ1.setText(null);
		this.telaprincipal.tfZ2.setText(null);
		this.telaprincipal.tfZ3.setText(null);
		this.telaprincipal.tfZ4.setText(null);
		this.telaprincipal.tfW1.setText(null);
		this.telaprincipal.tfW2.setText(null);
		this.telaprincipal.tfW3.setText(null);
		this.telaprincipal.tfW4.setText(null);
		this.telaprincipal.tfI1.setText(null);
		this.telaprincipal.tfI2.setText(null);
		this.telaprincipal.tfI3.setText(null);
		this.telaprincipal.tfI4.setText(null);
		this.telaprincipal.tfDeterminanteSistema.setText(null);
		this.telaprincipal.tfDeltaX.setText(null);
		this.telaprincipal.tfDeltaY.setText(null);
		this.telaprincipal.tfDeltaZ.setText(null);
		this.telaprincipal.tfDeltaW.setText(null);

		this.telaprincipal.tfDeterminanteSistema.setEnabled(false);
		this.telaprincipal.tfDeltaX.setEnabled(false);
		this.telaprincipal.tfDeltaY.setEnabled(false);
		this.telaprincipal.tfDeltaZ.setEnabled(false);
		this.telaprincipal.tfDeltaW.setEnabled(false);

	}

	// INICIO CLASSES INTERNAS:
	// ABRE A TELA DE CRAMER 2X2:
	public class OuvinteMenu2x2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (CramerController.this.telaprincipal.telaInicio == false) {
				// PERGUNTA SE REALMENTE QUER BRIR O CRAMER 2x2 E PERDER
				// CRAMER ATUAL:
				int confirmaLimparCramer = JOptionPane
						.showConfirmDialog(
								null,
								"Deseja realmente iniciar uma nova matriz 2x2?\nVocê perdera esta matriz atual.",
								"Nova matriz 2x2", JOptionPane.YES_NO_OPTION);

				if (confirmaLimparCramer == JOptionPane.YES_OPTION) {
					CramerController.this.cramer2x2();
				}
			} else {
				CramerController.this.cramer2x2();
			}

		}
	}

	// ABRE A TELA DE CRAMER 2X2:
	public class OuvinteMenu3x3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (CramerController.this.telaprincipal.telaInicio == false) {
				// PERGUNTA SE REALMENTE QUER BRIR O CRAMER 3x3 E PERDER
				// CRAMER ATUAL:
				int confirmaLimparCramer = JOptionPane
						.showConfirmDialog(
								null,
								"Deseja realmente iniciar uma nova matriz 3x3?\nVocê perdera esta matriz atual.",
								"Nova matriz 3x3", JOptionPane.YES_NO_OPTION);

				if (confirmaLimparCramer == JOptionPane.YES_OPTION) {
					CramerController.this.cramer3x3();
				}
			} else {
				CramerController.this.cramer3x3();
			}

		}
	}

	// ABRE A TELA DE LAPLACE 4X$:
	public class OuvinteMenu4x4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (CramerController.this.telaprincipal.telaInicio == false) {
				// PERGUNTA SE REALMENTE QUER ABRIR O LAPLACE 4x4 E PERDER
				// MATRIZ ATUAL:
				int confirmaLimparCramer = JOptionPane
						.showConfirmDialog(
								null,
								"Deseja realmente iniciar um nova matriz 4x4?\nVocê perdera esta matriz atual.",
								"Nova matriz 4x4", JOptionPane.YES_NO_OPTION);

				if (confirmaLimparCramer == JOptionPane.YES_OPTION) {
					CramerController.this.laplace4x4();
				}
			} else {
				CramerController.this.laplace4x4();
			}

		}
	}

	// ABRE TELA DESENVOLVEDORES:
	public class OuvinteMenuDesenvolvedores implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new TelaSobreView();
		}
	}

	// ABRE URL EXTERNA NO NAVEGADOR SOBRE CRAMER:
	public class OuvinteMenuCramer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// DEFINE A URL:
			URL url = null;
			try {
				url = new URL(
						"http://pt.wikipedia.org/wiki/Gabriel_Cramer");
			} catch (MalformedURLException e2) {

				e2.printStackTrace();
			}

			// ABRE O LINK EM UM LINK EXTERNO:
			Desktop desktop = Desktop.isDesktopSupported() ? Desktop
					.getDesktop() : null;
			if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				try {
					desktop.browse(url.toURI());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}
	}
	
	// ABRE URL EXTERNA NO NAVEGADOR SOBRE LAPLACE:
	public class OuvinteMenuLaplace implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// DEFINE A URL:
			URL url = null;
			try {
				url = new URL(
						"http://pt.wikipedia.org/wiki/Pierre_Simon_Laplace");
			} catch (MalformedURLException e2) {

				e2.printStackTrace();
			}

			// ABRE O LINK EM UM LINK EXTERNO:
			Desktop desktop = Desktop.isDesktopSupported() ? Desktop
					.getDesktop() : null;
			if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				try {
					desktop.browse(url.toURI());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	// LIMPA CAMPOS DO CRAMER:
	public class OuvinteBtnLimparCramer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// PERGUNTA SE REALMENTE QUER APAGAR O CRAMER:
			int confirmaLimparMatriz = JOptionPane.showConfirmDialog(null,
					"Deseja realmente limpar esta matriz?", "Limpar Matriz",
					JOptionPane.YES_NO_OPTION);

			if (confirmaLimparMatriz == JOptionPane.YES_OPTION) {
				CramerController.this.limparCramer();
			}

		}
	}

	// CALCULA O CRAMER 2X2:
	public class OuvinteBtnCalcular2x2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ArrayList<String> valores = new ArrayList<String>();
			valores.add(CramerController.this.telaprincipal.tfX1.getText());
			valores.add(CramerController.this.telaprincipal.tfX2.getText());
			valores.add(CramerController.this.telaprincipal.tfY1.getText());
			valores.add(CramerController.this.telaprincipal.tfY2.getText());
			valores.add(CramerController.this.telaprincipal.tfI1.getText());
			valores.add(CramerController.this.telaprincipal.tfI2.getText());

			// VALIDA O CRAMER:
			ValidaCamposMatriz v = new ValidaCamposMatriz(valores);

			if (v.isErro() == false) {
				CramerController.this.calculaCramer2x2(v);
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Por favor, informe somente números (sem letras ou espaços).");
				CramerController.this.telaprincipal.tfDeltaX.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeltaY.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeterminanteSistema
						.setText("ERRO!");
			}

		}
	}

	// CALCULA O CRAMER 3X3:
	public class OuvinteBtnCalcular3x3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ArrayList<String> valores = new ArrayList<String>();
			valores.add(CramerController.this.telaprincipal.tfX1.getText());
			valores.add(CramerController.this.telaprincipal.tfX2.getText());
			valores.add(CramerController.this.telaprincipal.tfX3.getText());
			valores.add(CramerController.this.telaprincipal.tfY1.getText());
			valores.add(CramerController.this.telaprincipal.tfY2.getText());
			valores.add(CramerController.this.telaprincipal.tfY3.getText());
			valores.add(CramerController.this.telaprincipal.tfZ1.getText());
			valores.add(CramerController.this.telaprincipal.tfZ2.getText());
			valores.add(CramerController.this.telaprincipal.tfZ3.getText());
			valores.add(CramerController.this.telaprincipal.tfI1.getText());
			valores.add(CramerController.this.telaprincipal.tfI2.getText());
			valores.add(CramerController.this.telaprincipal.tfI3.getText());

			// VALIDA O CRAMER:
			ValidaCamposMatriz v = new ValidaCamposMatriz(valores);

			if (v.isErro() == false) {
				CramerController.this.calculaCramer3x3(v);
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Por favor, informe somente números (sem letras ou espaços).");
				CramerController.this.telaprincipal.tfDeltaX.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeltaY.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeltaZ.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeterminanteSistema
						.setText("ERRO!");
			}

		}
	}

	// CALCULA O LAPLACE 4X4:
	public class OuvinteBtnCalcular4x4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ArrayList<String> valores = new ArrayList<String>();
			valores.add(CramerController.this.telaprincipal.tfX1.getText());
			valores.add(CramerController.this.telaprincipal.tfX2.getText());
			valores.add(CramerController.this.telaprincipal.tfX3.getText());
			valores.add(CramerController.this.telaprincipal.tfX4.getText());
			valores.add(CramerController.this.telaprincipal.tfY1.getText());
			valores.add(CramerController.this.telaprincipal.tfY2.getText());
			valores.add(CramerController.this.telaprincipal.tfY3.getText());
			valores.add(CramerController.this.telaprincipal.tfY4.getText());
			valores.add(CramerController.this.telaprincipal.tfZ1.getText());
			valores.add(CramerController.this.telaprincipal.tfZ2.getText());
			valores.add(CramerController.this.telaprincipal.tfZ3.getText());
			valores.add(CramerController.this.telaprincipal.tfZ4.getText());
			valores.add(CramerController.this.telaprincipal.tfW1.getText());
			valores.add(CramerController.this.telaprincipal.tfW2.getText());
			valores.add(CramerController.this.telaprincipal.tfW3.getText());
			valores.add(CramerController.this.telaprincipal.tfW4.getText());
			valores.add(CramerController.this.telaprincipal.tfI1.getText());
			valores.add(CramerController.this.telaprincipal.tfI2.getText());
			valores.add(CramerController.this.telaprincipal.tfI3.getText());
			valores.add(CramerController.this.telaprincipal.tfI4.getText());

			// VALIDA O CRAMER:
			ValidaCamposMatriz v = new ValidaCamposMatriz(valores);

			if (v.isErro() == false) {
				CramerController.this.calculaLaplace4x4(v);
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Por favor, informe somente números (sem letras ou espaços).");
				CramerController.this.telaprincipal.tfDeltaX.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeltaY.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeltaZ.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeltaW.setText("ERRO!");
				CramerController.this.telaprincipal.tfDeterminanteSistema
						.setText("ERRO!");
			}

		}
	}

}
