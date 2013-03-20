package models;

import java.util.ArrayList;

import beans.BeanCrammer;

public class MontaCrammer2x2Model implements MontaCrammerInterfaceModel {

	// BEAN CRAMMER:
	private BeanCrammer Crammer2x2;

	public MontaCrammer2x2Model(float x1, float x2, float y1, float y2,
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

		// MONTA O BEAN CRAMMER COM TODOS OS VALORES:
		this.Crammer2x2 = new BeanCrammer();
		this.Crammer2x2.setIncognitasX(incognitasX);
		this.Crammer2x2.setIncognitasY(incognitasY);
		this.Crammer2x2.setIndependentes(independentes);

	}

	public void calculaDeterminanteSistema() {

		// CALCULA O POSÍTIVO:
		float positivo = this.Crammer2x2.getIncognitasX().get(1)
				* this.Crammer2x2.getIncognitasY().get(0);

		// CALCULA O NEGATIVO:
		float negativo = this.Crammer2x2.getIncognitasX().get(0)
				* this.Crammer2x2.getIncognitasY().get(1) * (-1);

		this.Crammer2x2.setDeterminanteSistema(positivo + negativo);

	}

	public void calculaDeterminantes() {

		// ************************* X *****************************
		// CALCULA O POSÍTIVO:
		float positivo = this.Crammer2x2.getIndependentes().get(1)
				* this.Crammer2x2.getIncognitasY().get(0);

		// CALCULA O NEGATIVO:
		float negativo = this.Crammer2x2.getIndependentes().get(0)
				* this.Crammer2x2.getIncognitasY().get(1) * (-1);

		float determinanteX = positivo + negativo;

		// ************************* Y *****************************
		// CALCULA O POSÍTIVO:
		positivo = this.Crammer2x2.getIncognitasX().get(1)
				* this.Crammer2x2.getIndependentes().get(0);

		// CALCULA O NEGATIVO:
		negativo = this.Crammer2x2.getIncognitasX().get(0)
				* this.Crammer2x2.getIndependentes().get(1) * (-1);

		float determinanteY = positivo + negativo;

		// ADD AO BEAN:
		ArrayList<Float> determinantes = new ArrayList<Float>();
		determinantes.add(determinanteX);
		determinantes.add(determinanteY);

		this.Crammer2x2.setDeterminantes(determinantes);
	}
	
	public void calculaDeltas()
	{
		this.Crammer2x2.setDeltaX(this.Crammer2x2.getDeterminantes().get(0) / this.Crammer2x2.getDeterminanteSistema());
		this.Crammer2x2.setDeltaY(this.Crammer2x2.getDeterminantes().get(1) / this.Crammer2x2.getDeterminanteSistema());
	}
	
	public void calculaCrammer(){
		calculaDeterminanteSistema();
		calculaDeterminantes();
		calculaDeltas();
	}
	
	public BeanCrammer getCrammer2x2() {
		return this.Crammer2x2;
	}
	
	public void setCrammer3x3(BeanCrammer Crammer2x2) {
		this.Crammer2x2 = Crammer2x2;
	}

}
