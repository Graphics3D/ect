package starbuck.tests;

import info.emptycanvas.library.physics.Force;
import info.emptycanvas.library.physics.Bille;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;

public class TestSS extends TestObjetStub {
	
	Bille[] billes =null;
	Force f = new Force();
	
	protected Color color(int n, int i)
	{
		return new Color(
				(float)(0.2+0.7*(1.0/(1+i%(n/3)))),
				(float)(0.2+0.7*(1.0/(1+(i+1)%(3)))),
				(float)(0.2+0.7*(1.0/(1+i%n)))
				);
	}
	public void ginit() {
		HashMap<String, Double> m = new HashMap<String, Double>();

		m.put("Soleil", 1.9889E+30);
		m.put("Jupiter", 1.8986E+27);
		m.put("Saturne", 5.6846E+26);
		m.put("Neptune", 1.0243E+26);
		m.put("Uranus", 8.6832E+25);
		m.put("Terre", 5.9736E+24);
		m.put("V�nus", 4.8685E+24);
		m.put("Mars", 6.4185E+23);
		m.put("Mercure", 3.302E+23);

		billes = new Bille[m.size()];

		Iterator<String> i = m.keySet().iterator();

		int a = 0;
		while (i.hasNext()) {
			String name = i.next();
			
			billes[a] = new Bille();
			
			
			billes[a].masse = m.get(name);
			billes[a].nom = name;
			billes[a].color = color(m.size(), a);
			billes[a].position =new Point3D(0, a, 0).mult(10E6); 
			billes[a].vitesse = new Point3D(Math.cos(1f*a/m.size()*2*Math.PI), Math.sin(1f*a/m.size()*2*Math.PI), 0).mult(10E6);
			a++;
		}

		f.configurer(billes);
	}

	public void testScene() {
		scene().clear();

		f.calculer();

		RepresentableConteneur rc = new RepresentableConteneur();

		for (int i = 0; i < f.getCourant().length; i++) {
			Representable r = new TRISphere(f.getCourant()[i].position,
					f.getDistMin() / 4);

			((TRISphere) r).setMaxX(20);
			((TRISphere) r).setMaxY(20);

			((TRISphere) r).texture(new TColor(f.getCourant()[i].color));

			rc.add(r);

		}

		Camera camera = new Camera(f.centreMasse().plus(
				new Point3D(0, 0, -f.getDistMax() * 3)), f.centreMasse());

		scene().cameraActive(camera);

		scene().add(rc);
	}

	public static void main(String[] args) {

		TestSS ttn = new TestSS();

		ttn.setResx(640);
		ttn.setResy(480);
		ttn.loop(true);
		ttn.setMaxFrames(10000);
		ttn.publishResult(true);
		ttn.setFileExtension("png");

		ttn.run();

	}

}
