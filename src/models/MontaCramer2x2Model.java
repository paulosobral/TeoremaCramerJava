package models;

import java.util.ArrayList;

import beans.BeanMatriz;

public class MontaCramer2x2Model implements MontaMatrizInterfaceModel {

	// BEAN MATRIZ:
	private BeanMatriz cramer2x2;

	public MontaCramer2x2Model(float x1, float x2, float y1, float y2,
			float independente1, float independente2) {

		// RECEBE OS VALORES DA ICÓGNITA X:
		ArrayList<Float> incognitasX = new ArrayList<Float>();
		incognitasX.add(x1);
		incognitasX.add(x2);

		// RECEBE OS VALORES DA ICÓGNITA Y:
		ArrayList<Float> incognitasY = new ArrayList<Float>();
		incognitasY.add(y1);
		incognitasY.add(y2);

		// RECEBE OS VALORES DOS TERMOS INDEPENDENTES:
		ArrayList<Float> independentes = new ArrayList<Float>();
		independentes.add(independente1);
		independentes.add(independente2);

		// MONTA O BEAN CRAMER COM TODOS OS VALORES:
		this.cramer2x2 = new BeanMatriz();
		this.cramer2x2.setIncognitasX(incognitasX);
		this.cramer2x2.setIncognitasY(incognitasY);
		this.cramer2x2.setIndependentes(independentes);

	}

	public void calculaDeterminanteSistema() {

		// CALCULA O POSÍTIVO:
		float positivo = this.cramer2x2.getIncognitasX().get(1)
				* this.cramer2x2.getIncognitasY().get(0);

		// CALCULA O NEGATIVO:
		float negativo = this.cramer2x2.getIncognitasX().get(0)
				* this.cramer2x2.getIncognitasY().get(1) * (-1);

		this.cramer2x2.setDeterminanteSistema(positivo + negativo);

	}

	public void calculaDeterminantes() {

		// ************************* X *****************************
		// CALCULA O POSÍTIVO:
		float positivo = this.cramer2x2.getIndependentes().get(1)
				* this.cramer2x2.getIncognitasY().get(0);

		// CALCULA O NEGATIVO:
		float negativo = this.cramer2x2.getIndependentes().get(0)
				* this.cramer2x2.getIncognitasY().get(1) * (-1);

		float determinanteX = positivo + negativo;

		// ************************* Y *****************************
		// CALCULA O POSÍTIVO:
		positivo = this.cramer2x2.getIncognitasX().get(1)
				* this.cramer2x2.getIndependentes().get(0);

		// CALCULA O NEGATIVO:
		negativo = this.cramer2x2.getIncognitasX().get(0)
				* this.cramer2x2.getIndependentes().get(1) * (-1);

		float determinanteY = positivo + negativo;

		// ADD AO BEAN:
		ArrayList<Float> determinantes = new ArrayList<Float>();
		determinantes.add(determinanteX);
		determinantes.add(determinanteY);

		this.cramer2x2.setDeterminantes(determinantes);
	}

	public void calculaDeltas() {
		this.cramer2x2.setDeltaX(this.cramer2x2.getDeterminantes().get(0)
				/ this.cramer2x2.getDeterminanteSistema());
		this.cramer2x2.setDeltaY(this.cramer2x2.getDeterminantes().get(1)
				/ this.cramer2x2.getDeterminanteSistema());
	}

	public BeanMatriz getCramer2x2() {
		return this.cramer2x2;
	}

	public void setCramer2x2(BeanMatriz Cramer2x2) {
		this.cramer2x2 = Cramer2x2;
	}

}
