package starbuck.tests;

import java.awt.Color;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

public class TestCubeTournant extends TestObjetSub {
	protected Cube c ;
	private double a = 0;
	private double f = 5;
	private double D = 10;
	private double nTours = 1.5;
	@Override
	public void ginit() {
		
		super.ginit();

		scene().clear();

		Cube cube = new Cube(D, Point3D.O0, new ColorTexture(Color.GREEN));
		
		scene().lumieres().add(new LumierePointSimple(Color.YELLOW, Point3D.O0, 1.0));
		
		
		scene().add(cube);
	}
	
	public void testScene()
	{
		scene().cameras().clear();
		a += Math.PI*2/getMaxFrames()*nTours;
		Camera c = new Camera(
				new Point3D
				(
						f*D*Math.cos(a),
						0,
						f*D*Math.sin(a)
				),
				
				Point3D.O0
				);
		scene().cameraActive(c);
	}

	
	
	public static void main(String [] args)
	{
		TestCubeTournant tn = new TestCubeTournant();
		
		tn.loop(true);
		
		tn.setMaxFrames(1500);
		
		tn.setResx(640);
		
		tn.setResy(480);
		
		tn.set3D(false);
		
		tn.run();
	}
}
