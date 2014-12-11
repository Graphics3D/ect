package starbuck.tests;

import java.awt.Color;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;

public class TestSphereRot extends TestObjet {
	private TRISphere[] spheres;
	private Camera c;
	double a[] ;
	double b[] ;
	double r[] ;
	private int n; 
	@Override
	public void ginit() {
		n = 5; 
		
		r = new double [] {20, 10, 5, 2, 1};
		a = new double [] {0, 0.2, 0.3, 0.4, 0.5};
		b = new double [] {0, 0.2, 0.3, 0.4, 0.5};
		
		spheres = new TRISphere[n];
		
		for(int i=0; i<n; i++)
		{
		spheres[i] = new TRISphere(
				sphereCoord(r[i], a[i], b[i])
				, 10);
		spheres[i ] . texture(
				new TColor(
						new Color(1f, 0.5f, 1.0f*i/n)));
		}
		c = new Camera(Point3D.Z.mult(-100), Point3D.O0);
		}

public void updateData(){
	for (int i = 0; i < n; i++) {
		r[i] = r[i];
		a[i] = a[i]+1.0/100;
		b[i] = b[i]+1.0/100;
	}
		}
	
	@Override
	public void testScene() {
		updateData();
		
		scene().clear();
		for (int i = 0; i < spheres.length; i++) {
			spheres[i].
			setCentre(sphereCoord(r[i], a[i], b[i]));
			scene().add(spheres[i]);
		}
		scene().cameraActive(c);
	}

	public Point3D sphereCoord(double r, double a, double b) {
		return new Point3D(r * Math.cos(a * 2 * Math.PI)
				* Math.cos((b - 0.5) * Math.PI), r * Math.cos(a * 2 * Math.PI)
				* Math.sin((b - 0.5) * Math.PI), r * Math.sin(a * 2 * Math.PI));
	}

	public static void main(String[] args) {

		TestSphereRot ttn = new TestSphereRot();

		ttn.setResx(640);
		ttn.setResy(480);
		ttn.loop(true);
		ttn.setMaxFrames(3000);
		ttn.publishResult(true);
		ttn.setFileExtension("png");

		ttn.run();
	}

}
