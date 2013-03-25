package controllers;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.MontaCrammer2x2Model;
import models.MontaCrammer3x3Model;
import util.validaCamposCrammer;
import views.*;

public class CrammerController extends Thread {

	private TelaPrincipalView telaprincipal;
	private OuvinteMenu2x2 ouvinte2x2;
	private OuvinteMenu3x3 ouvinte3x3;
	private OuvinteMenuDesenvolvedores ouvintedesenvolvedores;
	private OuvinteMenuCrammer ouvintecrammer;
	private OuvinteBtnCalcular2x2 ouvintecalcular2x2;
	private OuvinteBtnCalcular3x3 ouvintecalcular3x3;
	private OuvinteBtnLimparCrammer ouvintelimparcrammer;

	public CrammerController() {
		this.telaprincipal = new TelaPrincipalView();

		this.ouvinte2x2 = new OuvinteMenu2x2();
		this.ouvinte3x3 = new OuvinteMenu3x3();
		this.ouvintedesenvolvedores = new OuvinteMenuDesenvolvedores();
		this.ouvintecrammer = new OuvinteMenuCrammer();
		this.ouvintecalcular2x2 = new OuvinteBtnCalcular2x2();
		this.ouvintecalcular3x3 = new OuvinteBtnCalcular3x3();
		this.ouvintelimparcrammer = new OuvinteBtnLimparCrammer();

		// ADD OUVINTES:
		this.telaprincipal.addOuvinteMenu2x2(ouvinte2x2);
		this.telaprincipal.addOuvinteMenu3x3(ouvinte3x3);
		this.telaprincipal
				.addOuvinteMenuDesenvolvedores(ouvintedesenvolvedores);
		this.telaprincipal.addOuvinteMenuCrammer(ouvintecrammer);
		this.telaprincipal.addOuvinteBtnCalcular2x2(ouvintecalcular2x2);
		this.telaprincipal.addOuvinteBtnCalcular3x3(ouvintecalcular3x3);
		this.telaprincipal.addOuvinteBtnLimparCrammer(ouvintelimparcrammer);
	}

	// CHAMA A TELA DE CRAMMER2X2;
	public void crammer2x2() {
		limparCrammer();
		this.telaprincipal.panelCrammer2x2.removeAll();
		this.telaprincipal.panelPrincipal.removeAll();
		this.telaprincipal.montaPainelCrammer2x2();

	}

	// CHAMA A TELA DE CRAMMER2X2;
	public void crammer3x3() {
		limparCrammer();
		this.telaprincipal.panelCrammer3x3.removeAll();
		this.telaprincipal.panelPrincipal.removeAll();
		this.telaprincipal.montaPainelCrammer3x3();
	}

