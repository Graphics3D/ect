/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * 
 * @author Atelier
 */
public class TestAnimSIBSurvol extends TestObjetStub {

	public TestAnimSIBSurvol() {
		super();
	}

	private BezierCubique newBezier(BezierCubique old)

	{
		Point3D[] xy = new Point3D[4];
		if (old != null) {
			xy[0] = old.get(3);
		} else {
			xy[0] = new Point3D(Math.PI * (Math.random() - 0.5), Math.PI * 2
					* (Math.random() - 0.5), 0);
		}
		for (int i = 1; i < 4; i++) {
			xy[i] = new Point3D(Math.PI * (Math.random() - 0.5), Math.PI * 2
					* (Math.random() - 0.5), 0);
		}
		BezierCubique bc = new BezierCubique();
		for (int i = 0; i < 4; i++) {
			bc.add(xy[i]);
		}

		bc.setColor(Color.BLACK);

		return bc;
	}

	private static Point3D coordSphere(double a, double b, double radius) {
		return new Point3D(Math.cos(a) * Math.cos(b) * radius, 0 + Math.cos(a)
				* Math.sin(b) * radius, 0 + Math.sin(a) * radius);

	}

	private double a;
	private double b;
	private Point3D pos = Point3D.Z;
	private TRISphere ts;

	@Override
	public void ginit() {
		try {
			super.ginit();

			ts = new TRISphere(new Point3D(0, 0, 0), 100);
			ts.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(new File(
					"C:\\Emptycanvas\\textures\\spirale.jpg")))));
			scene().add(ts);
		} catch (IOException ex) {
			Logger.getLogger(TestAnimSIBSurvol.class.getName()).log(
					Level.SEVERE, null, ex);
		}

	}

	private BezierCubique bc;
	private int n = 50;
	Point3D aPos = Point3D.O0;

	@Override
	public void testScene() {

		if (frame % n == 0 || bc == null) {
			bc = newBezier(bc);
		}
		a = bc.calculerPoint3D((1.0 * ((frame + n) % n)) / n).getX();
		b = bc.calculerPoint3D((1.0 * ((frame + n) % n)) / n).getY();
		if (a > Math.PI / 2) {
			a = Math.PI / 2;
		}
		if (a < -Math.PI / 2) {
			a = -Math.PI / 2;
		}
		if (b > Math.PI) {
			a = -Math.PI;
		}
		if (b < -Math.PI) {
			a = Math.PI;
		}

		Point3D aPos = pos;
		pos = coordSphere(a, b, 90);

		scene().clear();
		scene().add(ts);

		Camera cam = new Camera(pos, pos.plus(aPos));

		Point3D[] mCam = new Point3D[3];

		mCam[0] = Point3D.vecteur(cam.getEye(), cam.getLookat()).norme1();
		mCam[1] = mCam[0].prodVect(Point3D.Y).norme1();
		mCam[2] = mCam[0].prodVect(mCam[1]);

		cam.imposerMatrice(new Matrix33(mCam));

		scene().cameraActive(cam);

		System.out.println(bc.toString());
		description("Textured sphere seen from inside");

	}

	public static void main(String[] args) {
		TestAnimSIBSurvol to = new TestAnimSIBSurvol();
		to.setResx(160);
		to.setResy(120);
		to.loop(true);
		to.setMaxFrames(1000);
		to.set3D(false);
		to.run();

	}

}
