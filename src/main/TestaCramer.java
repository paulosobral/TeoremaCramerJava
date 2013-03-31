package main;

import models.MontaLaplace4x4Model;

public class TestaCramer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MontaLaplace4x4Model c4 = new MontaLaplace4x4Model(3, 3, -6, -3, 2, 4, -2, -6, -1, 1, 4, -3, 2, 1, -3, -4, 1, 3, 5, 2);
		c4.calculaDeterminanteSistema();
		c4.calculaDeterminantes();
		c4.calculaDeltas();
		System.out.println("Delta de X: " + c4.getLaplace4x4().getDeltaX() + ", Delta de Y: " + c4.getLaplace4x4().getDeltaY() + ", Delta de Z: " + c4.getLaplace4x4().getDeltaZ() + ", Delta de W: " + c4.getLaplace4x4().getDeltaW());
		
	}

}
