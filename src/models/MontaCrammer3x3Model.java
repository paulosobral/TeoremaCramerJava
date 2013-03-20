package models;

import java.util.ArrayList;

import beans.BeanCrammer;

public class MontaCrammer3x3Model implements MontaCrammerInterfaceModel {

	// BEAN CRAMMER:
	private BeanCrammer Crammer3x3;
	
	public MontaCrammer3x3Model(float x1, float x2, float x3, float y1, float y2,
			float y3, float z1, float z2, float z3, float independente1,
			float independente2, float independente3) {

		// RECEBE OS VALORES DA ICÓGNITA X:
		ArrayList<Float> incognitasX = new ArrayList<Float>();
		incognitasX.add(x1);
		incognitasX.add(x2);
		incognitasX.add(x3);

		// RECEBE OS VALORES DA ICÓGNITA Y:
		ArrayList<Float> incognitasY = new ArrayList<Float>();
		incognitasY.add(y1);
		incognitasY.add(y2);
		incognitasY.add(y3);

		// RECEBE OS VALORES DA ICÓGNITA Z:
		ArrayList<Float> incognitasZ = new ArrayList<Float>();
		incognitasZ.add(z1);
		incognitasZ.add(z2);
		incognitasZ.add(z3);

		// RECEBE OS VALORES DOS TERMOS INDEPENDENTES:
		ArrayList<Float> independentes = new ArrayList<Float>();
		independentes.add(independente1);
		independentes.add(independente2);
		independentes.add(independente3);

		// MONTA O BEAN CRAMMER COM TODOS OS VALORES:
		this.Crammer3x3 = new BeanCrammer();
		this.Crammer3x3.setIncognitasX(incognitasX);
		this.Crammer3x3.setIncognitasY(incognitasY);
		this.Crammer3x3.setIncognitasZ(incognitasZ);
		this.Crammer3x3.setIndependentes(independentes);
	}

	public void calculaDeterminanteSistema() {

		// CALCULA OS POSÍTIVOS:
		float positivo1 = this.Crammer3x3.getIncognitasX().get(0)
				* this.Crammer3x3.getIncognitasY().get(1)
				* this.Crammer3x3.getIncognitasZ().get(2);

		float positivo2 = this.Crammer3x3.getIncognitasY().get(0)
				* this.Crammer3x3.getIncognitasZ().get(1)
				* this.Crammer3x3.getIncognitasX().get(2);

		float positivo3 = this.Crammer3x3.getIncognitasZ().get(0)
				* this.Crammer3x3.getIncognitasX().get(1)
				* this.Crammer3x3.getIncognitasY().get(2);

		// CALCULA OS NEGATIVOS:
		float negativo1 = this.Crammer3x3.getIncognitasX().get(2)
				* this.Crammer3x3.getIncognitasY().get(1)
				* this.Crammer3x3.getIncognitasZ().get(0) * (-1);

		float negativo2 = this.Crammer3x3.getIncognitasY().get(2)
				* this.Crammer3x3.getIncognitasZ().get(1)
				* this.Crammer3x3.getIncognitasX().get(0) * (-1);

		float negativo3 = this.Crammer3x3.getIncognitasZ().get(2)
				* this.Crammer3x3.getIncognitasX().get(1)
				* this.Crammer3x3.getIncognitasY().get(0) * (-1);

		this.Crammer3x3.setDeterminanteSistema(positivo1 + positivo2
				+ positivo3 + negativo1 + negativo2 + negativo3);

	}

