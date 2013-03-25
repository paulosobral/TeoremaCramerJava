package beans;

import java.util.ArrayList;

public class BeanCrammer {

	// ATRIBUTOS QUE REPRESENTÃO AS ICÓGNITAS X,Y E Z:
	private ArrayList<Float> incognitasX = new ArrayList<Float>();
	private ArrayList<Float> incognitasY = new ArrayList<Float>();
	private ArrayList<Float> incognitasZ = new ArrayList<Float>();
	private ArrayList<Float> independentes = new ArrayList<Float>();
	private ArrayList<Float> determinantes = new ArrayList<Float>();
	private float determinanteSistema;
	private float deltaX;
	private float deltaY;
	private float deltaZ;

	// CONSTRUTOR VAZIO:
	public BeanCrammer() {

	}

	// CONSTRUTOR QUE SÓ RECEBE AS ICÓGNITAS E INDEPENDENTES PARA 3x3:
	public BeanCrammer(ArrayList<Float> incognitasX,
			ArrayList<Float> incognitasY, ArrayList<Float> incognitasZ,
			ArrayList<Float> independentes) {
		super();
		this.setIncognitasX(incognitasX);
		this.setIncognitasY(incognitasY);
		this.setIncognitasZ(incognitasZ);
		this.setIndependentes(independentes);
	}

	// CONSTRUTOR QUE SÓ RECEBE AS ICÓGNITAS E INDEPENDENTES PARA 2x2:
	public BeanCrammer(ArrayList<Float> incognitasX,
			ArrayList<Float> incognitasY, ArrayList<Float> independentes) {
		super();
		this.setIncognitasX(incognitasX);
		this.setIncognitasY(incognitasY);
		this.setIndependentes(independentes);
	}

	// CONSTRUTOR COMPLETO:
	public BeanCrammer(ArrayList<Float> incognitasX,
			ArrayList<Float> incognitasY, ArrayList<Float> incognitasZ,
			ArrayList<Float> independentes, ArrayList<Float> determinantes,
			float determinanteSistema, float deltaX, float deltaY, float deltaZ) {
		super();
		this.incognitasX = incognitasX;
		this.incognitasY = incognitasY;
		this.incognitasZ = incognitasZ;
		this.independentes = independentes;
		this.determinantes = determinantes;
		this.determinanteSistema = determinanteSistema;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		this.deltaZ = deltaZ;
	}

	public ArrayList<Float> getIncognitasX() {
		return incognitasX;
	}

	public void setIncognitasX(ArrayList<Float> incognitasX) {
		this.incognitasX = incognitasX;
	}

	public ArrayList<Float> getIncognitasY() {
		return incognitasY;
	}

	public void setIncognitasY(ArrayList<Float> incognitasY) {
		this.incognitasY = incognitasY;
	}

	public ArrayList<Float> getIncognitasZ() {
		return incognitasZ;
	}

	public void setIncognitasZ(ArrayList<Float> incognitasZ) {
		this.incognitasZ = incognitasZ;
	}

	public ArrayList<Float> getDeterminantes() {
		return determinantes;
	}

	public void setDeterminantes(ArrayList<Float> determinantes) {
		this.determinantes = determinantes;
	}

	public ArrayList<Float> getIndependentes() {
		return independentes;
	}

	public void setIndependentes(ArrayList<Float> independentes) {
		this.independentes = independentes;
	}

	public float getDeterminanteSistema() {
		return determinanteSistema;
	}

	public void setDeterminanteSistema(float determinanteSistema) {
		this.determinanteSistema = determinanteSistema;
	}

	public float getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(float deltaX) {
		this.deltaX = deltaX;
	}

	public float getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(float deltaY) {
		this.deltaY = deltaY;
	}

	public float getDeltaZ() {
		return deltaZ;
	}

	public void setDeltaZ(float deltaZ) {
		this.deltaZ = deltaZ;
	}

}
