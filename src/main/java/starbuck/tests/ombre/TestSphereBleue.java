package starbuck.tests.ombre;

import java.awt.Color;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;

public class TestSphereBleue extends TestObjet {

	public class LumiereUtil
	{
		private double [][] coefficients;
		
		private void initCoefficients(int l)
		{
			for(int i=0; i<l; i++)
			{
				for(int j=0; j<l; j++)
				{
					
				}
			}
		}
		
		public double calculer(double composante, 
				double [] composanteLumiere)
		{
			if(coefficients==null)
			{
				initCoefficients(1+composanteLumiere.length);
			}
			return composante;
			
		}
	}
	
	private static int N = 24*5;

	@Override
	public void testScene() {
		;

		scene().clear();
		
		Color couleurLumiere = Color.RED;
		Point3D position = 
				new Point3D(5,5,-11);
				
				//Point3D.O0;
			Lumiere lp = new LumierePonctuelle(position, couleurLumiere);

		TRISphere sphere = new TRISphere(Point3D.O0, 10);
		TRISphere sphereL = new TRISphere(position, 2);
		TRISphere sphereI = new TRISphere(Point3D.O0, 9);
		sphere.texture(new TColor(Color.BLUE));
		sphereI.texture(new TColor(Color.GREEN));
		sphereL.texture(new TColor(Color.YELLOW));
		sphere.setMaxX(100);
		sphere.setMaxY(100);
		scene().add(sphere);
		scene().add(sphereI);
		scene().add(sphereL);
		scene().cameraActive(new Camera(Point3D.Z.mult(-30), Point3D.O0));
		
		scene().lumieres().add(lp);

	}

	public static void main(String[] args) {
		TestSphereBleue ts = new TestSphereBleue();
		ts.setResx(1960);
		ts.setResy(920);
		ts.loop(false);
		ts.setMaxFrames(N*5);
		ts.publishResult(true);
		ts.run();
	}
}