	// CALCULA CRAMMER2X2;
	public void calculaCrammer2x2(validaCamposCrammer v) {
		MontaCrammer2x2Model c2 = new MontaCrammer2x2Model(v.getValoresOk()
				.get(0), v.getValoresOk().get(1), v.getValoresOk().get(2), v
				.getValoresOk().get(3), v.getValoresOk().get(4), v
				.getValoresOk().get(5));
		c2.calculaDeterminanteSistema();

		// VERIFICA SISTEMA IMCOMPATÍVEL:
		if (c2.getCrammer2x2().getDeterminanteSistema() == 0) {
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
					.getCrammer2x2().getDeterminanteSistema()));
			this.telaprincipal.tfDeltaX.setText(String.valueOf(c2
					.getCrammer2x2().getDeltaX()));
			this.telaprincipal.tfDeltaY.setText(String.valueOf(c2
					.getCrammer2x2().getDeltaY()));
		}
	}

	// CALCULA CRAMMER3X3;
	public void calculaCrammer3x3(validaCamposCrammer v) {
		MontaCrammer3x3Model c3 = new MontaCrammer3x3Model(v.getValoresOk()
				.get(0), v.getValoresOk().get(1), v.getValoresOk().get(2), v
				.getValoresOk().get(3), v.getValoresOk().get(4), v
				.getValoresOk().get(5), v.getValoresOk().get(6), v
				.getValoresOk().get(7), v.getValoresOk().get(8), v
				.getValoresOk().get(9), v.getValoresOk().get(10), v
				.getValoresOk().get(11));
		c3.calculaDeterminanteSistema();

		// VERIFICA SISTEMA IMCOMPATÍVEL:
		if (c3.getCrammer3x3().getDeterminanteSistema() == 0) {
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
					.getCrammer3x3().getDeterminanteSistema()));
			this.telaprincipal.tfDeltaX.setText(String.valueOf(c3
					.getCrammer3x3().getDeltaX()));
			this.telaprincipal.tfDeltaY.setText(String.valueOf(c3
					.getCrammer3x3().getDeltaY()));
			this.telaprincipal.tfDeltaZ.setText(String.valueOf(c3
					.getCrammer3x3().getDeltaZ()));
		}
	}

	// CHAMA A TELA DE CRAMMER2X2;
	public void limparCrammer() {
		this.telaprincipal.tfX1.setText(null);
		this.telaprincipal.tfX2.setText(null);
		this.telaprincipal.tfX3.setText(null);
		this.telaprincipal.tfY1.setText(null);
		this.telaprincipal.tfY2.setText(null);
		this.telaprincipal.tfY3.setText(null);
		this.telaprincipal.tfZ1.setText(null);
		this.telaprincipal.tfZ2.setText(null);
		this.telaprincipal.tfZ3.setText(null);
		this.telaprincipal.tfI1.setText(null);
		this.telaprincipal.tfI2.setText(null);
		this.telaprincipal.tfI3.setText(null);
		this.telaprincipal.tfDeterminanteSistema.setText(null);
		this.telaprincipal.tfDeltaX.setText(null);
		this.telaprincipal.tfDeltaY.setText(null);
		this.telaprincipal.tfDeltaZ.setText(null);

		this.telaprincipal.tfDeterminanteSistema.setEnabled(false);
		this.telaprincipal.tfDeltaX.setEnabled(false);
		this.telaprincipal.tfDeltaY.setEnabled(false);
		this.telaprincipal.tfDeltaZ.setEnabled(false);
	}

	// INICIO CLASSES INTERNAS:
	// ABRE A TELA DE CRAMMER 2X2:
	public class OuvinteMenu2x2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CrammerController.this.crammer2x2();
		}
	}

	// ABRE A TELA DE CRAMMER 2X2:
	public class OuvinteMenu3x3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CrammerController.this.crammer3x3();
		}
	}

	// ABRE TELA DESENVOLVEDORES:
	public class OuvinteMenuDesenvolvedores implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new TelaSobreView();
		}
	}

	// ABRE URL EXTERNA NO NAVEGADOR EXPLICANDO O CRAMMER:
	public class OuvinteMenuCrammer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// DEFINE A URL:
			URL url = null;
			try {
				url = new URL(
						"http://www.algosobre.com.br/matematica/sistemas-lineares-regra-de-cramer.html");
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

	// LIMPA CAMPOS DO CRAMMER:
	public class OuvinteBtnLimparCrammer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			CrammerController.this.limparCrammer();

		}
	}

	// CALCULA O CRAMMER 2X2:
	public class OuvinteBtnCalcular2x2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ArrayList<String> valores = new ArrayList<String>();
			valores.add(CrammerController.this.telaprincipal.tfX1.getText());
			valores.add(CrammerController.this.telaprincipal.tfX2.getText());
			valores.add(CrammerController.this.telaprincipal.tfY1.getText());
			valores.add(CrammerController.this.telaprincipal.tfY2.getText());
			valores.add(CrammerController.this.telaprincipal.tfI1.getText());
			valores.add(CrammerController.this.telaprincipal.tfI2.getText());

			// VALIDA O CRAMMER:
			validaCamposCrammer v = new validaCamposCrammer(valores);

			if (v.isErro() == false) {
				CrammerController.this.calculaCrammer2x2(v);
			} else {
				JOptionPane.showMessageDialog(null,
						"Por favor, informe somente números!");
				CrammerController.this.telaprincipal.tfDeltaX.setText("ERRO!");
				CrammerController.this.telaprincipal.tfDeltaY.setText("ERRO!");
				CrammerController.this.telaprincipal.tfDeterminanteSistema
						.setText("ERRO!");
			}

		}
	}

	// CALCULA O CRAMMER 3X3:
	public class OuvinteBtnCalcular3x3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			ArrayList<String> valores = new ArrayList<String>();
			valores.add(CrammerController.this.telaprincipal.tfX1.getText());
			valores.add(CrammerController.this.telaprincipal.tfX2.getText());
			valores.add(CrammerController.this.telaprincipal.tfX3.getText());
			valores.add(CrammerController.this.telaprincipal.tfY1.getText());
			valores.add(CrammerController.this.telaprincipal.tfY2.getText());
			valores.add(CrammerController.this.telaprincipal.tfY3.getText());
			valores.add(CrammerController.this.telaprincipal.tfZ1.getText());
			valores.add(CrammerController.this.telaprincipal.tfZ2.getText());
			valores.add(CrammerController.this.telaprincipal.tfZ3.getText());
			valores.add(CrammerController.this.telaprincipal.tfI1.getText());
			valores.add(CrammerController.this.telaprincipal.tfI2.getText());
			valores.add(CrammerController.this.telaprincipal.tfI3.getText());

			// VALIDA O CRAMMER:
			validaCamposCrammer v = new validaCamposCrammer(valores);

			if (v.isErro() == false) {
				CrammerController.this.calculaCrammer3x3(v);
			} else {
				JOptionPane.showMessageDialog(null,
						"Por favor, informe somente números!");
				CrammerController.this.telaprincipal.tfDeltaX.setText("ERRO!");
				CrammerController.this.telaprincipal.tfDeltaY.setText("ERRO!");
				CrammerController.this.telaprincipal.tfDeltaZ.setText("ERRO!");
				CrammerController.this.telaprincipal.tfDeterminanteSistema
						.setText("ERRO!");
			}

		}
	}

}
