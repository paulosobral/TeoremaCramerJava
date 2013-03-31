package models;

import java.util.ArrayList;

import beans.BeanMatriz;

public class MontaLaplace4x4Model implements MontaMatrizInterfaceModel {

	// BEAN CRAMMER:
	private BeanMatriz Laplace4x4;

	public MontaLaplace4x4Model(float x1, float x2, float x3, float x4,
			float y1, float y2, float y3, float y4, float z1, float z2,
			float z3, float z4, float w1, float w2, float w3, float w4,
			float independente1, float independente2, float independente3,
			float independente4) {

		// RECEBE OS VALORES DA ICÓGNITA X:
		ArrayList<Float> incognitasX = new ArrayList<Float>();
		incognitasX.add(x1);
		incognitasX.add(x2);
		incognitasX.add(x3);
		incognitasX.add(x4);

		// RECEBE OS VALORES DA ICÓGNITA Y:
		ArrayList<Float> incognitasY = new ArrayList<Float>();
		incognitasY.add(y1);
		incognitasY.add(y2);
		incognitasY.add(y3);
		incognitasY.add(y4);

		// RECEBE OS VALORES DA ICÓGNITA Z:
		ArrayList<Float> incognitasZ = new ArrayList<Float>();
		incognitasZ.add(z1);
		incognitasZ.add(z2);
		incognitasZ.add(z3);
		incognitasZ.add(z4);

		// RECEBE OS VALORES DA ICÓGNITA W:
		ArrayList<Float> incognitasW = new ArrayList<Float>();
		incognitasW.add(w1);
		incognitasW.add(w2);
		incognitasW.add(w3);
		incognitasW.add(w4);

		// RECEBE OS VALORES DOS TERMOS INDEPENDENTES:
		ArrayList<Float> independentes = new ArrayList<Float>();
		independentes.add(independente1);
		independentes.add(independente2);
		independentes.add(independente3);
		independentes.add(independente4);

		// MONTA O BEAN CRAMMER COM TODOS OS VALORES:
		this.Laplace4x4 = new BeanMatriz();
		this.Laplace4x4.setIncognitasX(incognitasX);
		this.Laplace4x4.setIncognitasY(incognitasY);
		this.Laplace4x4.setIncognitasZ(incognitasZ);
		this.Laplace4x4.setIncognitasW(incognitasW);
		this.Laplace4x4.setIndependentes(independentes);
	}

	public void calculaDeterminanteSistema() {

		// PRIMEIRO COFATOR DA SEGUNDA COLUNA:
		double cofator1 = 0;
		if (this.Laplace4x4.getIncognitasY().get(0) != 0) {
			MontaCramer3x3Model crammerCofator1 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator1.calculaDeterminanteSistema();

			cofator1 = this.Laplace4x4.getIncognitasY().get(0)
					* Math.pow(-1, 1 + 2)
					* crammerCofator1.getCramer3x3().getDeterminanteSistema();
		}

		// SEGUNDO COFATOR DA SEGUNDA COLUNA:
		double cofator2 = 0;
		if (this.Laplace4x4.getIncognitasY().get(1) != 0) {
			MontaCramer3x3Model crammerCofator2 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator2.calculaDeterminanteSistema();

			cofator2 = this.Laplace4x4.getIncognitasY().get(1)
					* Math.pow(-1, 2 + 2)
					* crammerCofator2.getCramer3x3().getDeterminanteSistema();
		}

		// TERCEIRO COFATOR DA SEGUNDA COLUNA:
		double cofator3 = 0;
		if (this.Laplace4x4.getIncognitasY().get(2) != 0) {
			MontaCramer3x3Model crammerCofator3 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator3.calculaDeterminanteSistema();

			cofator3 = this.Laplace4x4.getIncognitasY().get(2)
					* Math.pow(-1, 3 + 2)
					* crammerCofator3.getCramer3x3().getDeterminanteSistema();
		}

		// QUARTO COFATOR DA SEGUNDA COLUNA:
		double cofator4 = 0;
		if (this.Laplace4x4.getIncognitasY().get(3) != 0) {
			MontaCramer3x3Model crammerCofator4 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), 0, 0, 0);
			crammerCofator4.calculaDeterminanteSistema();

