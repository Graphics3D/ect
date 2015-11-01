package starbuck.tests;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

public class TestBezier2D extends TestObjetSub {
	public void testScene() {
		Camera c = new Camera(new Point3D(0, 0, -15), new Point3D(0, 0, 0));

		scene().cameraActive(c);

		BezierCubique2D bc2 = new BezierCubique2D(new Point3D[][] {
				{ new Point3D(-6, -6, 0), new Point3D(-6, -2, 0),
						new Point3D(-6, 2, 0), new Point3D(-6, 6, 0) },
				{ new Point3D(-2, -6, 0), new Point3D(-2, -2, 0),
						new Point3D(-2, 2, 0), new Point3D(-2, 6, 0) },
				{ new Point3D(2, -6, 0), new Point3D(2, -2, 0),
						new Point3D(2, 2, 0), new Point3D(2, 6, 0) },
				{ new Point3D(6, -6, 0), new Point3D(6, -2, 0),
						new Point3D(6, 2, 0), new Point3D(6, 6, 0) }

		}

		);
/* Ancienne technique, couteuse en temps et espace m�moire */
		
		try {
			bc2.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(getClass()
					.getResourceAsStream("texture-bezier.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*TRIBezier2D bez = new TRIBezier2D(bc2);
		
		try {
			bez.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass()
					.getResourceAsStream("2456614033-blue-texture.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		scene().add(bez);
*/		 
	}

	public static void main(String[] args) {
		//GCOP gc = new GCOP(10);
		//gc.start();
		TestBezier2D tb = new TestBezier2D();
		tb.setResx(1000);
		tb.setResy(1000);
		tb.loop(false);
		tb.run();
	}
}
