package starbuck.tests;

import info.emptycanvas.library.physics.Force;
import info.emptycanvas.library.physics.Bille;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.extra.Polyhedre;

public class TestGravite3 extends TestObjetSub {
	int X = 2;
	int Y = 2;
	int Z = 2;
	Bille[] billes = new Bille[X * Y * Z];
	Force f = new Force();

	public void ginit() {

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < Z; k++) {

					billes[k * Y * X + j * X + i] = new Bille();
					billes[k * Y * X + j * X + i].position = new Point3D(
							(i - X / 2) / 1f, (j - Y / 2) / 1f,
							(k - Z / 2) / 1f);
					billes[k * Y * X + j * X + i].vitesse = new Point3D(
							(i - X / 2) / 1f, (j - Y / 2) / 1f,
							(k - Z / 2) / 1f);
					billes[k * Y * X + j * X + i].color = new Color(1.0f * i
							/ X, 1.0f * j / Y, 1.0f * k / Z);
					billes[k * Y * X + j * X + i].masse = 1;
					billes[k * Y * X + j * X + i].attraction = 1;
					billes[k * Y * X + j * X + i].repulsion = 0.1;
					billes[k * Y * X + j * X + i].amortissement = 0.2;
				}
			}

		}

		f.configurer(billes);
	}

	public void testScene() {
		scene().clear();

		f.calculer();

		Polyhedre polyhedre = new Polyhedre();
		polyhedre.texture(new TColor(Color.BLUE));
		for (int i = 0; i < X * Y * Z; i++) {
			polyhedre.add(billes[i].position);
		}

		Camera camera = new Camera(f.centreMasse().plus(
				new Point3D(0, 0, -f.getDistMax() * 1.3)), f.centreMasse());

		scene().cameraActive(camera);

		scene().lumieres().add(
				new LumierePointSimple(
						Color.RED, f.centreMasse(), 1.0
				)
		);
		
		
		scene().add(polyhedre);

	}

	public static void main(String[] args) {

		TestGravite3 ttn = new TestGravite3();

		ttn.setResx(800);
		ttn.setResy(600);
		ttn.loop(true);
		ttn.setMaxFrames(10000);
		ttn.publishResult(true);
		ttn.setFileExtension("jpg");
		try {
			ttn.setCouleurFond(new TColor(new ECBufferedImage(ImageIO.read(new File("c:\\image.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ttn.run();

	}

}
