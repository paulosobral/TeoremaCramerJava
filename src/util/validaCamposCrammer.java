package util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validaCamposCrammer {

	private ArrayList<Float> valoresOk;
	private boolean erro;

	public validaCamposCrammer(ArrayList<String> valores) {

		this.setErro(false);
		this.valoresOk = new ArrayList<Float>();

		// REGRA DA EXPRESS�O REGULAR (SOMENTE N�MEROS):
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = null;

		// VARRE OS VALORES PASSADOS:
		for (String valor : valores) {

			// VERIFICA SE N�O EST� NULO:
			if (!valor.trim().equals("") && valor.trim().length() > 0) {
				// VERIFICA SE O VALOR � NUM�RICO:
				matcher = pattern.matcher(valor);
				if (matcher.find()) {

					try {

						float valorOk = Float.parseFloat(valor.trim());
						this.valoresOk.add(valorOk);
						// System.out.println("add ok");
					} catch (Exception e) {
						System.out.println(e);
						// System.out.println("ERRO!!!");
						this.erro = true;
					}

				} else {

					// ERRO
					// System.out.println("N�o � n�mero! "+ valor);
					this.erro = true;

				}// FIM VERIFICA SE N�MEROS.

			} else // EST� NULO:
			{
				this.valoresOk.add((float) 1);
				// System.out.println("Est� nulo! vira 1.");
			}

		}// FIM FOREACH

	}// FIM CONSTRUTOR.

	public ArrayList<Float> getValoresOk() {
		return valoresOk;
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

}