			cofator4 = this.Laplace4x4.getIncognitasY().get(3)
					* Math.pow(-1, 4 + 2)
					* crammerCofator4.getCramer3x3().getDeterminanteSistema();
		}

		this.Laplace4x4.setDeterminanteSistema((float) (cofator1 + cofator2
				+ cofator3 + cofator4));

	}

	public void calculaDeterminantes() {

		// ************************* X *****************************

		// PRIMEIRO COFATOR DA PRIMERIA COLUNA:
		double cofator1 = 0;
		if (this.Laplace4x4.getIndependentes().get(0) != 0) {
			MontaCramer3x3Model crammerCofator1 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator1.calculaDeterminanteSistema();

			cofator1 = this.Laplace4x4.getIndependentes().get(0)
					* Math.pow(-1, 1 + 1)
					* crammerCofator1.getCramer3x3().getDeterminanteSistema();

		}

		// SEGUNDO COFATOR DA PRIMEIRA COLUNA:
		double cofator2 = 0;
		if (this.Laplace4x4.getIndependentes().get(1) != 0) {
			MontaCramer3x3Model crammerCofator2 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator2.calculaDeterminanteSistema();

			cofator2 = this.Laplace4x4.getIndependentes().get(1)
					* Math.pow(-1, 2 + 1)
					* crammerCofator2.getCramer3x3().getDeterminanteSistema();
		}

		// TERCEIRO COFATOR DA PRIMEIRA COLUNA:
		double cofator3 = 0;
		if (this.Laplace4x4.getIndependentes().get(2) != 0) {
			MontaCramer3x3Model crammerCofator3 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator3.calculaDeterminanteSistema();

			cofator3 = this.Laplace4x4.getIndependentes().get(2)
					* Math.pow(-1, 3 + 1)
					* crammerCofator3.getCramer3x3().getDeterminanteSistema();
		}

		// QUARTO COFATOR DA SEGUNDA COLUNA:
		double cofator4 = 0;
		if (this.Laplace4x4.getIndependentes().get(3) != 0) {
			MontaCramer3x3Model crammerCofator4 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), 0, 0, 0);
			crammerCofator4.calculaDeterminanteSistema();

			cofator4 = this.Laplace4x4.getIndependentes().get(3)
					* Math.pow(-1, 4 + 1)
					* crammerCofator4.getCramer3x3().getDeterminanteSistema();
		}

		float determinanteX = (float) (cofator1 + cofator2 + cofator3 + cofator4);

		// ************************* Y *****************************

		// PRIMEIRO COFATOR DA SEGUNDA COLUNA:
		cofator1 = 0;
		if (this.Laplace4x4.getIndependentes().get(0) != 0) {
			MontaCramer3x3Model crammerCofator5 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator5.calculaDeterminanteSistema();

			cofator1 = this.Laplace4x4.getIndependentes().get(0)
					* Math.pow(-1, 1 + 2)
					* crammerCofator5.getCramer3x3().getDeterminanteSistema();

		}

		// SEGUNDO COFATOR DA SEGUNDA COLUNA:
		cofator2 = 0;
		if (this.Laplace4x4.getIndependentes().get(1) != 0) {
			MontaCramer3x3Model crammerCofator6 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator6.calculaDeterminanteSistema();

			cofator2 = this.Laplace4x4.getIndependentes().get(1)
					* Math.pow(-1, 2 + 2)
					* crammerCofator6.getCramer3x3().getDeterminanteSistema();
		}

		// TERCEIRO COFATOR DA SEGUNDA COLUNA:
		cofator3 = 0;
		if (this.Laplace4x4.getIndependentes().get(2) != 0) {
			MontaCramer3x3Model crammerCofator7 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator7.calculaDeterminanteSistema();

			cofator3 = this.Laplace4x4.getIndependentes().get(2)
					* Math.pow(-1, 3 + 2)
					* crammerCofator7.getCramer3x3().getDeterminanteSistema();
		}

		// QUARTO COFATOR DA SEGUNDA COLUNA:
		cofator4 = 0;
		if (this.Laplace4x4.getIndependentes().get(3) != 0) {
			MontaCramer3x3Model crammerCofator8 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), 0, 0, 0);
			crammerCofator8.calculaDeterminanteSistema();

			cofator4 = this.Laplace4x4.getIndependentes().get(3)
					* Math.pow(-1, 4 + 2)
					* crammerCofator8.getCramer3x3().getDeterminanteSistema();
		}

		float determinanteY = (float) (cofator1 + cofator2 + cofator3 + cofator4);

		// ************************* Z *****************************

		// PRIMEIRO COFATOR DA TERCEIRA COLUNA:
		cofator1 = 0;
		if (this.Laplace4x4.getIndependentes().get(0) != 0) {
			MontaCramer3x3Model crammerCofator9 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator9.calculaDeterminanteSistema();

			cofator1 = this.Laplace4x4.getIndependentes().get(0)
					* Math.pow(-1, 1 + 3)
					* crammerCofator9.getCramer3x3().getDeterminanteSistema();
		}

		// SEGUNDO COFATOR DA TERCEIRA COLUNA:
		cofator2 = 0;
		if (this.Laplace4x4.getIndependentes().get(1) != 0) {
			MontaCramer3x3Model crammerCofator10 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(2), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator10.calculaDeterminanteSistema();

			cofator2 = this.Laplace4x4.getIndependentes().get(1)
					* Math.pow(-1, 2 + 3)
					* crammerCofator10.getCramer3x3().getDeterminanteSistema();
		}

		// TERCEIRO COFATOR DA TERCEIRA COLUNA:
		cofator3 = 0;
		if (this.Laplace4x4.getIndependentes().get(2) != 0) {
			MontaCramer3x3Model crammerCofator11 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(3), 0, 0, 0);
			crammerCofator11.calculaDeterminanteSistema();

			cofator3 = this.Laplace4x4.getIndependentes().get(2)
					* Math.pow(-1, 3 + 3)
					* crammerCofator11.getCramer3x3().getDeterminanteSistema();
		}

		// QUARTO COFATOR DA TERCEIRA COLUNA:
		cofator4 = 0;
		if (this.Laplace4x4.getIndependentes().get(3) != 0) {
			MontaCramer3x3Model crammerCofator12 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasW().get(0), this.Laplace4x4
							.getIncognitasW().get(1), this.Laplace4x4
							.getIncognitasW().get(2), 0, 0, 0);
			crammerCofator12.calculaDeterminanteSistema();

			cofator4 = this.Laplace4x4.getIndependentes().get(3)
					* Math.pow(-1, 4 + 3)
					* crammerCofator12.getCramer3x3().getDeterminanteSistema();
		}

		float determinanteZ = (float) (cofator1 + cofator2 + cofator3 + cofator4);

		// ************************* W *****************************

		// PRIMEIRO COFATOR DA QUARTA COLUNA:
		cofator1 = 0;
		if (this.Laplace4x4.getIndependentes().get(0) != 0) {
			MontaCramer3x3Model crammerCofator13 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), 0, 0, 0);
			crammerCofator13.calculaDeterminanteSistema();

			cofator1 = this.Laplace4x4.getIndependentes().get(0)
					* Math.pow(-1, 1 + 4)
					* crammerCofator13.getCramer3x3().getDeterminanteSistema();
		}

		// SEGUNDO COFATOR DA QUARTA COLUNA:
		cofator2 = 0;
		if (this.Laplace4x4.getIndependentes().get(1) != 0) {
			MontaCramer3x3Model crammerCofator14 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(2), this.Laplace4x4
							.getIncognitasZ().get(3), 0, 0, 0);
			crammerCofator14.calculaDeterminanteSistema();

			cofator2 = this.Laplace4x4.getIndependentes().get(1)
					* Math.pow(-1, 2 + 4)
					* crammerCofator14.getCramer3x3().getDeterminanteSistema();
		}

		// TERCEIRO COFATOR DA QUARTA COLUNA:
		cofator3 = 0;
		if (this.Laplace4x4.getIndependentes().get(2) != 0) {
			MontaCramer3x3Model crammerCofator15 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(3), this.Laplace4x4
							.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(3), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(3), 0, 0, 0);
			crammerCofator15.calculaDeterminanteSistema();

			cofator3 = this.Laplace4x4.getIndependentes().get(2)
					* Math.pow(-1, 3 + 4)
					* crammerCofator15.getCramer3x3().getDeterminanteSistema();
		}

		// QUARTO COFATOR DA QUARTA COLUNA:
		cofator4 = 0;
		if (this.Laplace4x4.getIndependentes().get(3) != 0) {
			MontaCramer3x3Model crammerCofator16 = new MontaCramer3x3Model(
					this.Laplace4x4.getIncognitasX().get(0), this.Laplace4x4
							.getIncognitasX().get(1), this.Laplace4x4
							.getIncognitasX().get(2), this.Laplace4x4
							.getIncognitasY().get(0), this.Laplace4x4
							.getIncognitasY().get(1), this.Laplace4x4
							.getIncognitasY().get(2), this.Laplace4x4
							.getIncognitasZ().get(0), this.Laplace4x4
							.getIncognitasZ().get(1), this.Laplace4x4
							.getIncognitasZ().get(2), 0, 0, 0);
			crammerCofator16.calculaDeterminanteSistema();

			cofator4 = this.Laplace4x4.getIndependentes().get(3)
					* Math.pow(-1, 4 + 4)
					* crammerCofator16.getCramer3x3().getDeterminanteSistema();
		}

		float determinanteW = (float) (cofator1 + cofator2 + cofator3 + cofator4);

		// ADD AO BEAN:
		ArrayList<Float> determinantes = new ArrayList<Float>();
		determinantes.add(determinanteX);
		determinantes.add(determinanteY);
		determinantes.add(determinanteZ);
		determinantes.add(determinanteW);

		this.Laplace4x4.setDeterminantes(determinantes);
	}

	public void calculaDeltas() {
		this.Laplace4x4.setDeltaX(this.Laplace4x4.getDeterminantes().get(0)
				/ this.Laplace4x4.getDeterminanteSistema());
		this.Laplace4x4.setDeltaY(this.Laplace4x4.getDeterminantes().get(1)
				/ this.Laplace4x4.getDeterminanteSistema());
		this.Laplace4x4.setDeltaZ(this.Laplace4x4.getDeterminantes().get(2)
				/ this.Laplace4x4.getDeterminanteSistema());
		this.Laplace4x4.setDeltaW(this.Laplace4x4.getDeterminantes().get(3)
				/ this.Laplace4x4.getDeterminanteSistema());
	}

	public BeanMatriz getLaplace4x4() {
		return this.Laplace4x4;
	}

	public void setLaplace4x4(BeanMatriz Crammer4x4) {
		this.Laplace4x4 = Crammer4x4;
	}

}
