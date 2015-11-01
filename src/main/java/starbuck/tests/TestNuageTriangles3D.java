package starbuck.tests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

public class TestNuageTriangles3D extends TestObjetSub {
	private Random r = new Random();
	public double DIM = 10.0;
	public double temps = 30.0;
	public int fps = 25;
	public int nbrObjets = 10;
	protected ArrayList<Cube> triangle = new ArrayList<Cube>();
	protected ArrayList<Point3D> vitesse = new ArrayList<Point3D>();

	@Override
	public void ginit() {
		super.ginit();

		scene().clear();

		Camera c3D = new Camera3D(Point3D.Z.mult(-DIM * 2), Point3D.O0, DIM / 5);
		scene().cameraActive(c3D);

		for (int i = 00; i < 100; i++)
			triangle.add(cube());

		for (int i = 0; i < triangle.size(); i++) {
			scene().add(triangle.get(i));
			vitesse.add(new Point3D((Math.random() - 0.5) * DIM / fps / temps
					* 100, (Math.random() - 0.5) * DIM / fps / temps * 100,
					(Math.random() - 0.5) * DIM / fps / temps * 100));
		}
	}

	public void testScene() {
		Iterator<Cube> tris = triangle.iterator();

		int i = 0;
		while (tris.hasNext()) {
			Cube t = tris.next();
			t.setPosition(t.getPosition().plus(vitesse.get(i)));
			i++;
		}
	}

	protected Cube cube() {
		Point3D p = new Point3D(Math.random() * DIM - DIM / 2, Math.random()
				* DIM - DIM / 2, Math.random() * DIM + DIM / 2);

		Cube c = new Cube(10, p);
		c.texture(new ColorTexture(Color.RED));
		
		return c;
	}

	public static void main(String[] args) {
		TestNuageTriangles3D tn = new TestNuageTriangles3D();

		tn.loop(false);

		tn.setMaxFrames(2000);

		tn.setResx(400);

		tn.setResy(300);

		tn.set3D(true);

		tn.run();
	}
}