	public void calculaDeterminantes() {

		// ************************* X *****************************
		// CALCULA OS POSÍTIVOS:
		float positivo1 = this.Crammer3x3.getIndependentes().get(0)
				* this.Crammer3x3.getIncognitasY().get(1)
				* this.Crammer3x3.getIncognitasZ().get(2);
		
		float positivo2 = this.Crammer3x3.getIncognitasY().get(0)
				* this.Crammer3x3.getIncognitasZ().get(1)
				* this.Crammer3x3.getIndependentes().get(2);

		float positivo3 = this.Crammer3x3.getIncognitasZ().get(0)
				* this.Crammer3x3.getIndependentes().get(1)
				* this.Crammer3x3.getIncognitasY().get(2);

		// CALCULA OS NEGATIVOS:
		float negativo1 = this.Crammer3x3.getIndependentes().get(2)
				* this.Crammer3x3.getIncognitasY().get(1)
				* this.Crammer3x3.getIncognitasZ().get(0) * (-1);

		float negativo2 = this.Crammer3x3.getIncognitasY().get(2)
				* this.Crammer3x3.getIncognitasZ().get(1)
				* this.Crammer3x3.getIndependentes().get(0) * (-1);

		float negativo3 = this.Crammer3x3.getIncognitasZ().get(2)
				* this.Crammer3x3.getIndependentes().get(1)
				* this.Crammer3x3.getIncognitasY().get(0) * (-1);

		float determinanteX = positivo1 + positivo2 + positivo3 + negativo1
				+ negativo2 + negativo3;

		// ************************* Y *****************************
		// CALCULA OS POSÍTIVOS:
		positivo1 = this.Crammer3x3.getIncognitasX().get(0)
				* this.Crammer3x3.getIndependentes().get(1)
				* this.Crammer3x3.getIncognitasZ().get(2);

		positivo2 = this.Crammer3x3.getIndependentes().get(0)
				* this.Crammer3x3.getIncognitasZ().get(1)
				* this.Crammer3x3.getIncognitasX().get(2);

		positivo3 = this.Crammer3x3.getIncognitasZ().get(0)
				* this.Crammer3x3.getIncognitasX().get(1)
				* this.Crammer3x3.getIndependentes().get(2);

		// CALCULA OS NEGATIVOS:
		negativo1 = this.Crammer3x3.getIncognitasX().get(2)
				* this.Crammer3x3.getIndependentes().get(1)
				* this.Crammer3x3.getIncognitasZ().get(0) * (-1);

		negativo2 = this.Crammer3x3.getIndependentes().get(2)
				* this.Crammer3x3.getIncognitasZ().get(1)
				* this.Crammer3x3.getIncognitasX().get(0) * (-1);

		negativo3 = this.Crammer3x3.getIncognitasZ().get(2)
				* this.Crammer3x3.getIncognitasX().get(1)
				* this.Crammer3x3.getIndependentes().get(0) * (-1);

		float determinanteY = positivo1 + positivo2 + positivo3 + negativo1
				+ negativo2 + negativo3;

		// ************************* Z *****************************
		// CALCULA OS POSÍTIVOS:
		positivo1 = this.Crammer3x3.getIncognitasX().get(0)
				* this.Crammer3x3.getIncognitasY().get(1)
				* this.Crammer3x3.getIndependentes().get(2);

		positivo2 = this.Crammer3x3.getIncognitasY().get(0)
				* this.Crammer3x3.getIndependentes().get(1)
				* this.Crammer3x3.getIncognitasX().get(2);

		positivo3 = this.Crammer3x3.getIndependentes().get(0)
				* this.Crammer3x3.getIncognitasX().get(1)
				* this.Crammer3x3.getIncognitasY().get(2);

		// CALCULA OS NEGATIVOS:
		negativo1 = this.Crammer3x3.getIncognitasX().get(2)
				* this.Crammer3x3.getIncognitasY().get(1)
				* this.Crammer3x3.getIndependentes().get(0) * (-1);

		negativo2 = this.Crammer3x3.getIncognitasY().get(2)
				* this.Crammer3x3.getIndependentes().get(1)
				* this.Crammer3x3.getIncognitasX().get(0) * (-1);

		negativo3 = this.Crammer3x3.getIndependentes().get(2)
				* this.Crammer3x3.getIncognitasX().get(1)
				* this.Crammer3x3.getIncognitasY().get(0) * (-1);

		float determinanteZ = positivo1 + positivo2 + positivo3 + negativo1
				+ negativo2 + negativo3;
		
		//ADD AO BEAN:
		ArrayList<Float> determinantes = new ArrayList<Float>();
		determinantes.add(determinanteX);
		determinantes.add(determinanteY);
		determinantes.add(determinanteZ);
		
		this.Crammer3x3.setDeterminantes(determinantes);
	}

	public void calculaDeltas()
	{
		this.Crammer3x3.setDeltaX(this.Crammer3x3.getDeterminantes().get(0) / this.Crammer3x3.getDeterminanteSistema());
		this.Crammer3x3.setDeltaY(this.Crammer3x3.getDeterminantes().get(1) / this.Crammer3x3.getDeterminanteSistema());
		this.Crammer3x3.setDeltaZ(this.Crammer3x3.getDeterminantes().get(2) / this.Crammer3x3.getDeterminanteSistema());
	}
	
	public void calculaCrammer(){
		calculaDeterminanteSistema();
		calculaDeterminantes();
		calculaDeltas();
	}
	
	public BeanCrammer getCrammer3x3() {
		return this.Crammer3x3;
	}
	
	public void setCrammer3x3(BeanCrammer Crammer3x3) {
		this.Crammer3x3 = Crammer3x3;
	}

}
