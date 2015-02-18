package starbuck.tests;

import info.emptycanvas.library.physic.Force;
import info.emptycanvas.library.physic.Bille;
import java.awt.Color;
import java.util.Random;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;

public class TestGravite4 extends TestObjetStub {
	int X = 4;
	int Y = 4;
	int Z = 4;
	Bille[] billes;
	Force f = new Force();

	public TestGravite4() {
		this.billes = new Bille[X * Y * Z];
	}

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

        @Override
	public void testScene() {
		scene().clear();

		f.calculer();

		for (int i = 0; i < X * Y * Z; i++) {
			Representable r = new TRISphere(billes[i].position,
					//f.getDistMin() / 4);
                                        1);
			((TRISphere) r).setMaxX(8);
			((TRISphere) r).setMaxY(8);

			((TRISphere) r).texture(new TColor(billes[i].color));

			scene().add(r);

		}
		
		
		
		Camera camera = new Camera(
				billes[0].position, 
				billes[0].position.plus(billes[0].vitesse));

		scene().cameraActive(camera);

	}

	public static void main(String[] args) {

		TestGravite4 ttn = new TestGravite4();

		ttn.setResx(4*300);
		ttn.setResy(3*300);
		ttn.loop(true);
		ttn.setMaxFrames(30*25);
		ttn.publishResult(true);
		ttn.setFileExtension("png");

		ttn.run();

	}

}
