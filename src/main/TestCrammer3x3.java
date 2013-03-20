package main;

import views.TelaPrincipalView;
import views.TelaSobreView;
import models.MontaCrammer2x2Model;
import models.MontaCrammer3x3Model;

public class TestCrammer3x3 {

	
	public static void main(String[] args) {
		
		//3x3
		//MontaCrammer3x3Model c = new MontaCrammer3x3Model(2, 5, 1, 5, 3, 1, 3, -10, 1, 20, -39, 5);
		//c.calculaCrammer();
		//System.out.println("Determinante do sistema: " + c.getCrammer3x3().getDeterminanteSistema());
		//System.out.println("S: X = " + c.getCrammer3x3().getDeltaX() + ", Y = " + c.getCrammer3x3().getDeltaY() + ", Z = " + c.getCrammer3x3().getDeltaZ());
		
		//2x2
		//MontaCrammer2x2Model c2 = new MontaCrammer2x2Model(3, 1, 5, 6, 21, 20);
		//c2.calculaCrammer();
		//System.out.println("Determinante do sistema: " + c2.getCrammer2x2().getDeterminanteSistema());
		//System.out.println("S: X = " + c2.getCrammer2x2().getDeltaX() + ", Y = " + c2.getCrammer2x2().getDeltaY());
		
		TelaPrincipalView principal = new TelaPrincipalView();
		//TelaSobreView sobre = new TelaSobreView();
	}

}
